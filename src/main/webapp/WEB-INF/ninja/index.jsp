<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Ninjas</title>
</head>
<body>
<h1>All Ninjas</h1>

	<ul>
	  	<c:forEach items="${ninjas}" var="ninja">
	        <li>
	           <a href="/ninja/${ninja.id}"><c:out value="${ninja.firstName}"/> <c:out value="${ninja.lastName}"/></a>
	        </li>
	    </c:forEach>
	</ul>
	
	<a href="/ninja/new">Add Ninja</a>

</body>
</html>