<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
		<title>Create person</title>
	</head>
    <head>
        <title> list person</title>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    </head>
    <body>
        <table>
            <tr>
            		<th>ID</th>
                <th>First name</th>
                <th>Last name</th>
                <th>E-mail address</th>
            </tr>
            <c:forEach items="${listPerson}" var="person">
                <tr>
                		<td><c:out value="${person.idPerson}"/></td>
                    <td><c:out value="${person.name}"/></td>
                    <td><c:out value="${person.surname}"/></td>
                    <td><c:out value="${person.email}"/></td>
                </tr>
            </c:forEach>
        </table>
         <br/><a href="/">back</a>
		<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
	</body>
</html>