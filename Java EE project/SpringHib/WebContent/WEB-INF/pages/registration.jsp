<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/registration.css" />
</head>
<body>

	

        <spring:url value="/login" var="url" />
		<spring:url value="/registration/check" var="regurl" />
		 <form:form name="f" action="${regurl}" method="post" commandName="user">
	
        <div class="loginform">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Registration
                    </div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="inputLogin3" class="col-sm-3 control-label">
                            Login</label>
                        <div class="col-sm-9">
                           <form:input type="text" path="login" class="form-control" id="inputLogin3" placeholder="Login" />
                           <label class="errorText" style="color:red;"><form:errors path="login"/></label>
                        </div>
                        
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-3 control-label">
                            Password</label>
                       
                        <div class="col-sm-9">
                        
                            <form:input path="password" type="password" class="form-control" id="inputPassword3" placeholder="Password" />
                             <label class="errorText" style="color:red;"><form:errors path="password"/></label>
                            
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputname3" class="col-sm-3 control-label">
                            Name</label>
                        <div class="col-sm-9">
                            <form:input path="name" type="text" class="form-control" id="inputname3" placeholder="Name" />
                            <label class="errorText" style="color:red;"><form:errors path="name"/></label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputsurname3" class="col-sm-3 control-label">
                            Surname</label>
                        <div class="col-sm-9">
                            <form:input path="surname" type="text" class="form-control" id="inputsurname3" placeholder="Surname" />
                            <label class="errorText" style="color:red;"><form:errors path="surname"/></label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputemail3" class="col-sm-3 control-label">
                            Email</label>
                        <div class="col-sm-9">
                            <form:input path="email" type="text" class="form-control" id="inputemail3" placeholder="Email" />
                            <label class="errorText" style="color:red;"><form:errors path="email"/></label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputage3" class="col-sm-3 control-label">
                            Age</label>
                        <div class="col-sm-9">
                            <form:input path="age" type="text" class="form-control" id="inputage3" placeholder="Age" />
                            <label class="errorText" style="color:red;"><form:errors path="age"/></label>
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
                                Register</button>
                                 <button type="reset" class="btn btn-default btn-sm">
                                Reset</button>
                                <button style="background-color:#00BFFF; color: white;" onClick='location.href="${url}"' type="button"  class="btn btn-default btn-sm">
                                Log In</button>
                                
                        </div>
                    </div>
                    </form>
                </div>
                
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