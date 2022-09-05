<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> -->
    <title>Utilities</title>
    
     <style type="text/css">
 		.price { text-align: right; color = lightgrey; background-color: white; }
 		.flex-container { 
 			display: flex; 
 			flex-wrap: wrap;
 			flex-direction: row;
 			justify-content: flex-start;
 			padding-top: 40px;
 		}
 	</style>
</head>
<body>
	
	<jsp:include page="sidebar.jsp" />
	     
	<div id="main">
		<jsp:include page="panel.jsp">
       		<jsp:param name="headerTitle" value="Control panel: Utilities" />
  	  	</jsp:include>
		
		<div class="w3-container">
			<div class="flex-container">
					<!-- <a href="/create-utility">Create Utility</a> -->
					<c:if test="${not empty utilities}">
						<c:forEach items="${utilities}" var="currentUtility">
							
								<div class="w3-card-4" style="margin: 15px;	width: 25%; min-width: 150px; border-radius: 7px;">
									<header class="w3-container w3-light-grey">
										<h4 style="white-space: nowrap; overflow: hidden;">${currentUtility.name}</h4>
									</header>
									<img src="https://findicons.com/files/icons/366/icomic/128/images.png" alt="image" style="width: 80%; margin: 0 10%;">
									<!-- <img src="/images/default.png" alt="image" style="width: 80%; margin: 0 10%;">  --> 
									<div class="w3-container w3-center" style="align: bottom;">
										<p>Units: ${currentUtility.unit.name}</p>
										<c:out value="${empty currentUtility.description ? '<br>' : currentUtility.description}" escapeXml="false" />
										
										<hr>
									</div>
									<button class="w3-button w3-block w3-dark-grey" style="border-radius: 0 0 7px 7px; align: bottom;">Details</button>
								</div>
							
						</c:forEach>
					</c:if>
				</div>
			
		</div>

	</div>

	<script src="/js/sidebar.js"> </script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

</body>
</html>