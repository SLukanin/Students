<%--
  Created by IntelliJ IDEA.
  User: lukich
  Date: 2019-10-05
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>student progress</title>
    <link rel="stylesheet" href="mainPageStyles.css">
    <link href="https://fonts.googleapis.com/css?family=Lacquer&display=swap" rel="stylesheet">
</head>

<body>

<table><tr>
    <th>Control system of students and their academic performance</th>
</tr></table>

<button><a href="../../index.jsp">to main</a></button><br>

<button><a href="/logout">logout</a></button><br>


<input type="button" onclick="history.back();" value="back"/>

<h1>Displayed academic performance for follow student</h1>
<br>



<table>
    <thead class="thead1">
    <tr>
        <th>Last name</th>
        <th>First name</th>
        <th>Group</th>
        <th>Enrollment date</th>
    </tr>
    </thead>

    <thead>
    <tr>
        <td>${student.surname}</td>
        <td>${student.name}</td>
        <td>${student.group}</td>
        <td>${student.date}</td>
    </tr>
    </thead>
</table>
<br>
<br>

<aside>
    <form action="http://echo.htmlacademy.ru"autocomplete="off" method="post" class="sp">
        Choose term

        <select>

            <option value="1">Term 1</option>
            <option value="1">Term 2</option>
            <option value="1">Term 3</option>
            <option value="1">Term 4</option>

        </select>

        <br>
        <br>
        Average assessment for term:
    </form>
</aside>


<section>
    <table>
        <caption>
            Disciplines list
        </caption>
        <thead class="thead1">
        <tr>
            <th>Discipline</th>
            <th class="th1">Assessment</th>

        </tr>
        </thead>
        <c:forEach items="${marks}" var="mark">
            <tr>
                <td>${mark.discipline.discipline}</td>
                <td>${mark.mark}</td>
            </tr>

        </c:forEach>

    </table>
</section>

</body>

</html>