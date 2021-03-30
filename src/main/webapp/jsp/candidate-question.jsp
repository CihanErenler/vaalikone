<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css" integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk" crossorigin="anonymous">
    <title>Add Question</title>
    <link rel="stylesheet" href="style.css" />
  </head>
  <body>
     <%@ include file="../html/navbar.html" %>
    <div class="can-question container flex-container">
      <div class="card">
        <a href="add-candidate.jsp" class="btn btn-back">
        <i class="fas fa-chevron-left"></i> Back</a>
        <h1 class="title">Candidate's answers</h1>
        <div class="underline"></div>
        <form method="post" action="" class="question-form">
        <div class="question">
            <h2 class="index">1</h2>
            <p class="question-text">
                Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dicta
                aliquam recusandae ab, earum cum similique.
            </p>
        </div>
          <div class="answer">
            <ul>
              <li>
                <input
                  type="radio"
                  name="score"
                  id="strongly-disagree"
                  value="1"
                />
                <label for="strongly-disagree">Strongly Disagree</label>
              </li>
              <li>
                <input type="radio" name="score" id="disagree" value="2" />
                <label for="disagree">Disagree</label>
              </li>
              <li>
                <input
                  type="radio"
                  name="score"
                  id="neutral"
                  value="3"
                  checked
                />
                <label for="neutral">Neutral</label>
              </li>
              <li>
                <input type="radio" name="score" id="agree" value="4" />
                <label for="agree">Agree</label>
              </li>
              <li>
                <input
                  type="radio"
                  name="score"
                  id="strongly-agree"
                  value="5"
                />
                <label for="strongly-agree">Strongly Agree</label>
              </li>
            </ul>
          </div>
          <div class="question">
            <h2 class="index">2</h2>
            <p class="question-text">
                Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dicta
                aliquam recusandae ab, earum cum similique.
            </p>
        </div>
          <div class="answer">
            <ul>
              <li>
                <input
                  type="radio"
                  name="score"
                  id="strongly-disagree"
                  value="1"
                />
                <label for="strongly-disagree">Strongly Disagree</label>
              </li>
              <li>
                <input type="radio" name="score" id="disagree" value="2" />
                <label for="disagree">Disagree</label>
              </li>
              <li>
                <input
                  type="radio"
                  name="score"
                  id="neutral"
                  value="3"
                  checked
                />
                <label for="neutral">Neutral</label>
              </li>
              <li>
                <input type="radio" name="score" id="agree" value="4" />
                <label for="agree">Agree</label>
              </li>
              <li>
                <input
                  type="radio"
                  name="score"
                  id="strongly-agree"
                  value="5"
                />
                <label for="strongly-agree">Strongly Agree</label>
              </li>
            </ul>
          </div>
          <div class="question">
            <h2 class="index">3</h2>
            <p class="question-text">
                Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dicta
                aliquam recusandae ab, earum cum similique.
            </p>
        </div>
          <div class="answer">
            <ul>
              <li>
                <input
                  type="radio"
                  name="score"
                  id="strongly-disagree"
                  value="1"
                />
                <label for="strongly-disagree">Strongly Disagree</label>
              </li>
              <li>
                <input type="radio" name="score" id="disagree" value="2" />
                <label for="disagree">Disagree</label>
              </li>
              <li>
                <input
                  type="radio"
                  name="score"
                  id="neutral"
                  value="3"
                  checked
                />
                <label for="neutral">Neutral</label>
              </li>
              <li>
                <input type="radio" name="score" id="agree" value="4" />
                <label for="agree">Agree</label>
              </li>
              <li>
                <input
                  type="radio"
                  name="score"
                  id="strongly-agree"
                  value="5"
                />
                <label for="strongly-agree">Strongly Agree</label>
              </li>
            </ul>
          </div>
          <button name="submit-can-question" type="submit" class="btn btn-thin">
            Submit
          </button>
        </form>
      </div>
    </div>
  </body>
</html>
