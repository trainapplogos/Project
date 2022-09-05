<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 


<div id="topHeader" class="w3-blue-grey" style="position: fixed; width: 100%; height: 40px;">  <!--   -->
		
	<div style="display: flex; flex-wrap: wrap; justify-content: space-between;">
		
		<div style="display: flex; flex-wrap: wrap;">
			<button id="openNav" class="w3-button w3-blue-grey w3-medium" onclick="w3_open()" style="height: 40px; padding-top: 8px;">&#9776;</button>
			<p style="padding-left: 10px; margin-top: 8px;"><%=request.getParameter("headerTitle")%></p>
		</div>
		
		<div class="w3-container">
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<form id="logoutForm" method="POST" action="${contextPath}/logout">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>
	
					<p style="margin-top: 8px;">
						Welcome ${pageContext.request.userPrincipal.name} | 
						<a href="#" onclick="document.forms['logoutForm'].submit()">Logout</a>
					</p>
				</c:if>
		</div>
		
	</div>	
</div>
