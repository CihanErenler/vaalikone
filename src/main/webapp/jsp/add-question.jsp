<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="data.Question" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css" integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk" crossorigin="anonymous">
    <c:if test="${question != null}">
    <title>Edit Question</title>
    </c:if>
    <c:if test="${book == null}">
    <title>Add Question</title>
    </c:if>
    <link rel="stylesheet" href="style.css" />
  </head>
  <body>
 	 <%@ include file="../html/navbar.html" %>
    <div class="add-question container flex-container">
      <div class="card">
        <a href="admin-questions.jsp" class="btn btn-back">
        <i class="fas fa-chevron-left"></i> Back</a>
        <h1 class="title">Add Question</h1>
        <div class="underline"></div>
        <form method="post" action="" class="question-form">
          <input type="text" name="question" id="email" placeholder="Add question" />
          <button name="submit" type="submit" class="btn btn-thin">
            Submit
          </button>
        </form>
      </div>
    </div>
  </body>
</html>
