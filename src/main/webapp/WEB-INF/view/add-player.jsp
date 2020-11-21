<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: jubaerbaker
  Date: 20/11/20
  Time: 8:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add player to the team</title>
</head>
<body>
<h1>Team name :${team.name}</h1>

<form:form action="savePlayerToTeam" modelAttribute="player"  method="post">
    <form:hidden path = "team.id" value = "${team.id}" />

    <table>
        <tr>

            <td>
                <form:select class="form-control" path="id" >
                    <c:forEach var="tempPlayer" items="${players}">
                        <c:if test="${empty tempPlayer.team}">
                            <form:option value="${tempPlayer.id}" label="${tempPlayer.firstName} ${tempPlayer.lastName}  role = ${tempPlayer.role}"/>
                        </c:if>

                    </c:forEach>
                </form:select>
            </td>



        </tr>
        <tr>
            <td><label></label></td>
            <td><input type="submit" value =" Save" class = "Save"><td>

        </tr>
    </table>

</form:form>
</body>

</html>
