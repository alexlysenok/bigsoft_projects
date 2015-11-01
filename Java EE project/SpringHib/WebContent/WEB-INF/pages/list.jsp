<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/list.css" />
</head>

<body>
    <div id="main">
    	<div id="right">
    	   
    		<h1>All users</h1>
    		 <p class="array">
			<c:forEach items="${users}" var="users">				
				login:<c:out value="${users.login}" /><br>
				name:<c:out value="${users.name}" /><br>
				surname:<c:out value="${users.surname}" /><br>
				email:<c:out value="${users.email}" /><br>
				age:<c:out value="${users.age}" /><br><br>
								
			</c:forEach>
			</p>
		</div>
		<div id="left">
			
			<h1>User</h1>
			<p class="userinfo">
			<br> User: ${user.login}
			<br> Password ${user.password}
			<br> Session id= ${sessionId}
			</p>
   		</div>
   </div>
</body>
</html>