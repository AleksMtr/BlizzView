package Commands;

import DAO.*;
import DTO.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.concurrent.ThreadLocalRandom;

public class PostArticleCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        HttpSession session = request.getSession();

        String articleText = request.getParameter("content");
        String title = request.getParameter("title");

        if (articleText != null && title != null && !articleText.equals("") && !title.equals("")) {
            try {

                Object Value = session.getAttribute("LoggedInUser");
                User loggedUser = (User) Value;
                int authorID = loggedUser.getUserID();
                ArticleDao aDao = new ArticleDao("Blizzview");
                ArrayList<Article> allArticles = aDao.getArticles();
                boolean checkID = true;
                
                int newID = ThreadLocalRandom.current().nextInt(0, 9999);

                while (checkID != false) {
                    for (int x = 0; x < allArticles.size(); x++) {
                        if (newID == allArticles.get(x).getArtID()) {
                            newID = ThreadLocalRandom.current().nextInt(0, 9999);
                        } else {
                            checkID = false;
                        }
                    }
                }
                boolean action = aDao.PostArticle(newID, authorID, title, articleText);
                if (action == true) {
                    forwardToJsp = "index.jsp?page=viewArticle&article="+newID;
                }
            } catch (InputMismatchException e) {
                forwardToJsp = "index.jsp";
            }
        } else {
            forwardToJsp = "index.jsp";
        }
        return forwardToJsp;
    }
}
