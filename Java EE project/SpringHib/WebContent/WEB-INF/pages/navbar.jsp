<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
    <spring:url value="/books" var="booksurl" />
     <spring:url value="/main" var="mainurl" />
      <spring:url value="/authors" var="authorsurl" />
      <spring:url value="/upload" var="uploadurl" />
      <spring:url value="/searchItem" var="url" />

    <div id="navbar" >
      <div class="container">
          <div class="row">
              <div id="heading">
              <!--  
                 <div id="currentuser">
                 	<font><h4><b>
                 		Добро пожаловать: <c:out value="${sessionScope.currentuser}"/>  
                 		 <button style="background-color:#FF512F; color: black; border-color: black;" onClick='<c:url value="/upload"/>' type="button"  class="btn btn-default btn-sm">Выход</button>
                 	</b></h4></font>
                 </div>
                 -->
                  <div id="logo"><img src="${pageContext.request.contextPath}/resources/img/logo.png" width="55" height="45" alt="logo"></div>
                  <div id="title"><font><h2><b>Online reading</b></h2></font></div>
                 
              </div>
              <div class="navbar navbar-inverse">
                  <div class="container">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#responsive-menu">
                            <span class="sr-only">Развернуть</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                       <!--<a class="navbar-brand" href="#"></a>-->
                    </div>
                         <form:form action="${url}" class="navbar-form navbar-right search-form" role="search" commandName="book">                        
				             <input type="text" name="searchstr" class="form-control" placeholder="Поиск" />
			             </form:form>
                        <div class="collapse navbar-collapse" id="responsive-menu">
                            <ul class="nav navbar-nav">
                                <li><a href="${mainurl}"><font>Главная</font></a> </li>
                                <li><a href="${authorsurl}"><font>Авторы</font></a></li>                        
                                <li><a href="${booksurl}"><font>Книги</font> </a></li>
                                <li><a href="${uploadurl}"><font>Загрузка книги</font> </a></li>
                            </ul>  
                        </div>  
                      </div>
                  </div>             
              </div>
          </div>
      
          <div class="container-fluid">   
              <div class="row">
                  <div class="col-lg-4 col-sm-offset-1"></div>
                  <div class="col-lg-4 col-sm-offset-1"></div>           
              </div>
          </div>           
      </div>