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
               		<div class="container" style="margin-top:10px;">
               			<c:forEach items="${booklist}" var="bookList">
               		
               		      	 <div class="row form-group">   
						        <div class="col-xs-12 col-md-6">        
						            <div class="panel panel-default">
						                <div class="panel-heading">
						                    <h3 class="panel-title"><font>${bookList.name}</font></h3>
						                </div>
						                <div class="panel-image ">
						                    <img src='<c:url value="/getimage?index=${bookList.id}"/>' class="panel-image-preview" />
						                    <label for="toggle-${bookList.id}"></label>
						                </div>
						                <input type="checkbox" id="toggle-${bookList.id}" class="panel-image-toggle">
						                <div class="panel-body">
						                    <font>
						                  <h4>Название: ${bookList.name}</h4>
						                  <h4>Жанр: ${bookList.genre.name}</h4>
						                    <p>
						                    	${bookList.info}
						                    </p>
						                    </font>
						                </div>
						                <div class="panel-footer text-center">
						                   
						                    <a href='<c:url value="/readpdf?index=${bookList.id}"/>'><span title="Читать" class="glyphicon glyphicon-file"></span></a>
						                    <a href='<c:url value="/downloadpdf?index=${bookList.id}"/>'><span title="Скачать" class="glyphicon glyphicon-download"></span></a>
						                    <a href='<c:url value="/deletepdf?index=${bookList.id}"/>'><span title="Удалить" class="glyphicon glyphicon-remove"></span></a>
						                    <!--<a href="#facebook"><span class="fa fa-facebook"></span></a>  -->
						                	<!--<a href="#twitter"><span class="fa fa-twitter"></span></a> -->
						                    <!--<a href="#share"><span title="В избранное" class="glyphicon glyphicon-share-alt"></span></a>-->
						                    <a href="#share"><span title="В избранное" class="glyphicon glyphicon-star"></span></a>
						                </div>
						            </div>
						        </div>
						        </div> 
               		
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