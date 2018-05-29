package Commands;

import DAO.*;
import DTO.*;
import java.util.InputMismatchException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.NoSuchProviderException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EditUserCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        HttpSession session = request.getSession();
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        int id = Integer.parseInt(request.getParameter("userID"));
        UserDao uDao = new UserDao("Blizzview");
        User u2 = uDao.getUserByID(id);
        if (userName != null && email != null && !userName.equals("") && !email.equals("")) {
            try {

                boolean action = uDao.EditProfile(userName, email, id);
                User u = uDao.getUserByID(id);
                if (action == true) {
                    session.setAttribute("LoggedInUser", u);
                    forwardToJsp = ("index.jsp?page=viewUser&user=" + u.getUserName());
                }
            } catch (InputMismatchException e) {
                forwardToJsp = "index.jsp?page=viewUser&user=" + u2.getUserName();
            }
        } else {
            forwardToJsp = "index.jsp?page=viewUser&user=" + u2.getUserName();
        }
        return forwardToJsp;
    }
}
