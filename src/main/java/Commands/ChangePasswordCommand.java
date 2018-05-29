package Commands;

import DAO.*;
import DTO.*;
import java.util.InputMismatchException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangePasswordCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        HttpSession session = request.getSession();
        String oldPass = request.getParameter("oldPass");
        String newPass = request.getParameter("newPass");
        String confirmPass = request.getParameter("confirmPass");
        int id = Integer.parseInt(request.getParameter("userID"));
        Object Value = session.getAttribute("LoggedInUser");
        User LoggedInUser = (User) Value;
        if (oldPass.equals(LoggedInUser.getPassword()) && newPass.equals(confirmPass) && !newPass.equals(oldPass) && oldPass != null && newPass != null && confirmPass != null && !oldPass.equals("") && !newPass.equals("") && !confirmPass.equals("")) {
            try {
                UserDao uDao = new UserDao("Blizzview");
                boolean action = uDao.ChangePassword(newPass, id);
                User u = uDao.getUserByID(id);
                if (action == true) {
                    session.setAttribute("LoggedInUser", u);
                    forwardToJsp = ("index.jsp?page=viewUser&user=" + u.getUserName());
                }
            } catch (InputMismatchException e) {
                forwardToJsp = "index.jsp?page=changePassword";
            }
        } else {
            forwardToJsp = "index.jsp?page=changePassword";
        }
        return forwardToJsp;
    }
}
