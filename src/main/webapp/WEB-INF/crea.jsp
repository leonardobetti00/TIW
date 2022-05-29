<%--
  Created by IntelliJ IDEA.
  User: giacomo
  Date: 29/05/2022
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Crea</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/CSS/mystyle.css">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<table>
    <tr>Cosa vuoi creare?</tr>
    <tr><td><form method="get" action="insert.jsp" enctype=text/plain>
        <INPUT TYPE="radio" name="command" VALUE="0"/>Cartella
        <INPUT TYPE="radio" NAME="command" VALUE="1"/>Sotto cartella
        <INPUT TYPE="radio" NAME="command" VALUE="2"/> Documento
    </form>
        <%= request.getParameter("command") %>
</td></tr>
    <c:choose>
        <c:when test =" ${param.command} = 0">
            <!--  cartella-->
        </c:when>
        <c:when test =" ${param.command} = 1">
            <!--  sottocartella-->
        </c:when>
        <c:when test =" ${param.command} = 2">
            <!--  documento-->
        </c:when>
    </c:choose>

</table>
</body>
</html>
