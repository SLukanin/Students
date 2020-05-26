<%--
  Created by IntelliJ IDEA.
  User: lukich
  Date: 2019-09-09
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../../resources/css/style.css">
</head>
<body>
<div>
    <a href="#" class="logout">Logout</a>
</div>
<div>
    <a href="../../index.jsp" class="first">На главную</a>
</div>
<div>
    <a href="#" class="back">Назад</a>
</div>
<div class="boxSite">
    <div class="box">Система управления студентами и их успеваемостью</div>
    <h2>Для того, чтобы создать новую дисциплину, заполните все поля и нажмите кнопку "Создать"</h2>
    <p><label for="nameDiscipline">Название</label>
    </p>
    <form action="/create-discipline" method="post">
        <input type="text" id="nameDiscipline" name="secondName" placeholder="Введите дисциплину" required autofocus>
        <input value="Создать" type="submit" class="buttonModify">
    </form>
</div>
</body>
</html>