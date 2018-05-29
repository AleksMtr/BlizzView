package Commands;

import DAO.*;
import DTO.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteArticleCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("artID"));
        try {
            
            ArticleDao aDao = new ArticleDao("Blizzview");
            CommentDao cDao = new CommentDao("Blizzview");

            ArrayList <Comment> comments = cDao.getCommentsByArticle(id);
            if(!comments.isEmpty()){
                cDao.deleteArticleComments(id);
            }
            
            boolean action = aDao.deleteArticle(id);
            if (action == true) {
                forwardToJsp = "index.jsp";
            }
        } catch (InputMismatchException e) {

            forwardToJsp = "index.jsp";
        }
        return forwardToJsp;
    }
}
