<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.15.3/css/all.css"
      integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk"
      crossorigin="anonymous"
    />
    <title>Profile</title>
    <link rel="stylesheet" href="style.css" />
  </head>
  <body>
    <%@ include file="../html/navbar.html" %>
    <div class="container flex-container">
      <div class="card profile p-x-11">
        <div class="profile-info">
          <div class="profile-img-wrapper">
            <img src="../img/rubeus-hagrid.jpg" alt="prfile-img" />
          </div>
          <div class="profile-name-info">
            <div class="first-line">
              <h2>Rubeus Hagrid</h2>
              <h4><span class="age">Age :</span> 72</h4>
              <h4>Teacher</h4>
            </div>
            <div class="second-line">
              <h4>
                <i class="fas fa-map-marker"></i>
                Hogwarts
              </h4>
              <div class="party">Gryffindor</div>
            </div>
          </div>
        </div>

        <div class="about-text-sec">
          <div class="about-text">
            <h2>About</h2>
            <p>
              Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid
              eius nam maxime vero saepe perferendis! Aspernatur, rerum
              exercitationem odit ex assumenda incidunt nemo sunt eveniet
              voluptate dolorem facilis numquam minima.
            </p>
          </div>
          <div class="why-text">
            <h2>Why did you became a candidate?</h2>
            <p>
              Lorem ipsum dolor sit amet consectetur adipisicing elit.
              Temporibus pariatur voluptate repudiandae aut quidem modi animi
              amet fuga quisquam at sunt illo commodi, vitae numquam id
              reprehenderit consectetur quod ullam.
            </p>
          </div>
        </div>

        <h1 class="title">Questionnaire Answers</h1>
        <div class="underline"></div>

        <div class="questions">
          <div class="question">
            <h2 class="index">1</h2>
            <p class="question-text">
              Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dicta
              aliquam recusandae ab, earum cum similique.
            </p>
            <div class="question-answer">Agree</div>
          </div>
        </div>

        <div class="questions">
          <div class="question">
            <h2 class="index">1</h2>
            <p class="question-text">
              Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dicta
              aliquam recusandae ab, earum cum similique.
            </p>
            <div class="question-answer">Agree</div>
          </div>
        </div>

        <div class="questions">
          <div class="question">
            <h2 class="index">1</h2>
            <p class="question-text">
              Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dicta
              aliquam recusandae ab, earum cum similique.
            </p>
            <div class="question-answer">Agree</div>
          </div>
        </div>

        <div class="questions">
          <div class="question">
            <h2 class="index">1</h2>
            <p class="question-text">
              Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dicta
              aliquam recusandae ab, earum cum similique.
            </p>
            <div class="question-answer">Agree</div>
          </div>
        </div>

        <div class="questions">
          <div class="question">
            <h2 class="index">1</h2>
            <p class="question-text">
              Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dicta
              aliquam recusandae ab, earum cum similique.
            </p>
            <div class="question-answer">Agree</div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
