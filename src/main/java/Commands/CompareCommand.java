package Commands;

import WoWAPI.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CompareCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";

        String charName = request.getParameter("name");
        String realm = request.getParameter("realm");
        String charName2 = request.getParameter("name2");
        String realm2 = request.getParameter("realm2");
        if (charName != null && realm != null && !charName.equals("") && !realm.equals("") && charName2 != null && realm2 != null && !charName2.equals("") && !realm2.equals("")) {
            try {
                HttpSession session = request.getSession();
                if(realm.contains(" ")){
                    realm = realm.replace(" ", "-");
                }
                if(realm2.contains(" ")){
                    realm = realm.replace(" ", "-");
                }
                RootObject r = new RootObject();
                CharProfile chara = r.getChar(realm, charName);
                CharProfile chara2 = r.getChar(realm2, charName2);
                if (chara != null) {
                    session.setAttribute("character", chara);
                    session.setAttribute("character2", chara2);
                    forwardToJsp = "index.jsp?page=viewCompare";
                }

            } catch (Exception ex) {
                forwardToJsp = "index.jsp?page=compare";
            }
        }
        return forwardToJsp;
    }
}
