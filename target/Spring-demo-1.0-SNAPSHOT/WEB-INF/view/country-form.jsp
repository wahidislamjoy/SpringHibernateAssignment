<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>country add form</title>
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
        <h2>International Cricket Council - Form For Country </h2>
    </div>
</div>

<div id = "container">
    <h3>save country</h3>

    <form:form action="saveCountry" modelAttribute = "country" method="post" >
        <form:hidden path="id"/>

        <table>
            <tbody>
            <tr>
                <td><label> Name :</label></td>
                <td><form:input path="name"/></td>
                <td><form:errors path="name" cssClass="error" /></td>

            </tr>

            <tr>
                <td><label>Country code :</label></td>
                <td><form:input path="countryCode"/></td>
                <td><form:errors path="name" cssClass="error" /></td>

            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value =" Save" class = "Save"><td>

            </tr>
            </tbody>

        </table>
    </form:form>

    <div style="clear ; both"></div>
    <p>
        <a href = "${pageContext.request.contextPath}/country/list">Back to list</a>
    </p>

</div>
</body>
</html>