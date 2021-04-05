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
    
    <title>Candidates</title>
    <link rel="stylesheet" href="style.css" />
  </head>
	<body>
	
	    <%@ include file="../html/navbar.html" %>
	     <div class="candidates container">
	      <h1 class="title">Candidates</h1>
	      <div class="underline"></div>
	      
			  <c:forEach var="candidate" items="${requestScope.candidatelist}" >
			      <div class="candidates-wrapper">
				   <a href="/ShowProfile?id=${candidate.id}">
				          <div class="can-card">
				            <div class="img-wrap">
				              <img src="${candidate.profile_pic}" alt="candidate" />
				            </div>
				            
				            <div class="can-content">
				              <div class="can-name-info">
				                <h3>${candidate.fname} ${candidate.lname}</h3>
				                <h4><span class="age">Age :</span> ${candidate.age}</h4>
				                <h4>
				                  <i class="fas fa-map-marker"></i>
				                  ${candidate.city}
				                </h4>
				              </div>
				              <div class="party">${candidate.political_party}</div>
				              <div class="short-about">
								${candidate.about}
				              </div>
				            </div>
				          </div>
						</a>
					</div>
				</c:forEach>
	
	      </div>
</body>
</html>
