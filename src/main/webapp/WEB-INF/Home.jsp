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
	<h1>Welcome to the message application</h1>
	<h2>Choose a topic to see its messages</h2>
	<c:choose>
		<c:when test="${allfolder.size()>0}">
			<table border="2" style="width: 345px; height: 53px; ">
				<tr>
					<th style="width: 95px; "> folder</th>
					<th style="width: 122px; ">sub_folder</th>
				</tr>
				<tbody>
					<c:forEach var="FoldORSub" items="${allfolder}">
						<c:choose>
							<c:when test="${allfolder()=="subfolder"}">
								<c:url value="/document" var="regURL">
								<c:param name="subfolder" value="${FoldORSub.name}" />
								<c:param name="folder" value="${FoldORSub.currentfolder}" />
								</c:url>
								<td><a href="${regURL}"> <c:out value="${FoldORSub.name}" />
								</a></td>	
								</c:when>
							<c:otherwise>
								
							<td> <c:out value="${FoldORSub.name}" /></td>	
							</c:otherwise>
						</c:choose>
						<c:url value="/GetMessagesOfTopic" var="regURL">
							<c:param name="topicid" value="${topic.id}" />
						</c:url>
						<td><a href="${regURL}"> <c:out value="${topic.name}" />
						</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<br><br><br><br><br><br><br><br><c:otherwise>No folder  to display.
		</c:otherwise>
	</c:choose>

</body>
</html>