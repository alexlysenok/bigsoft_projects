<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/login.css" />
</head>
<body>
    <spring:url value="/login/check" var="url" />
	<spring:url value="/registration" var="regurl" />
    <form:form name="f" action="${url}" method="post" commandName="user" >
	
        <div class="loginform">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Login
                    </div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="inputLogin3" class="col-sm-3 control-label">
                            Login</label>
                        <div class="col-sm-9">
                            <form:input type="text" path="login" class="form-control" id="inputLogin3" placeholder="Login" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-3 control-label">
                            Password</label>
                        <div class="col-sm-9">
                            <form:input path="password" type="password" class="form-control" id="inputPassword3" placeholder="Password" />
                        </div>
                    </div>
                    
              
                    
                      <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-9">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox"/>
                                    Remember me
                                </label>
                            </div>
                        </div>
                    </div>
                    
                    <div class="form-group last">
                        <div class="col-sm-offset-3 col-sm-9">
                            <button type="submit" class="btn btn-success btn-sm">
                                Sign in</button>
                                 <button type="reset" class="btn btn-default btn-sm">
                                Reset</button>
                        </div>
                    </div>
                    </form>
                </div>
                <div class="panel-footer"> Not Registred? <a href="${regurl}">Register here</a></div>
                   <c:if test="${not empty error}">
				    <div class="alert alert-danger" style="width: auto; margin: 0px auto;">
					${error}</div>
			     </c:if>
			     <c:if test="${not empty success}">
				 <div class="alert alert-success" style="width: auto; margin: 0px auto;">
					${success}</div>
			     </c:if>  
                    
                 
            </div>
          
</div>
  
   

</form:form>	
</body>
</html>