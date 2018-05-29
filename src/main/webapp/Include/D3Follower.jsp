<%@page import="D3API.*"%>
<%@page import="java.util.ArrayList"%>
<%
    Follower follower = new Follower();
    Skills skill = new Skills();
    String fName = request.getParameter("follower");
    D3RootObject r = new D3RootObject();
    SkillsObject sO = new SkillsObject();
    follower = r.getFollower(fName);
    skill = sO.getSkills(fName);
    ArrayList <String> names = skill.getName();
    ArrayList <Integer> levels = skill.getLevel();
    ArrayList <String> descriptions = skill.getDescription();
    String name = follower.getName();
    String realName = follower.getRealName();
    String portrait = follower.getPortrait();
%>
<h1><%=realName%> the <%=name%></h1>
<img src="Images/<%=portrait%>.PNG">
<h2>Abilities: </h2>
<%
    for (int i = 0; i < 8; i++) {
        String desc = descriptions.get(i).replace("&#92;n&#92;n", "<br>");
        String dsc = desc.replace("&#92;n", "<br>");
%>
<h4><%=names.get(i)%></h4>
<p>Learned at level: <%=levels.get(i)%></p>
<p><%=dsc%></p>
<%
    }
%>