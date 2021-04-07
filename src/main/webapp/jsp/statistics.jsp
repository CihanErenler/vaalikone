<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Statistics</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.3/css/all.css"
	integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk"
	crossorigin="anonymous">
<link rel="stylesheet" href="/jsp/style.css" />
</head>
<body>
	<%@ include file="/html/navbar.html"%>
	<div class="container">
		<div class="card statistics-card">
			<h1 class="title">Statistics of the questions</h1>
			<div class="underline"></div>

			<c:forEach var="s" items="${requestScope.questions}" varStatus="loop">

				<div class="question-card"
					data-val="${requestScope.statistics.get(loop.index)}">
					<div class="question-card-q">
						<h2 class="index">Question ${loop.index + 1}</h2>
						<p class="question-text">${s.getText()}</p>
					</div>
					<div class="chart">
						<div class="chart-wrap">
							<div class="first-part">Strongly Disagree</div>
							<div class="progress">
								<div id="strongly-disagree" class="p-bar"></div>
							</div>
							<div class="last-part">23</div>
						</div>
						<div class="chart-wrap">
							<div class="first-part">Disagree</div>
							<div class="progress">
								<div id="disagree" class="p-bar"></div>
							</div>
							<div class="last-part">23</div>
						</div>
						<div class="chart-wrap">
							<div class="first-part">Neutral</div>
							<div class="progress">
								<div id="neutral" class="p-bar"></div>
							</div>
							<div class="last-part">23</div>
						</div>
						<div class="chart-wrap">
							<div class="first-part">Agree</div>
							<div class="progress">
								<div id="agree" class="p-bar"></div>
							</div>
							<div class="last-part">23</div>
						</div>
						<div class="chart-wrap">
							<div class="first-part">Strongly Agree</div>
							<div class="progress">
								<div id="strongly-agree" class="p-bar"></div>
							</div>
							<div class="last-part">23</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<div class="scroll"><i class="fas fa-arrow-up"></i></div>
	<script src="/js/statistics.js"></script>
	<script src="/js/scrollUp.js"></script>
</body>
</html>
