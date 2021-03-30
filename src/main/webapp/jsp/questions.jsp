<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="style.css" />
    <title>Questions</title>
  </head>
  <body>
     <%@ include file="../html/navbar.html" %>
    <div class="question-page container flex-container full-container">
      <div class="card progress-card">
        <div class="progress-bar">
          <div class="bar"></div>
        </div>
        <div class="wrapper-content">
          <div class="title">
            <h1>
              Question <span class="question-index">1</span><span>/20</span>
            </h1>
          </div>
          <div class="wrapper-question">
            <!-- Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sit
            amet egestas leo, et condimentum tortor? -->
          </div>
          <form action="" method="post" id="qustions-form">
            <div class="wrapper-answer">
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
            </div>
            <div class="wrapper-btn">
              <input
                id="next"
                type="submit"
                value="Next"
                class="btn btn-thin btn-blue"
              />
              <input
                id="submit"
                type="submit"
                value="Submit"
                class="btn btn-thin btn-blue"
              />
            </div>
          </form>
        </div>
      </div>
    </div>

    <script src="../js/quesitons.js"></script>
  </body>
</html>