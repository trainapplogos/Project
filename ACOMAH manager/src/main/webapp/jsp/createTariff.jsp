<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
   
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">


	<title>Create Tariff</title>
	
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> -->
    
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
	
	<style>
		.error-msg { color: red; }
		.disabledItem{ pointer-events: none; }
	</style>

</head>
<body>
	
	<jsp:include page="sidebar.jsp" />
     
	<div id="main">
		<jsp:include page="panel.jsp">
       		<jsp:param name="headerTitle" value="Admin control panel: Create Tariff" />
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


			<form:form method="POST" action="${contextPath}/add-tariff" modelAttribute="tariff">
				
				<table>
					<tr>
						<td><form:label path="name">Name</form:label></td>
						<td><form:input path="name" required="required"/></td>
					</tr>
					
					<tr>
						<td><form:label path="utility">Utility</form:label></td>
						
						<td><form:select path="utility" name="utility" id="utility" onchange="changeUnit()">
							<form:option value="0">> Select utility <</form:option>
							<form:options items="${utilities}" itemLabel="name" itemValue="id"/>
							</form:select>
							
							<form:errors path="utility" cssClass="error-msg"/> 
						</td>
						<%-- 	<form:errors element="errorCheck"/> --%>  <!-- for: bindResult.addError() -->
					</tr>
					
					<tr>
						<td><form:label path="value" required="required">Tariff</form:label></td>
						<td><form:input path="value" /></td>

						<td>
							<form:select path="utility.unit.name" id="unit" class="disabledItem" > 
							<form:option value="0">---</form:option>
							<form:options items="${utilities}" itemLabel="unit.name" itemValue="id" />
							</form:select>
							
							<form:errors path="utility" cssClass="error-msg"/> 
						</td>
					</tr>
					
					<tr>
						<td><form:label path="fromDate">fromDate</form:label></td>
						<td><form:input type="date"  path="fromDate" required="required"/></td>
					</tr>
					<%-- placeholder="DD-MM-YYYY" --%>
					<tr>
						<td><form:label path="description">Description</form:label></td>
						<td><form:input path="description" /></td>
					</tr>
					
					<tr>
						<td><input type="submit" value="Submit" /></td>
					</tr>
				</table>

				<%-- <form:errors path="*" cssClass="error-msg" element="div"/> --%>
				
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			
				
			</form:form>
			
	
		</div>

	</div>

	<script>
	
		function changeUnit() {
		    document.getElementById('unit').selectedIndex = document.getElementById('utility').selectedIndex;
		}
		
		function selectOption(selectId, valueToSelect){
		    var selectElement = document.getElementById(selectId);
		    var selectedOptions = selectElement.options;
		    
		    for (var opt, j = 0; opt = selectedOptions[j]; j++) {    
		        if (opt.value == valueToSelect) {
		            selectElement.selectedIndex = j;
		            break;
		        }
		    } 
		}
	
		function onChangeUtility(id) {
			/* selectOption('unit', id); */
		}
		
	</script>
	
	<script src="/js/sidebar.js"> </script>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
	
</body>
</html>