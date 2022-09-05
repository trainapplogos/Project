<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" >
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    
    <title>Create Utility</title>
	
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>

	<style>
		.error-msg { color: red; }
		td { padding-bottom: 15px; }
	</style>

</head>
<body>
	
	<jsp:include page="sidebar.jsp" />
     
	<div id="main">
		<jsp:include page="panel.jsp">
       		<jsp:param name="headerTitle" value="Admin control panel: create Utility" />
  	  	</jsp:include>
		
		
		<div class="w3-container">

			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<form id="logoutForm" method="POST" action="${contextPath}/logout">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>

				<h4>
					Welcome ${pageContext.request.userPrincipal.name} | 
					<a href="#"	onclick="document.forms['logoutForm'].submit()">Logout</a>
				</h4>
			</c:if>


			<form:form method="POST" action="${contextPath}/add-utility" modelAttribute="utility">
				<br>
				<table>
					<tr>
						<td><form:label path="name">Name</form:label></td>
						<td><form:input path="name" required="required"/>
						<form:errors path="name" cssClass="error-msg"/> 
						</td>
					</tr>
					
					<tr>
						<td><form:label path="unit">Unit of Measure</form:label></td>
						<td><form:select path="unit">
							<form:option value="0">> Select unit <</form:option>
							<form:options items="${units}" itemLabel="name" itemValue="id"/>
							</form:select>
							<form:errors path="unit" cssClass="error-msg"/> 
						</td>
						<%-- 	<form:errors element="errorCheck"/> --%>  <!-- for: bindResult.addError() -->
					</tr>

					
					<tr>
						<td><form:label path="description">Description</form:label></td>
						<td><form:input path="description" /></td>
					</tr>
					
					<tr>
						<td><input type="submit" value="Submit" /></td>
					</tr>
				</table>

				<input type="hidden" name="${_csrf.parameterName}"	value="${_csrf.token}" />
			</form:form>

		</div>

	</div>


	<script src="/js/sidebar.js"> </script>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
	
</body>
</html>