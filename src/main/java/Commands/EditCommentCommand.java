package Commands;

import DAO.*;
import DTO.*;
import java.util.InputMismatchException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditCommentCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        HttpSession session = request.getSession();
        String content = request.getParameter("content");
        int id = Integer.parseInt(request.getParameter("cID"));
        ArticleDao aDao = new ArticleDao("Blizzview");
        CommentDao cDao = new CommentDao("Blizzview");
        Comment c = cDao.getCommentByID(id);
        Article a = aDao.getArticleByID(c.getArtID());
        if (content != null && !content.equals("")) {
            try {

                Boolean action = cDao.editComment(id, content);
                if (action == true) {
                    session.setAttribute("article", a);
                    forwardToJsp = ("index.jsp?page=viewArticle&article=" + c.getArtID());
                }
            } catch (InputMismatchException e) {
                forwardToJsp = "index.jsp?page=viewArticle&article=" + c.getArtID();
            }
        } else {
            forwardToJsp = "index.jsp?page=viewArticle&article=" + c.getArtID();
        }
        return forwardToJsp;
    }
}
