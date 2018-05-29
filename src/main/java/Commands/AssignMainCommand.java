/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

public class AssignMainCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        HttpSession session = request.getSession();
        String name = request.getParameter("name");
        String realm = request.getParameter("realm");
        int id = Integer.parseInt(request.getParameter("userID"));

        if (name != null && realm != null && !name.equals("") && !realm.equals("")) {
            try {
                UserDao uDao = new UserDao("Blizzview");
                String WoWMain = (name + "/" + realm);
                boolean action = uDao.AssignWoWMain(WoWMain, id);
                User u = uDao.getUserByID(id);
                if (action == true) {
                    session.setAttribute("LoggedInUser", u);
                    forwardToJsp = ("index.jsp?page=viewUser&user=" + u.getUserName());
                }
            } catch (InputMismatchException e) {
                forwardToJsp = "error.jsp";
            }
        } else {
            forwardToJsp = "error.jsp";
        }
        return forwardToJsp;
    }
}
