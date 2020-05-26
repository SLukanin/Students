 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../../resources/css/style.css">
    <script src="../../resources/js/functions.js" ></script>
    <script src="../../resources/js/jquery.min.js"></script>
</head>
<body>
<div>
    <a href="/logout" class="logout">Logout</a>
</div>
<div>
    <a href="../../index.jsp" class="first">На главную</a>
</div>
<div>
    <a href="javascript:history.back()" title="Вернуться на предыдущую страницу"  class="back">Назад</a>
</div>
<div class="boxSite">
    <div class="box">Система управления студентами и их успеваемостью</div>
    <div class="admin-bottom">

        <form action="/student-progress" id="StudentProgressForm">
            <input type="hidden" id="idStudentProgress" name="idStudentProgress">
        </form>
        <input onclick="studentProgress()" type="submit" value="Просмотреть успеваемость выбранного студента">

        <c:if test="${role eq 'admin'}">

        <form action="/create-students">
            <button type="submit">Создать студента</button>
        </form>


        <form action="/student-modify" id="ModifyStudentForm">
            <input type="hidden" name="idModifyStudent" id="idModifyStudent">
        </form>
            <input onclick="modifyStudent()" type="submit" value="Модифицировать выбранного студента">

        <form action="/delete-student" id="deleteStudentForm">
            <input type="hidden" name="idsStudent" id="idsStudent">
            <button onclick="deleteStudent()" type="submit">Удалить выбранных студентов</button>
        </form>

        </c:if>
    </div>
    <!--<table>-->
    <!--    <caption>Список студентов</caption>-->
    <!--    <tr>-->
    <!--        <th></th>-->
    <!--        <th>Фамилия</th>-->
    <!--        <th>Имя</th>-->
    <!--        <th>Группа</th>-->
    <!--        <th>Дата поступления</th>-->
    <!--    </tr>-->
    <!--        <td>-->
    <!--            <p><fieldset>-->
    <!--                <input type="checkbox" id="0">-->
    <!--            </fieldset>-->
    <!--            </p>-->
    <!--        </td>-->
    <!--    <tr>-->
    <!--        <td>Сидоров</td>-->
    <!--        <td>Сидор</td>-->
    <!--        <td>КТ-21</td>-->
    <!--        <td>1/09/2011</td>-->
    <!--    </tr>-->
    <!--</table>-->
    <div class="table">
        <div class="tableName">Список студентов
            <div class="table-row">
                <div class="table-cellH checkbox"></div>
                <div class="table-cellH secondName">Фамилия</div>
                <div class="table-cellH name">Имя</div>
                <div class="table-cellH group">Группа</div>
                <div class="table-cellH date">Дата поступления</div>
            </div>
            <c:forEach items="${students}" var="s">
                <div class="table-row">
                    <div class="table-cell">
                        <fieldset>
                            <input type="checkbox" value="${s.id}">
                        </fieldset>
                    </div>
                    <div class="table-cell">${s.surname}</div>
                    <div class="table-cell">${s.name}</div>
                    <div class="table-cell">${s.group}</div>
                    <div class="table-cell">${s.date}</div>

                </div>
            </c:forEach>
        </div>

    </div>
</div>
</body>
</html>
