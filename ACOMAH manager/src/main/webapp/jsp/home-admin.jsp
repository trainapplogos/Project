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
    <title>Welcome Admin control panel</title>

</head>
<body>
	
	<%-- <jsp:include page="sidebar.jsp" /> --%>
	<jsp:include page="sidebar.jsp">
    	<jsp:param name="menu" value="${menuItems}" />
  	</jsp:include>
		
     
	<div id="main">
		<jsp:include page="panel.jsp">
       		<jsp:param name="headerTitle" value="Admin control panel" />
  	  	</jsp:include>
		
		
		<div class="w3-container">
		
			
			
		</div>

	</div>


	<script src="/js/sidebar.js"> </script>

</body>
</html>