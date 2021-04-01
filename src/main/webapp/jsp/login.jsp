<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <title>Login</title>
    <link rel="stylesheet" href="style.css" />
  </head>
  <body>
    <%@ include file="../html/navbar.html" %>
    <div class="login container flex-container">
      <div class="card">
        <h1 class="title">Admin Login</h1>
        <div class="underline"></div>
        <form method="post" action="../login" class="login-form">
          <input type="text" name="email" id="email" placeholder="Email" />
          <input
            type="password"
            name="password"
            id="password"
            placeholder="Password"
          />
          <button name="submit" type="submit" class="btn btn-thin">
            Log in
          </button>
        </form>
      </div>
    </div>
    
    <% try {
    	if((boolean) session.getAttribute("loginError")) {
        	out.print("Wrong username or password");
        }
    } catch (Exception e) {
        
     }
    
    %>

    <script src="add-candidate.js"></script>
  </body>
</html>
