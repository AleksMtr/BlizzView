package Commands;

import DAO.*;
import DTO.*;
import java.util.InputMismatchException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditArtCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("artID"));
        try {
            ArticleDao aDao = new ArticleDao("Blizzview");
            Article a = aDao.getArticleByID(id);
            if (a!=null) {
                session.setAttribute("editArt", a);
                forwardToJsp = ("index.jsp?page=editArticle");
            }
        } catch (InputMismatchException e) {
            forwardToJsp = "index.jsp?page=viewArticle&article="+id;
        }
        return forwardToJsp;
    }
}
