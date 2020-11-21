<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib  uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>player-list</title>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>International Cricket Council - Country list</h2>
    </div>
</div>

<div id="container">

    <div id="content">

        <!-- put new button for adding country -->
        <c:url var="TeamList" value="/team/list">

        </c:url>
        <c:url var="countryList" value="/country/list">

        </c:url>
        <input type="button" value="view team list"
               onclick="window.location.href='${TeamList}'; return false;"
               class="add-button"
        />
        <input type="button" value="view country list"
               onclick="window.location.href='${countryList}'; return false;"
               class="add-button"
        />
        <input type="button" value="AddPlayer"
               onclick="window.location.href='showFormForAdd'; return false;"
               class="add-button"
        />


        <!--  add our html table here -->

        <table>
            <tr>
                <th> First-Name</th>
                <th> Last-Name</th>
                <th>Role</th>
                <th>Date of Birth</th>
                <th>Age</th>

                <th>Action</th>
            </tr>

            <!-- loop over and print our countrys -->
            <c:forEach var="tempPlayer" items="${players}">


                <!-- construct an "update" link with country id -->

                <c:url var="updatelink" value="/player/showFormForUpdate">
                    <c:param name="playerId" value="${tempPlayer.id}"/>
                </c:url>

                <c:url var="deletelink" value="/player/delete">
                    <c:param name="playerId" value="${tempPlayer.id}"/>
                </c:url>


                <tr>
                    <td> ${tempPlayer.firstName} </td>
                    <td> ${tempPlayer.lastName} </td>
                    <td> ${tempPlayer.role} </td>
                    <td> ${tempPlayer.dateOfBirth} </td>
                    <td> ${tempPlayer.age} </td>
                    <td> <a href="${updatelink}">update</a>
                        <a href="${deletelink}" onclick="if (!(confirm('Are you sure you want to delete this country?'))) return false">|Delete</a>
                    </td>
                </tr>

            </c:forEach>


        </table>

    </div>

</div>
</body>
