<body>
    <h1>Pick your Characters</h1>
    <form id="WowChar" action="FrontController" method="post">
        <h2 id="title">Enter the details for the first Character</h2>
        <div id="centerform">
            <h3 id="wowitle">Name:</h3>  <input name="name" size=30 type="text" />
            <br />
            <br />
            <h3 id="wowtitle">Realm:</h3>  <input name="realm" size=30 type="text" />
            <br />
            <h2 id="title">Enter the details for the second Character</h2>
            <br />
            <h3 id="wowitle">Name:</h3>  <input name="name2" size=30 type="text" />
            <br />
            <br />
            <h3 id="wowtitle">Realm:</h3>  <input name="realm2" size=30 type="text" />
            <br />
            <br />
            <!-- Include a hidden field to identify what the user wants to do -->
            <input type="hidden" name="action" value="compare" />
            <input type="submit" value="View Your Character" id="stats"/>
        </div>
    </form>
</body>
