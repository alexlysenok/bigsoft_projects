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
     
          <spring:url value="/uploadpdf" var="uploadMyPDF" />
    
    	<div id="main">
           <div id="column"> 
           		<c:import url="sidebar.jsp" charEncoding="UTF-8"></c:import>
           </div>
           <div id="center">
                 
                 
						 
						     <div id="content">
						
						
						  
								<form:form method="post" action="${uploadMyPDF}"  modelAttribute="uploadForm"  enctype="multipart/form-data" id="form">
									    
									    
									        <label for="name">Название</label><br>
									        <input id="name" name="name" type="text"><br>
									    		  									  
									   
									    <label for="genre">Выберите жанр</label><br>
									    <select name="genre" id="genre" form="form">
								         <option value="0">не выбран</option>
								          <c:forEach var="genres" items="${genres}">								             
								           <option value="${genres.name}">${genres.name}</option>
								          </c:forEach>
								        </select><br>
									    									 									   
									    
									        <label for="image">Обложка</label>
									        <input type="file" accept="image/*" name="files[0]" required="" id="image"/><br>
									   
									        <label for="content">Книга</label></td>
									        <input type="file" accept="application/pdf" name="files[1]" required="" id="content"/><br>
									    
							       
							       <br><input type="submit" value="загрузить книгу">   
									</form:form>
									-->
									
										<!-- 
									<div class="container">
										<div class="col-md-5">
										    <div class="form-area">  
										        <form role="form">
										        <br style="clear:both">
										                    <h3 style="margin-bottom: 25px; text-align: center;">Новая книга</h3>
										    				<div class="form-group">
																<input type="text" class="form-control" id="name" name="name" placeholder="Name" required>
															</div>
															
															<div class="form-group">
																<input type="file" class="form-control" id="name" name="name" placeholder="Name" required>
															</div>
															
										                    <div class="form-group">
										                    <textarea class="form-control" type="textarea" id="message" placeholder="Message" maxlength="140" rows="7"></textarea>
										                        <span class="help-block"><p id="characterLeft" class="help-block ">You have reached the limit</p></span>                    
										                    </div>
										            
										        <button type="button" id="submit" name="submit" class="btn btn-primary pull-right">Добавить</button>
										        </form>
										    </div>
										</div>
										</div>
									 -->
                 
           </div>
       </div>
     	</div>
      
      
     	<div id="footer">
          
     	</div>
      </div>
</body>
</html>