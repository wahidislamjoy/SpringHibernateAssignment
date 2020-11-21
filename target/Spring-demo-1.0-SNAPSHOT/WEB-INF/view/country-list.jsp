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
        <h2>International Cricket Council - Country list</h2>
    </div>
</div>

<div id="container">

    <div id="content">

        <!-- put new button for adding country -->
        <c:url var="viewTeams" value="/team/list">

        </c:url>
        <c:url var="viewPlayers" value="/player/list">

        </c:url>
        <c:url var="addTeam" value="/team/showFormForAdd">

        </c:url>
        <c:url var="addPlayer" value="/player/showFormForAdd">

        </c:url>
        <input type="button" value="view team list"
               onclick="window.location.href='${viewTeams}'; return false;"
               class="add-button"
        />
        <input type="button" value="view player list"
               onclick="window.location.href='${viewPlayers}'; return false;"
               class="add-button"
        />

        <input type="button" value="Add country"
               onclick="window.location.href='showFormForAdd'; return false;"
               class="add-button"
        />
        <input type="button" value="Add Team"
               onclick="window.location.href='${addTeam}'; return false;"
               class="add-button"
        />
        <input type="button" value="Add Player"
               onclick="window.location.href='${addPlayer}'; return false;"
               class="add-button"
        />


        <!--  add our html table here -->

        <table>
            <tr>
                <th>Country Name</th>
                <th>Country code</th>
                <th>Country Team</th>
                <th>Action</th>
            </tr>

            <!-- loop over and print our countrys -->
            <c:forEach var="tempCountry" items="${countries}">


                <!-- construct an "update" link with country id -->

                <c:url var="updatelink" value="/country/showFormForUpdate">
                    <c:param name="countryId" value="${tempCountry.id}"/>
                </c:url>

                <c:url var="deletelink" value="/country/delete">
                    <c:param name="countryId" value="${tempCountry.id}"/>
                </c:url>


                <tr>
                    <td> ${tempCountry.name} </td>
                    <td> ${tempCountry.countryCode} </td>
                    <td>${tempCountry.team.name}</td>
                    <td> <a href="${updatelink}">update</a>
                        <a href="${deletelink}" onclick="if (!(confirm('Are you sure you want to delete this country?'))) return false">|Delete</a>
                    </td>
                </tr>

            </c:forEach>


        </table>

    </div>

</div>
</body>
</html>