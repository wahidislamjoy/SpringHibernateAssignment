<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib  uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Country-list</title>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>International Cricket Council - Team List</h2>
    </div>
</div>

<div id="container">

    <div id="content">

        <!-- put new button for adding country -->
        <c:url var="countryList" value="/country/list">

        </c:url>
        <input type="button" value="view country list"
               onclick="window.location.href='${countryList}'; return false;"
               class="add-button"
        />
        <c:url var="viewPlayers" value="/player/list">

        </c:url>
        <input type="button" value="view player list"
               onclick="window.location.href='${viewPlayers}'; return false;"
               class="add-button"
        />

        <input type="button" value="Add Team"
               onclick="window.location.href='showFormForAdd'; return false;"
               class="add-button"
        />

        <!--  add our html table here -->

        <table>
            <tr>
                <th>Team Name</th>
                <th>Country Name</th>
                <th>Action</th>
            </tr>

            <!-- loop over and print our countrys -->
            <c:forEach var="tempTeam" items="${teams}">


                <!-- construct an "update" link with country id -->

                <c:url var="updatelink" value="/team/showFormForUpdate">
                    <c:param name="teamId" value="${tempTeam.id}"/>
                </c:url>

                <c:url var="deletelink" value="/team/delete">
                    <c:param name="teamId" value="${tempTeam.id}"/>
                </c:url>
                <c:url var="viewteam" value="/team/viewTeam">
                    <c:param name="teamId" value="${tempTeam.id}"/>
                </c:url>


                <tr>
                    <td> ${tempTeam.name} </td>
                    <td> ${tempTeam.country.name} </td>
                    <td> <a href="${updatelink}">update</a>
                        <a href="${viewteam}">view</a>
                        <a href="${deletelink}" onclick="if (!(confirm('Are you sure you want to delete this country?'))) return false">|Delete</a>
                    </td>
                </tr>

            </c:forEach>


        </table>

    </div>

</div>
</body>
</html>