package Commands;

import DAO.*;
import DTO.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteCommentCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("commID"));
        int artID = Integer.parseInt(request.getParameter("artID"));
        try {
            ArticleDao aDao = new ArticleDao("Blizzview");
            CommentDao cDao = new CommentDao("Blizzview");

            boolean action = cDao.deleteComment(id);
            Article a = aDao.getArticleByID(artID);
            
            if (action == true) {
                session.setAttribute("article", a);
                forwardToJsp = "index.jsp?page=viewArticle&article="+artID;
            }
        } catch (InputMismatchException e) {

            forwardToJsp = "index.jsp?page=viewArticle&article="+artID;
        }
        return forwardToJsp;
    }
}
