package Commands;

import DAO.*;
import DTO.*;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.concurrent.ThreadLocalRandom;

public class RegisterCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String email = request.getParameter("email");

        if (userName != null && password != null && !userName.equals("") && !password.equals("") && !email.equals("") && password.equals(password2)) {
            try {

                HttpSession session = request.getSession();

                boolean Structure = password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$");

                boolean noConditions = !(password.contains("AND") || password.contains("NOT")); //|| password.contains("not") || password.contains("and"))
                boolean noUsername = !(password.contains(userName));
                boolean noSpaces = !(userName.contains(" "));// No Spaces in username
                boolean nopassword1 = !(password.contains("password1"));

                if (userName.length() < 3) {
                    String error = "Your username must be at least 3 characters in Length";
                    session.setAttribute("Complexity", error);
                    forwardToJsp = "RegRetry.jsp";
                }

                if (!Structure) {
                    String error = "Your password must be at least 8 characters in Length, one Number, "
                            + "one Upper-Case, one Lower-case and no Spaces";
                    session.setAttribute("Complexity", error);
                    forwardToJsp = "RegRetry.jsp";
                }

                if (!noConditions) {
                    String error = "Your password must not contain any conditions e.g AND/OR";
                    session.setAttribute("Complexity", error);
                    forwardToJsp = "RegRetry.jsp";
                }

                if (!noUsername) {
                    String error = "Your password must not contain Your UserName";
                    session.setAttribute("Complexity", error);
                    forwardToJsp = "RegRetry.jsp";
                }

                if (!noSpaces) {
                    String error = "Your Username must not contain Spaces";
                    session.setAttribute("Complexity", error);
                    forwardToJsp = "RegRetry.jsp";
                }
                if (!nopassword1) {
                    String error = "Your password must not contain password1 try to think of better passwords";
                    session.setAttribute("Complexity", error);
                    forwardToJsp = "RegRetry.jsp";
                }

                UserDao uDao = new UserDao("Blizzview");

                boolean checkID = true;
                boolean checkEmail = false;
                boolean checkUserName = false;

                ArrayList<User> Accounts = uDao.GetAllUsers();

                for (int x = 0; x < Accounts.size(); x++) {
                    if (email.equals(Accounts.get(x).getEmail())) {

                        checkEmail = true;
                    }
                }
                for (int x = 0; x < Accounts.size(); x++) {
                    if (userName.toLowerCase().equals(Accounts.get(x).getUserName().toLowerCase())) {
                        checkUserName = true;
                    }
                }
                int userID = ThreadLocalRandom.current().nextInt(0, 999999);

                while (checkID != false) {
                    for (int x = 0; x < Accounts.size(); x++) {
                        if (userID == Accounts.get(x).getUserID()) {
                            userID = ThreadLocalRandom.current().nextInt(0, 999999);
                        } else {
                            checkID = false;
                        }
                    }
                }
                if (Structure && noConditions && noUsername && noSpaces && checkEmail == false && checkUserName == false) {

                    boolean Action = uDao.RegisterUser(userID, userName, email, password);

                    if (Action == true) {
                        User user = uDao.getUserByUserName(userName);
                          forwardToJsp = "index.jsp";
                    } else if (Action == false) {
                        forwardToJsp = "index.jsp?page=register";
                    }
                } else if (checkEmail == true) {
                    forwardToJsp = "index.jsp?page=register";

                } else if (checkUserName == true) {
                    forwardToJsp = "index.jsp?page=register";
                }
            } catch (Exception ex) {
                forwardToJsp = "index.jsp?page=register";
            }
        } else {
            forwardToJsp = "index.jsp?page=register";
        }
        return forwardToJsp;
    }
}
