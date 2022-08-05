<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Detail</title>
</head>
<body>

<table>
<thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Age</th>
            <th>Dojo</th>
        </tr>
</thead>
<tbody>
	<tr>
		<td><c:out value="${ninja.firstName}"/></td>
        <td><c:out value="${ninja.lastName}"/></td>
        <td><c:out value="${ninja.age}"/></td>
        <td><c:out value="${ninja.dojo.name}"/></td>
	
	</tr>

</tbody>

</table>

</body>
</html>