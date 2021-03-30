<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="style.css" />
    <link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.15.3/css/all.css"
      integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk"
      crossorigin="anonymous"
    />
    <title>Admin Questions</title>
  </head>
  <body>
    <%@ include file="../html/navbar.html" %>
    <div class="admin-pages container flex-container">
      <div class="card">
        <div class="admin-header">
          <h1 class="title">Questions</h1>
          <div class="underline"></div>
          <div class="admin btn-wrapper">
            <a href="admin-dashboard.jsp" class="btn btn-thin">Back</a>
            <a href="add-question.jsp" class="btn btn-thin">Add Question</a>
          </div>
        </div>
        <div class="admin-content">
          <div class="question">
            <h2 class="index">1</h2>
            <p class="question-text">
              Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dicta
              aliquam recusandae ab, earum cum similique.
            </p>
            <div class="edit-buttons">
              <a href="#" class="edit-btn question-btn">
                <i class="fas fa-pen"></i>
              </a>
              <a href="#" class="delete-btn question-btn">
                <i class="fas fa-trash-alt"></i>
              </a>
            </div>
          </div>

          <div class="question">
            <h2 class="index">1</h2>
            <p class="question-text">
              Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dicta
              aliquam recusandae ab, earum cum similique.
            </p>
            <div class="edit-buttons">
              <a href="#" class="edit-btn question-btn">
                <i class="fas fa-pen"></i>
              </a>
              <a href="#" class="delete-btn question-btn">
                <i class="fas fa-trash-alt"></i>
              </a>
            </div>
          </div>

          <div class="question">
            <h2 class="index">1</h2>
            <p class="question-text">
              Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dicta
              aliquam recusandae ab, earum cum similique.
            </p>
            <div class="edit-buttons">
              <a href="#" class="edit-btn question-btn">
                <i class="fas fa-pen"></i>
              </a>
              <a href="#" class="delete-btn question-btn">
                <i class="fas fa-trash-alt"></i>
              </a>
            </div>
          </div>

          <div class="question">
            <h2 class="index">1</h2>
            <p class="question-text">
              Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dicta
              aliquam recusandae ab, earum cum similique.
            </p>
            <div class="edit-buttons">
              <a href="#" class="edit-btn question-btn">
                <i class="fas fa-pen"></i>
              </a>
              <a href="#" class="delete-btn question-btn">
                <i class="fas fa-trash-alt"></i>
              </a>
            </div>
          </div>

          <div class="question">
            <h2 class="index">1</h2>
            <p class="question-text">
              Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dicta
              aliquam recusandae ab, earum cum similique.
            </p>
            <div class="edit-buttons">
              <a href="#" class="edit-btn question-btn">
                <i class="fas fa-pen"></i>
              </a>
              <a href="#" class="delete-btn question-btn">
                <i class="fas fa-trash-alt"></i>
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
