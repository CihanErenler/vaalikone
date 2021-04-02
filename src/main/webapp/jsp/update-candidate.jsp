<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css" integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk" crossorigin="anonymous">
    <title>Update Candidate</title>
    <link rel="stylesheet" href="/jsp/style.css" />
  </head>
  <body>
    <%@ include file="../html/navbar.html" %>
    <div class="add-can container flex-container">
      <div class="card">
        <a href="jsp/admin-candidate" class="btn btn-back">
          <i class="fas fa-chevron-left"></i>
          Back</a>
        <h1 class="title">Update Candidate</h1>
        <div class="underline"></div>
        <div class="add-img">
            <img class="output-img" src="${requestScope.profile.profile_pic}" alt="candidate" />
        </div>
            <form action="updateCan" method="POST"  class="candidate-form">
                <label for="img-file" class="upload"></i>Add Picture</label>
                <input type="file" name="profile_pic" id="img-file" >	
                <input type="hidden" name="id" id="fname" placeholder="First Name" value="${requestScope.profile.getId()}"/>
                <input type="text" name="fname" id="fname" placeholder="First Name" value="${requestScope.profile.fname}"/>
                <input type="text" name="lname" id="lname" placeholder="Last Name" value="${requestScope.profile.lname}"/>
                <input type="text" name="city" id="city" placeholder="City" value="${requestScope.profile.city}"/>
                <input type="number" name="age" id="age" placeholder="Age" value="${requestScope.profile.age}"/>
                <input type="text" name="profession" id="profession" placeholder="Profession" value="${requestScope.profile.profession}"/>
                <input type="text" name="political_party" id="party" placeholder="Political party" value="${requestScope.profile.political_party}"/>
                <textarea name="why_candidate" id="" placeholder="Why did you become a candidate?">${requestScope.profile.why_candidate}</textarea>
                <textarea name="about" id="" placeholder="About">${requestScope.profile.about}</textarea>
                <button name = "submit" type="submit" class="btn btn-thin">Update Candidate</button>
            </form>
      </div>
    </div>

    <script src="../js/add-candidate.js"></script>
  </body>
</html>