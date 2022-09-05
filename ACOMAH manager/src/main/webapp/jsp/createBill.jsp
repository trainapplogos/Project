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

    <title>Create Bill</title>
	
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	
	<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>

	<style>
		.error-msg { color: red; }
		td { padding-bottom: 15px; }
		.disabledItem{ pointer-events: none; }
	</style>

</head>
<body>
	
	<jsp:include page="sidebar.jsp" />
     
	<div id="main">
		<jsp:include page="panel.jsp">
       		<jsp:param name="headerTitle" value="Admin control panel: create Bill" />
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
			
			<label for="fname">First name:</label>
		 	<%-- <input type="text" id="fname" name="fname" value="${bill.user.firstName}" disabled><br><br> --%>
		 	<input type="text" id="fname" name="fname" value="${userFirstName}" disabled><br><br>
		 	
		 	<label for="lname">Last name:</label>
		 	<input type="text" id="lname" name="lname" value="${userLastName}" disabled><br><br>
		  
			<form:form method="POST" action="${contextPath}/add-bill" modelAttribute="bill">
				<br>
				<table>		
					<tr>
		
						<td><form:input path="user.id" type="hidden" value="${userId}" />
						<form:errors path="user.id" cssClass="error-msg"/> 
						</td>
					</tr>
				
					<tr>
						<td><form:label path="name">Title: </form:label></td>
						<td><form:input path="name" required="required"/>
						<form:errors path="name" cssClass="error-msg"/> 
						</td>
					</tr>
						
					<tr>
						<td><form:label path="tariff">Tariff</form:label></td>
						
						<td><form:select path="tariff.id" name="tariff" id="tariff" onchange="changeUtility()">
							<form:option value="0">> Select tariff <</form:option>
							<form:options items="${tariffs}" itemLabel="name" itemValue="id"/>
							</form:select>
							
							<form:errors path="tariff" cssClass="error-msg"/> 
						</td>
						
						<td>
							<form:select path="tariff.utility.name" id="utility" class="disabledItem">
							<form:option value="0">---</form:option>
							<form:options items="${tariffs}" itemLabel="utility.name" itemValue="id" />
							</form:select>
						</td>	
						
						<%-- 	<form:errors element="errorCheck"/> --%>  <!-- for: bindResult.addError() -->
					</tr>
					
					
					<tr>
						<td><form:label path="value">Value</form:label></td>
						<td><form:input path="value" required="required"/>
						<form:errors path="value" cssClass="error-msg"/> 
						</td>
					</tr>
					
					<tr>
						<td><form:label path="summary">Summary</form:label></td>
						<td><form:input path="summary" required="required"/>
						<form:errors path="summary" cssClass="error-msg"/> 
						</td>
					</tr>
					 
					 <tr>
						<td><form:label path="fromPeriod">From date</form:label></td>
						<td><form:input type="date" path="fromPeriod" required="required"/></td>
					</tr>
					 
					<tr>
						<td><form:label path="toPeriod">To date</form:label></td>
						<td><form:input type="date" path="toPeriod" required="required"/></td>
					</tr>
					 
					<tr>
						<td><form:label path="comment">Comment</form:label></td>
						<td><form:input path="comment" /></td>
					</tr>
					
					<tr>
						<td><input type="submit" value="Submit" /></td>
					</tr>
				</table>

				<input type="hidden" name="${_csrf.parameterName}"	value="${_csrf.token}" />
			</form:form>

		</div>

	</div>

	<script>
	
		function changeUtility() {
		    document.getElementById('utility').selectedIndex = document.getElementById('tariff').selectedIndex;
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
	
		function onChangeTariff(id) {
			/* selectOption('unit', id); */
		}
		
	</script>


	<script src="/js/sidebar.js"> </script>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
	
</body>
</html>