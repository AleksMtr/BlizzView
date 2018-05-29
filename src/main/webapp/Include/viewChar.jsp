<!DOCTYPE html>
<html>
    <body>
        <form id="WowChar" action="FrontController" method="post">
            <h2 id="title">Enter the details to see info</h2>
            <div id="centerform">
                <h3 id="wowitle">Name:</h3>  <input name="name" size=30 type="text" />
                <br />
                <br />
                <h3 id="wowtitle">Realm:</h3>  <input name="realm" size=30 type="text" />
                <br />
                <br />
                <!-- Include a hidden field to identify what the user wants to do -->
                <input type="hidden" name="action" value="viewChar" />
                <input type="submit" value="View Your Character" id="stats"/>
            </div>
        </form>
    </body>
</html>
