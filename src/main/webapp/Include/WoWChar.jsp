<!DOCTYPE html>
<%@page import="java.util.*"%>
<%@page import="javax.json.*"%>
<%@page import="java.io.*"%>
<%@page import="java.net.URL"%>
<%@page import="WoWAPI.*"%>
<%@page import="DAO.*"%>
<%@page import="DTO.*"%>
<html>
    <body>
        <%
            Object Value2 = session.getAttribute("character");
            CharProfile wowChar = (CharProfile) Value2;

            int charClass = wowChar.getCharClass();
            int gender = wowChar.getGender();
            int race = wowChar.getRace();
            String realm = wowChar.getRealm();
            if (realm.contains("-")) {
                realm = realm.replace("-", " ");
            }
            String[] genderArray = {"Male", "Female"};
            String[] races = {"0", "Human", "Orc", "Dwarf", "Night Elf", "Undead", "Tauren", "Gnome", "Troll", "Goblin", "Blood Elf", "Draenei", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "Worgen", "23", "24", "Pandaren", "25", "Nightborne", "Highmountain Tauren", "Void Elf", "Lightforged Draenei", "30", "31"};
            String[] classes = {"Warlock", "Warrior", "Paladin", "Hunter", "Rogue", "Priest", "Death Knight", "Shaman", "Mage", "Warlock", "Monk", "Druid", "Demon Hunter"};
            String url = "http://render-api-eu.worldofwarcraft.com/static-render/eu/" + wowChar.getThumbnail();
        %>
        <img src="<%=url%>" alt="Thumbnail" style="width: 100px;">
        <!--<h3><%=wowChar.getThumbnail()%></h3>-->
        <h3 id="title">Character Name</h3>
        <p><%=wowChar.getName()%></p>
        <h3 id="title">Realm</h3>
        <p><%=realm%></p>
        <h3 id="title">Race & Class</h3>
        <p><%=races[race]%> <%=classes[charClass]%></p>
        <p> </p>
        <h3 id="title">Gender</h3>
        <p><%=genderArray[gender]%></p>
        <h3 id="title">Kills</h3>
        <p>Honorable Kills: <%=wowChar.getTotalHonorableKills()%></p>
        <h3 id="title">Level</h3>
        <p><%=wowChar.getLevel()%></p>
        <%
            
            Object Val = session.getAttribute("LoggedInUser");
            if (Val != null) {
            User liu = (User) Val;
            {
                
    }%>
        <form name="login" action="FrontController" method="post">
            <input type="hidden" name ="userID" value="<%=liu.getUserID()%>" />
            <input type="hidden" name ="name" value="<%=wowChar.getName()%>" />
            <input type="hidden" name ="realm" value="<%=realm%>" />
            <input type="hidden" name ="action" value="assignMain" />
            <input type="submit"  value="Assign as Main" />
        </form>
        <%}%>
    </body>
</html>
