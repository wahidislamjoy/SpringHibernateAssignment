<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>team add form</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css" />
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
    <style>
        .error {color:red}
    </style>
</head>
<body>
<div id ="wrapper">
    <div id ="header">
        <h2>International Cricket Council - Form For Team </h2>
    </div>
</div>

<div id = "container">
    <h3>save team</h3>

    <form:form action="saveTeam" modelAttribute = "team" method="post" >
        <form:hidden path="id"/>

        <table>
            <tbody>
            <tr>
                <td><label> Name :</label></td>
                <td><form:input path="name"/></td>
                <td><form:errors path="name" cssClass="error" /></td>

            </tr>
            <td><label> select country :</label></td>
<%--            <td><form:select  class="custom-select" path="country.id">--%>
<%--                <c:forEach var="tempTeam" items="${country_list}">--%>

<%--                <form:options items="${country_list}" itemLabel="name" itemValue="id" />--%>
<%--                </c:forEach>--%>
<%--            </form:select></td>--%>
            <td>

                <form:select class="custom-select" path="country.id">
                   <c:forEach var="tempCountry" items="${country_list}">
                       <c:if test="${empty tempCountry.team}">
                           <form:option value="${tempCountry.id}" label="${tempCountry.name}"/>
                       </c:if>
                   </c:forEach>
                </form:select>
            </td>
            <td><form:errors path="country" cssClass="error" /></td>

            <tr>
                <td><label></label></td>
                <td><input type="submit" value =" Save" class = "Save"><td>

            </tr>
            </tbody>

        </table>
    </form:form>

    <div style="clear ; both"></div>
    <p>
        <a href = "${pageContext.request.contextPath}/team/list">Back to list</a>
    </p>

</div>
</body>
</html>