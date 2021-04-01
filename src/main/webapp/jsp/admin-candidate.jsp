<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="data.Candidate" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
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

		<c:forEach var="candidate" items="${requestScope.candidatelist}" >
          <div class="can-card">
            <div class="img-wrap">
              <img src="../img/${candidate.profilePic}" alt="candidate" />
            </div>
            <div class="can-content">
              <div class="can-name-info can-name-info-flex">
                <h3>${candidate.fname} ${candidate.lname}</h3>
                <h4><span class="age">Age :</span> ${candidate.age}</h4>
                <h4>
                  <i class="fas fa-map-marker"></i>
                  ${candidate.city}
                </h4>
                <div class="edit-buttons">
                  <a href="update-candidate" class="edit-btn">
                    <i class="fas fa-pen"></i>
                  </a>
                  <a href="#" class="delete-btn">
                    <i class="fas fa-trash-alt"></i>
                  </a>
                </div>
              </div>
              <div class="party">${candidate.politicalParty}</div>
              <div class="short-about">
				${candidate.about}
              </div>
            </div>
          </div>
          </c:forEach>
          
        </div>
      </div>
    </div>
  </body>
</html>
