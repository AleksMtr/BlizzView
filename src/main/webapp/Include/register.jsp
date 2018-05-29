<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <form name="reg" action="FrontController" method="post">
                <h3>SIGN-UP NOW</h3>
                
                Username  :  <input name="userName" size=30 type="text" maxlength="20" placeholder="Username"  /><<br>
                
                Email : <input name="email" size=30 type="email" maxlength="30" placeholder="Email" /><br>
                <!--<script src="Includes/autocomplete.js"></script>-->
                
                Password  : <input name="password"  size=30 type="password" placeholder="Password" /><br>
                <p>Your password must contain at least one capital letter and at least one number.</p>
                Re-Enter Password: <input name="password2"  size=30 type="password" placeholder="Re-Enter Password" /><br>
                
                <input type="submit" id="btnSubmit" value="Register" />
                
                <!-- Include a hidden field to identify what the user wants to do -->
                <input type="hidden" name ="action" value="register" />
            </form>
    </body>
</html>
