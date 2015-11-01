<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:import url="imports.jsp" charEncoding="UTF-8"></c:import>
<spring:url value="/genres" var="genresurl" />

  <div id="column"> 
              
            <ul style="position: absolute; top: 400px;" class="nav sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#">
                       Жанры
                    </a>
                </li>
                
                <c:forEach items="${genres}" var="genre">
                	<li>
                   		  <a href='<c:url value="/opengenre?index=${genre.id}"/>'><font>${genre.name}</font></a>
                	</li>
                </c:forEach>	
             
            </ul>

           </div>