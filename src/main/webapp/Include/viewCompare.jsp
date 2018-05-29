<!DOCTYPE html>
<%@page import="java.util.*"%>
<%@page import="javax.json.*"%>
<%@page import="java.io.*"%>
<%@page import="java.net.URL"%>
<%@page import="WoWAPI.*"%>
<html>
    <body>
        <%
            Object Value2 = session.getAttribute("character");
            Object Value3 = session.getAttribute("character2");
            
            CharProfile wowChar = (CharProfile) Value2;
            CharProfile wowChar2 = (CharProfile) Value3;
            
            int charClass = wowChar.getCharClass();
            int charClass2 = wowChar2.getCharClass();
            int gender = wowChar.getGender();
            int gender2 = wowChar2.getGender();
            int race = wowChar.getRace();
            int race2 = wowChar2.getRace();
            String realm = wowChar.getRealm();
            if (realm.contains("-")) {
                realm = realm.replace("-", " ");
            }
            String realm2 = wowChar2.getRealm();
            if (realm2.contains("-")) {
                realm2 = realm2.replace("-", " ");
            }
            String[] genderArray = {"Male", "Female"};
            String[] races = {"0", "Human", "Orc", "Dwarf", "Night Elf", "Undead", "Tauren", "Gnome", "Troll", "Goblin", "Blood Elf", "Draenei", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "Worgen", "23", "24", "Pandaren", "25", "Nightborne", "Highmountain Tauren", "Void Elf", "Lightforged Draenei", "30", "31"};
            String[] classes = {"Warlock", "Warrior", "Paladin", "Hunter", "Rogue", "Priest", "Death Knight", "Shaman", "Mage", "Warlock", "Monk", "Druid", "Demon Hunter"};
            String url = "http://render-api-eu.worldofwarcraft.com/static-render/eu/" + wowChar.getThumbnail();
            String url2 = "http://render-api-eu.worldofwarcraft.com/static-render/eu/" + wowChar2.getThumbnail();
        %>
        <div id="char1">
        <img src="<%=url%>" alt="Thumbnail" style="width: 100px;">
        <!--<h3><%=wowChar.getThumbnail()%></h3>-->
        <h3 id="title">Character Name</h3>
        <p><%=wowChar.getName()%></p>
        <h3 id="title">Realm</h3>
        <p><%=realm%></p>
        <h3 id="title">Race & Class</h3>
        <p><%=races[race]%> (<%=race%>) <%=classes[charClass]%> (<%=charClass%>)</p>
        <p> </p>
        <h3 id="title">Gender</h3>
        <p><%=genderArray[gender]%></p>
        <h3 id="title">Kills</h3>
        <p>Honorable Kills: <%=wowChar.getTotalHonorableKills()%></p>
        </div>
        
        <div id="char2">
        <img src="<%=url2%>" alt="Thumbnail" style="width: 100px;">
        <!--<h3><%=wowChar2.getThumbnail()%></h3>-->
        <h3 id="title">Character Name</h3>
        <p><%=wowChar2.getName()%></p>
        <h3 id="title">Realm</h3>
        <p><%=realm2%></p>
        <h3 id="title">Race & Class</h3>
        <p><%=races[race2]%> (<%=race2%>) <%=classes[charClass2]%> (<%=charClass2%>)</p>
        <p> </p>
        <h3 id="title">Gender</h3>
        <p><%=genderArray[gender2]%></p>
        <h3 id="title">Kills</h3>
        <p>Honorable Kills: <%=wowChar2.getTotalHonorableKills()%></p>
        </div>
    </body>
</html>
