package Commands;

import DAO.*;
import DTO.*;
import java.util.InputMismatchException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditArticleCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        HttpSession session = request.getSession();
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        int id = Integer.parseInt(request.getParameter("artID"));

        if (content != null && title != null && !content.equals("") && !title.equals("")) {
            try {
                ArticleDao aDao = new ArticleDao("Blizzview");

                boolean action = aDao.EditArticle(id, title, content);
                Article a = aDao.getArticleByID(id);
                if (action == true) {
                    session.setAttribute("article", a);
                    forwardToJsp = ("index.jsp?page=viewArticle&article=" + id);
                }
            } catch (InputMismatchException e) {
                forwardToJsp = "index.jsp?page=viewArticle&article="+id;
            }
        } else {
            forwardToJsp = "index.jsp?page=viewArticle&article="+id;

        }
        return forwardToJsp;
    }
}
