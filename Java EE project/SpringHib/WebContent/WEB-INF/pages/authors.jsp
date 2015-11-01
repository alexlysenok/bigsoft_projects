<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<c:import url="imports.jsp" charEncoding="UTF-8"></c:import>
</head>
<body>
	<div id="page">
     
    	<div id="header">
     		<c:import url="navbar.jsp" charEncoding="UTF-8"></c:import>
     		<div id="scrollup"><img alt="Прокрутить вверх" src="${pageContext.request.contextPath}/resources/img/up.png"></div>
    	</div>
     
  
    
    	<div id="main">
           <div id="column"> 
           		<c:import url="sidebar.jsp" charEncoding="UTF-8"></c:import>
           </div>
           <div id="center">
                  <div id="content">
                  <font><h2 style="margin-left:15px;">Авторы:</h2></font><br>
               		<div class="container" style="margin-top:10px;">
               			<c:forEach items="${authors}" var="author">
               		         <h4>${author.name} ${author.surname}</h4><br>
               		         <!--  
               		      	 <div class="row form-group">   
						        <div class="col-xs-12 col-md-6">        
						            <div class="panel panel-default">
						                <div class="panel-heading">
						                    <h3 class="panel-title"><font>${author.name} ${author.surname}</font></h3>
						                </div>
						                <div class="panel-image ">
						                    <img src='<c:url value="/getauthorimage?index=${author.id}"/>' class="panel-image-preview" />
						                    <label for="toggle-${author.id}"></label>
						                </div>
						                <input type="checkbox" id="toggle-${author.id}" class="panel-image-toggle">
						                <div class="panel-body">
						                    <h4><font>Книги: </font></h4>
						                    <p>
						                    	<ul>
						                    	
						                    		 <c:forEach items="${author.books}" var="authorbook">
									                	<li>
									                   		 <a href='<c:url value="/readpdf?index=${authorbook.id}"/>'><font>${authorbook.name}</font></a>
									                	</li>
									                </c:forEach>	
						                    	
						                    	</ul>
						                    </p>
						                </div>
						                <div class="panel-footer text-center">
						                   
						                    
						                </div>
						            </div>
						        </div>
						        </div> 
               		    -->
               			</c:forEach>	
               			
         
               			
               		</div>
               		
               		
               	
               		
               		
               </div>
           </div>
       
     	</div>
      
      
     	<div id="footer">
          
     	</div>
      </div>
</body>
</html>