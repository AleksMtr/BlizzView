package Commands;

import DAO.*;
import DTO.*;
import java.util.InputMismatchException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditCommCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("commID"));
        try {
            CommentDao cDao = new CommentDao("Blizzview");

            Comment c = cDao.getCommentByID(id);
            if (c!=null) {
                session.setAttribute("editComm", c);
                forwardToJsp = ("index.jsp?page=editComment");
            }
        } catch (InputMismatchException e) {
            forwardToJsp = "index.jsp";
        }
        return forwardToJsp;
    }
}
