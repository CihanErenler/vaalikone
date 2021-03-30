<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="style.css" />
    <title>Top 3 Candidates</title>
  </head>
  <body>
    <%@ include file="../html/navbar.html" %>
    <div class="container flex-container full-container">
      <div class="card">
        <div class="title">Top 3 Candidates</div>
        <div class="underline"></div>
        <div class="top-3">
          <div class="top-wrap">
            <div class="rank">2</div>
            <div class="circle" data-val="62">
              <div class="circle-half second"></div>
              <div class="circle-half second"></div>
              <div class="half"></div>
              <div class="circle-img">
                <a href="profile.html"
                  ><img src="../img/rubeus-hagrid.jpg" alt="profile-img"
                /></a>
                <span class="per">0%</span>
              </div>
            </div>
            <h2>Rebeus Hagrid</h2>
            <div class="party">Gryffindor</div>
          </div>
          <div class="top-wrap">
            <div class="rank">1</div>
            <div class="circle" data-val="85">
              <div class="circle-half"></div>
              <div class="circle-half"></div>
              <div class="half"></div>
              <div class="circle-img">
                <a href="profile.html"
                  ><img src="../img/batman.jpg" alt="profile-img"
                /></a>
                <span class="per">0%</span>
              </div>
            </div>
            <h2 class="top-name">Batman</h2>
            <div class="party">Gotham</div>
          </div>
          <div class="top-wrap">
            <div class="rank">3</div>
            <div class="circle" data-val="48">
              <div class="circle-half third"></div>
              <div class="circle-half third"></div>
              <div class="half"></div>
              <div class="circle-img">
                <a href="profile.html"
                  ><img src="../img/kratos.jpg" alt="profile-img"
                /></a>
                <span class="per">0%</span>
              </div>
            </div>
            <h2>Kratos</h2>
            <div class="party">Helheim</div>
          </div>
        </div>
        <div class="btn-container">
          <a href="../index.html" class="btn">Homepage</a>
          <a href="questions.jsp" class="btn">Retake Test</a>
        </div>
      </div>
    </div>

    <script src="../js/top3.js"></script>
  </body>
</html>