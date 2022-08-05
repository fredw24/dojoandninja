<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo List</title>
</head>
<body>
	<h1>List of Dojos</h1>
	<ul>
	  	<c:forEach items="${dojos}" var="dojo">
	        <li>
	           <a href="/dojo/${dojo.id}/ninjas"><c:out value="${dojo.name}"/></a>
	        </li>
	    </c:forEach>
	</ul>
	
	<a href="/dojo/new">Add Dojo</a>

</body>
</html>