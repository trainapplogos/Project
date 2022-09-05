<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <title>Bills</title>
    
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
       		<jsp:param name="headerTitle" value="Control panel: Bills list" />
  	  	</jsp:include>
		
		<div class="w3-container">
			<div class="flex-container">
					
					<c:if test="${not empty bills}">
						<c:forEach items="${bills}" var="currentBill">
							
								<div class="w3-card-4" style="margin: 15px;	width: 40%; min-width: 150px; border-radius: 7px;">
									<header class="w3-container w3-light-grey">
										<h4 style="white-space: nowrap; overflow: hidden;">${currentBill.name}</h4>
									</header>
									
									<img src="https://findicons.com/files/icons/366/icomic/128/images.png" alt="image" style="width: 20%;  margin-left: auto;  margin-right: auto; display: block;">
									<!-- <img src="/images/default.png" alt="image" style="width: 80%; margin: 0 10%;">  --> 
									
									<div class="w3-container" style="align: bottom;"> <!-- w3-center -->
										<b><p1>User:</p1></b><br>
										<p>Firstname: ${currentBill.user.firstName}</p>
										<p>Lastname: ${currentBill.user.lastName}</p>
										<p>Patronymic: ${currentBill.user.patronymic}</p>
										
										<hr>
										
										<b><p>Address:</p></b>
										<p>Street: ${currentBill.user.street}</p1>
										<p>Building: ${currentBill.user.building}</p>
										<p>Apartment: ${currentBill.user.apartment}</p>
										<p>Phome number: ${currentBill.user.phoneNumber}</p>
										<p>Zip code: ${currentBill.user.zipCode}</p>
										
										<hr>
										
										<b><p>Title: ${currentBill.name}</p></b>
										<p>Tariff: ${currentBill.tariff.name}</p>
										<p>Value: ${currentBill.value}</p>
										<p>Summary: ${currentBill.summary}</p>
										<p>From: ${currentBill.fromPeriod}</p>
										<p>To: ${currentBill.toPeriod}</p>
										<p>Comment: ${currentBill.comment}</p>
										
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