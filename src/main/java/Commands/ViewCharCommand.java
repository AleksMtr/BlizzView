package Commands;

import WoWAPI.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ViewCharCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";

        String charName = request.getParameter("name");
        String realm = request.getParameter("realm");
        if (charName != null && realm != null && !charName.equals("") && !realm.equals("")) {
            try {
                HttpSession session = request.getSession();
                if(realm.contains(" ")){
                    realm = realm.replace(" ", "-");
                }
                RootObject r = new RootObject();
                CharProfile chara = r.getChar(realm, charName);

                if (chara != null) {
                    session.setAttribute("character", chara);
                    forwardToJsp = "index.jsp?page=wowChar";
                }

            } catch (Exception ex) {
                forwardToJsp = "index.jsp?page=viewChar";
            }
        }
        return forwardToJsp;
    }
}
