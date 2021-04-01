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
    <title>Candidates</title>
    <link rel="stylesheet" href="style.css" />
  </head>
  <body>
    <%@ include file="../html/navbar.html" %>
    <div class="candidates container">
      <h1 class="title">Candidates</h1>
      <div class="underline"></div>
      <div class="candidates-wrapper">
        <a href="/ShowCan?id=1">
          <div class="can-card">
            <div class="img-wrap">
              <img src="../img/batman.jpg" alt="candidate" />
            </div>
            <div class="can-content">
              <div class="can-name-info">
                <h3>Batman</h3>
                <h4><span class="age">Age :</span> 72</h4>
                <h4>
                  <i class="fas fa-map-marker"></i>
                  Gotham
                </h4>
              </div>
              <div class="party">Gotham</div>
              <div class="short-about">
                Lorem, ipsum dolor sit amet consectetur adipisicing elit.
                Placeat, corporis. Error quidem aperiam dignissimos, voluptatem,
                quae quo vitae distinctio nulla praesentium temporibus, quis
                accusantium doloribus omnis. Quibusdam soluta aliquid
                temporibus?
              </div>
            </div>
          </div>
        </a>

        <a href="/ShowCan?id=2">
          <div class="can-card">
            <div class="img-wrap">
              <img src="../img/rubeus-hagrid.jpg" alt="candidate" />
            </div>
            <div class="can-content">
              <div class="can-name-info">
                <h3>Rubeus Hagrid</h3>
                <h4><span class="age">Age :</span> 72</h4>
                <h4>
                  <i class="fas fa-map-marker"></i>
                  Hogwarts
                </h4>
              </div>
              <div class="party">Gryffindor</div>
              <div class="short-about">
                Lorem, ipsum dolor sit amet consectetur adipisicing elit.
                Placeat, corporis. Error quidem aperiam dignissimos, voluptatem,
                quae quo vitae distinctio nulla praesentium temporibus, quis
                accusantium doloribus omnis. Quibusdam soluta aliquid
                temporibus?
              </div>
            </div>
          </div>
        </a>

        <a href="/ShowCan?id=3">
          <div class="can-card">
            <div class="img-wrap">
              <img src="../img/kratos.jpg" alt="candidate" />
            </div>
            <div class="can-content">
              <div class="can-name-info">
                <h3>Kratos</h3>
                <h4><span class="age">Age :</span> 72</h4>
                <h4>
                  <i class="fas fa-map-marker"></i>
                  Helheim
                </h4>
              </div>
              <div class="party">Helheim</div>
              <div class="short-about">
                Lorem, ipsum dolor sit amet consectetur adipisicing elit.
                Placeat, corporis. Error quidem aperiam dignissimos, voluptatem,
                quae quo vitae distinctio nulla praesentium temporibus, quis
                accusantium doloribus omnis. Quibusdam soluta aliquid
                temporibus?
              </div>
            </div>
          </div>
        </a>

        <a href="profile.jsp">
          <div class="can-card">
            <div class="img-wrap">
              <img src="../img/rubeus-hagrid.jpg" alt="candidate" />
            </div>
            <div class="can-content">
              <div class="can-name-info">
                <h3>Rubeus Hagrid</h3>
                <h4><span class="age">Age :</span> 72</h4>
                <h4>
                  <i class="fas fa-map-marker"></i>
                  Hogwarts
                </h4>
              </div>
              <div class="party">Gryffindor</div>
              <div class="short-about">
                Lorem, ipsum dolor sit amet consectetur adipisicing elit.
                Placeat, corporis. Error quidem aperiam dignissimos, voluptatem,
                quae quo vitae distinctio nulla praesentium temporibus, quis
                accusantium doloribus omnis. Quibusdam soluta aliquid
                temporibus?
              </div>
            </div>
          </div>
        </a>
      </div>
    </div>
  </body>
</html>
