package Commands;

import DAO.*;
import DTO.*;
import java.security.NoSuchAlgorithmException;
import java.util.InputMismatchException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";

        String user = request.getParameter("userName");
        String password = request.getParameter("password");
        if (user != null && password != null && !user.equals("") && !password.equals("")) {
            try {
                HttpSession session = request.getSession();
                UserDao userDao = new UserDao("Blizzview");
                if (user.contains("@")) {
                    user = userDao.GetUserNameByEmail(user);
                }
                User result = userDao.LogIn(user, password);
                if (result != null) {
                    session.setAttribute("LoggedInUser", result);
                    forwardToJsp = "index.jsp";
                } else if (result == null) {
                    String msg = "Login failed, please make sure the parameters are correct";
                    session.setAttribute("error", msg);
                    forwardToJsp = "index.jsp?page=login";
                }

            } catch (InputMismatchException e) {
                forwardToJsp = "index.jsp?page=login";
            } catch (NullPointerException e) {
                forwardToJsp = "index.jsp?page=login";
            }

        } else {
            forwardToJsp = "index.jsp?page=login";
        }
        return forwardToJsp;
    }
}
