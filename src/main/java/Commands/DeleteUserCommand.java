package Commands;

import DAO.*;
import DTO.*;
import java.util.InputMismatchException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteUserCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("userID"));
            try {
                UserDao uDao = new UserDao("Blizzview");
                CommentDao cDao = new CommentDao("Blizzview");
                ArticleDao aDao = new ArticleDao("Blizzview");
                
                User u = uDao.getUserByID(id);
                try{
                cDao.deleteAuthorComments(id);
                } catch(NullPointerException e){
                    
                }
                if(u.isIsAdmin()){
                    aDao.deleteArticleByAuthor(id);
                }
                boolean action = uDao.DeleteUser(id);
                if (action == true) {
                    session.removeAttribute("LoggedInUser");
                    forwardToJsp = ("index.jsp?page=successDelete");
                }
            } catch (InputMismatchException e) {
                forwardToJsp = "index.jsp";
            }
        return forwardToJsp;
    }
}
