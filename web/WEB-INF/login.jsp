<%-- 
    Document   : login
    Created on : Oct 15, 2021, 2:09:08 PM
    Author     : Tyler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        
        <FORM method="POST" action="login">
            <label>Username:</label>
            <input type="text" name="incoming_name" value="">
            <br>
            <label>Password:</label>
            <input type="password" name="incoming_password" value="">
            <br>
            <input type="submit" value="Log in">    
        </FORM>
        <p>${message}</p>
    </body>
</html>
