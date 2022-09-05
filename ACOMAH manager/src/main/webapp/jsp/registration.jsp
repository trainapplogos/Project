<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

    <title>Create an account</title>

    <%-- <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet"> --%>
</head>

<body>

<div class="container">

    <form:form method="POST" modelAttribute="userForm" class="form-signin">
        <h2 class="form-signin-heading">Create your account</h2>
        
        <!-- delete this  -->
        <%--  <spring:bind path="id">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="id" class="form-control" placeholder="ID >>> delete this"
                            autofocus="true"></form:input>
                <form:errors path="id"></form:errors>
            </div>
        </spring:bind>  <br> --%>
        
        
        <spring:bind path="firstName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="firstName" class="form-control" placeholder="First name"
                            autofocus="false"></form:input> <!-- set autofocus to true  -->
                <form:errors path="firstName"></form:errors>
            </div>
        </spring:bind>  <br>
       
		<spring:bind path="lastName">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<form:input type="text" path="lastName" class="form-control"
					placeholder="Last name"></form:input>
				<form:errors path="lastName"></form:errors>
			</div>
		</spring:bind> <br>

		<spring:bind path="patronymic">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<form:input type="text" path="patronymic" class="form-control"
					placeholder="patronymic"></form:input>
				<form:errors path="patronymic"></form:errors>
			</div>
		</spring:bind> <br>

		<spring:bind path="email">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<form:input type="text" path="email" class="form-control"
					placeholder="Email"></form:input>
				<form:errors path="email"></form:errors>
			</div>
		</spring:bind> <br>

		<spring:bind path="password">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<form:input type="password" path="password" class="form-control"
					placeholder="Password"></form:input>
				<form:errors path="password"></form:errors>
			</div>
		</spring:bind> <br>

		<spring:bind path="passwordConfirm">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<form:input type="password" path="passwordConfirm"
					class="form-control" placeholder="Confirm your password"></form:input>
				<form:errors path="passwordConfirm"></form:errors>
			</div>
		</spring:bind> <br>
		
		<spring:bind path="street">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<form:input type="text" path="street" class="form-control"
					placeholder="Street" readonly="true" />
				<form:errors path="street"></form:errors>
			</div>
		</spring:bind> <br>
		
		<spring:bind path="building">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<form:input type="text" path="building" class="form-control"
					placeholder="Building" readonly="true" /> 
				<form:errors path="building"></form:errors>
			</div>
		</spring:bind> <br>
		
		<spring:bind path="apartment">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<form:input type="text" path="apartment" class="form-control"
					placeholder="apartment" readonly="true" />
				<form:errors path="apartment"></form:errors>
			</div>
		</spring:bind> <br>
		
		<spring:bind path="phoneNumber">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<form:input type="text" path="phoneNumber" class="form-control"
					placeholder="Phone number: example +38044111111" /> 
				<form:errors path="phoneNumber"></form:errors>
			</div>
		</spring:bind> <br>
		
		<spring:bind path="zipCode">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<form:input type="text" path="zipCode" class="form-control"
					placeholder="Zip code" readonly="true" /> 
				<form:errors path="zipCode"></form:errors>
			</div>
		</spring:bind> <br>
		
		<br>

		<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<%-- <script src="${contextPath}/resources/js/bootstrap.min.js"></script> --%>
</body>
</html>