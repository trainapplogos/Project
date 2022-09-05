<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<div class="w3-sidebar w3-bar-block w3-card w3-animate-left" style="display: none;" id="sidebar">
	<button class="w3-bar-item w3-button w3-large w3-dark-grey" onclick="w3_close()" 
		style="display: flex; flex-wrap: wrap; justify-content: space-between; height: 40px;"> 
		<div><p id="menu" style="margin-top: 0; font-size: 14px;">Menu</p></div>	
			<div style="color: white;">
				 <img id="pin" src="/images/thumbtack-solid.svg" width=10; style="text-color: white" alt="pin menu" onclick="pin_sidebar()"> 
				 &times;
			</div>	
	</button>
	
	<c:if test="${not empty menuItems}">
		<c:set var = "menuInd" scope = "page" value = "${0}" />
		<c:forEach items="${menuItems}" var="menuItem">
			<c:choose>
				<c:when test="${empty menuItem.url and not empty menuItem.group}">	
					<c:set var = "menuInd" scope = "page" value = "${menuInd + 1}" />
					<button class="w3-button w3-block w3-left-align" onclick="accordFunc(${menuInd})">
						 ${menuItem.group}  <i class="fa fa-caret-down"></i>
					</button>
					
					<div id="menuAccord${menuInd}" class="w3-hide w3-grey w3-card">

						<c:forEach items="${menuItems}" var="subMenuItem">
							<c:if test="${subMenuItem.group == menuItem.group and not empty subMenuItem.url}">
								<a href="${subMenuItem.url}" class="w3-bar-item w3-button">
								<i class="fa fa-caret-right"></i> ${subMenuItem.name}</a>
							</c:if>
						</c:forEach>
					</div>
				</c:when>
				
				<c:when test="${not empty menuItem.url and empty menuItem.group}">
					<a href="${menuItem.url}" class="w3-bar-item w3-button">${menuItem.name}</a>
				</c:when>
				
				<c:otherwise>
					<!-- output log here -->
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</c:if>
	<!--  <a href="/home" class="w3-bar-item w3-button"><i class="fa fa-home w3-large w3-dark-grey"></i> Home</a> -->
</div>


