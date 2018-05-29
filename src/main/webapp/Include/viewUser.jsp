<%@page import="java.util.ArrayList"%>
<%@page import="DTO.*"%>
<%@page import="DAO.*"%>
<%@page import="WoWAPI.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String uName = request.getParameter("user");
    if (uName.contains(" ")) {
        int spaceIndex = (uName.indexOf(" ") - 1);
        uName = uName.substring(0, spaceIndex);
    } else {
    }
    UserDao user = new UserDao("Blizzview");
    CommentDao cD = new CommentDao("Blizzview");
    User u = user.getUserByUserName(uName);

    ArrayList<Comment> cts = cD.getComments();
    int commentsMade = 0;
    for (Comment c : cts) {
        if (c.getcAuthor() == u.getUserID()) {
            commentsMade++;
        }
    }

    String wowMain3 = u.getWowMain();
    String realm3 = "";
    int charClass3 = 0;
    int gender3 = 0;
    int race3 = 0;

    CharProfile chara3 = new CharProfile();

    if (!wowMain3.equals("none")) {
        String[] parts = wowMain3.split("/");
        String cName3 = parts[0];
        String cRealm3 = parts[1];
        RootObject r = new RootObject();
        chara3 = r.getChar(cRealm3, cName3);
        charClass3 = chara3.getCharClass();
        gender3 = chara3.getGender();
        race3 = chara3.getRace();
        realm3 = chara3.getRealm();
        if (realm3.contains("-")) {
            realm3 = realm3.replace("-", " ");
        }
    }
    String[] genderArray3 = {"Male", "Female"};
    String[] races3 = {"0", "Human", "Orc", "Dwarf", "Night Elf", "Undead", "Tauren", "Gnome", "Troll", "Goblin", "Blood Elf", "Draenei", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "Worgen", "23", "24", "Pandaren", "25", "Nightborne", "Highmountain Tauren", "Void Elf", "Lightforged Draenei", "30", "31"};
    String[] classes3 = {"Warlock", "Warrior", "Paladin", "Hunter", "Rogue", "Priest", "Death Knight", "Shaman", "Mage", "Warlock", "Monk", "Druid", "Demon Hunter"};
    String url3 = "http://render-api-eu.worldofwarcraft.com/static-render/eu/" + chara3.getThumbnail();
%>
<div id="char1">
    <h1><%=u.getUserName()%>'s Profile</h1>
    <h2>Joined on <%=u.getJoined()%></h2>
    <h2>Comments made: <%=commentsMade%></h2>
    <%
        Object lu2 = session.getAttribute("LoggedInUser");
        String loggedUName = "";
        if (lu2 != null) {
            User LoggedInUser2 = (User) lu2;
            loggedUName = LoggedInUser2.getUserName();
            if (loggedUName.equals(uName)) {
    %>
    <a href="index.jsp?page=editProfile">Edit Profile</a>
    <a href="index.jsp?page=deleteProfile">Delete Your Account</a>
    <%
            }
        }
    %>
</div>
<%if (!wowMain3.equals("none")) {%>
<div id="char2">
    <h2>World of Warcraft Main</h2>
    <img src="<%=url3%>" alt="Thumbnail" style="width: 100px;">
    <h3 id="title">Character Name</h3>
    <p><%=chara3.getName()%></p>
    <h3 id="title">Realm</h3>
    <p><%=realm3%></p>
    <h3 id="title">Race & Class</h3>
    <p><%=races3[race3]%> <%=classes3[charClass3]%></p>
    <p> </p>
    <h3 id="title">Gender</h3>
    <p><%=genderArray3[gender3]%></p>
    <h3 id="title">Kills</h3>
    <p>Honorable Kills: <%=chara3.getTotalHonorableKills()%></p>
    <h3 id="title">Level</h3>
    <p><%=chara3.getLevel()%></p>
</div>
<%
} else if (wowMain3.equals("none") && loggedUName.equals(uName)) {%>
<div id="char2">
    <h2>You don't have a character assigned to this account.</h2>
</div>
<%} else {%>
<div id="char2">
    <h2>This user doesn't have a character assigned to this account.</h2>
    <br/>
    <br/>
    <br/>
</div>
<%}%>