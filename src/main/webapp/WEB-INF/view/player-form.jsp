<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

    <form:form action="savePlayer" modelAttribute = "player" method="post" >
        <form:hidden path="id"/>

        <table>
            <tbody>
            <tr>
                <td><label>First Name :</label></td>
                <td><form:input path="firstName"/></td>
                <td><form:errors path="firstName" cssClass="error" /></td>

            </tr>
            <tr>
                <td><label>last Name :</label></td>
                <td><form:input path="lastName"/></td>
                <td><form:errors path="lastName" cssClass="error" /></td>

            </tr>
            <tr>
                <td><label> Date of Birth :</label></td>
                <td><form:input path="dateOfBirth"/></td>
               <td><form:errors path="dateOfBirth" cssClass="error" /></td>

            </tr>
<%--            <tr>--%>
<%--                <td><label>Role :</label></td>--%>
<%--                <td><form:input path="role"/></td>--%>

<%--            </tr>--%>
            <tr>
                <td><label>Age :</label></td>
                <td><form:input path="age"/></td>
                <td><form:errors path="age" cssClass="error" /></td>

            </tr>
            <tr>
                <td><label> select role :</label></td>
                <td> <
                      <form:select path="role">
                          <form:option value="Player" label="Player"/>
                          <form:option value="Coach" label="Coach"/>
                          <form:option value="Team Staff" label="Team staff"/>
                      </form:select>
                      </td>
                <td><form:errors path="lastName" cssClass="error" /></td>

            <tr>
                <td><label></label></td>
                <td><input type="submit" value =" Save" class = "Save"><td>

            </tr>
            </tbody>

        </table>
    </form:form>

    <div style="clear ; both"></div>
    <p>
        <a href = "${pageContext.request.contextPath}/player/list">Back to list</a>
    </p>

</div>
</body>
</html>