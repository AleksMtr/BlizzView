package Commands;

import DAO.*;
import DTO.*;
import java.util.InputMismatchException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class PostCommentCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        HttpSession session = request.getSession();
        
        String comment = request.getParameter("comment");
        int artID = Integer.parseInt(request.getParameter("artID"));
        if (comment != null && !comment.equals("")) {
            try {
                Object Value2 = session.getAttribute("LoggedInUser");
                User successUser = (User) Value2;
                int id = successUser.getUserID();
                CommentDao cDao = new CommentDao("Blizzview");
                ArrayList<Comment> allComments = cDao.getComments();
                
                boolean checkID = true;
                int newID = ThreadLocalRandom.current().nextInt(0, 999999);

                while (checkID != false) {
                    for (int x = 0; x < allComments.size(); x++) {
                        if (newID == allComments.get(x).getArtID()) {
                            newID = ThreadLocalRandom.current().nextInt(0, 999999);
                        } else {
                            checkID = false;
                        }
                    }
                }
                boolean action = cDao.writeComment(newID, id, artID, comment);
                if (action == true) {
                    forwardToJsp = ("index.jsp?page=viewArticle&article="+artID);
                }
            } catch (InputMismatchException e) {
                forwardToJsp = "index.jsp?page=viewArticle&article="+artID;
            }
        } else {
            forwardToJsp = "index.jsp?page=viewArticle&article="+artID;
        }
        return forwardToJsp;
    }
}
