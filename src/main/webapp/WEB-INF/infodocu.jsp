<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/CSS/mystyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>folder list</title>
</head>
<body style="width: 1879px; height: 420px; ">

	<h2>here the information about document</h2>
		<c:when test="${document.size()>0}">
			<table border="5" style="width: 345px; height: 53px; ">
				<tr>
					<th style="width: 95px; "> name</th>
					<th style="width: 95px; "> owner</th>
					<th style="width: 95px; "> date</th>
					<th style="width: 95px; "> type</th>
					
				</tr>
				<tbody>
						<td><c:out value="${document.name}" /><td>
						<td><c:out value="${document.owner}" /><td>
						<td><c:out value="${document.date}" /><td>
						<td><c:out value="${document.type}" /><td>
						
				</tbody>
			</table>
		</c:when>
		

</body>
</html>