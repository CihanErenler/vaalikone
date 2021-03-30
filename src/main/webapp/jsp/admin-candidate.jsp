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
    <link rel="stylesheet" href="style.css" />
    <title>Admin Candidate</title>
  </head>
  <body>
    <%@ include file="../html/navbar.html" %>

    <div class="admin-pages container flex-container">
      <div class="card">
        <div class="admin-header">
          <h1 class="title">Candidates</h1>
          <div class="underline"></div>
          <div class="admin btn-wrapper">
            <a href="admin-dashboard.jsp" class="btn btn-thin">Back</a>
            <a href="add-candidate.jsp" class="btn btn-thin">Add Candidate</a>
          </div>
        </div>
        <div class="admin-content">
          <div class="can-card">
            <div class="img-wrap">
              <img src="../img/rubeus-hagrid.jpg" alt="candidate" />
            </div>
            <div class="can-content">
              <div class="can-name-info can-name-info-flex">
                <h3>Rubeus Hagrid</h3>
                <h4><span class="age">Age :</span> 72</h4>
                <h4>
                  <i class="fas fa-map-marker"></i>
                  Hogwarts
                </h4>
                <div class="edit-buttons">
                  <a href="#" class="edit-btn">
                    <i class="fas fa-pen"></i>
                  </a>
                  <a href="#" class="delete-btn">
                    <i class="fas fa-trash-alt"></i>
                  </a>
                </div>
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

          <div class="can-card">
            <div class="img-wrap">
              <img src="../img/rubeus-hagrid.jpg" alt="candidate" />
            </div>
            <div class="can-content">
              <div class="can-name-info can-name-info-flex">
                <h3>Rubeus Hagrid</h3>
                <h4><span class="age">Age :</span> 72</h4>
                <h4>
                  <i class="fas fa-map-marker"></i>
                  Hogwarts
                </h4>
                <div class="edit-buttons">
                  <a href="#" class="edit-btn">
                    <i class="fas fa-pen"></i>
                  </a>
                  <a href="#" class="delete-btn">
                    <i class="fas fa-trash-alt"></i>
                  </a>
                </div>
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
        </div>
      </div>
    </div>
  </body>
</html>