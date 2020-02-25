<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../../resources/css/style.css">

</head>
<body>

<div class="boxSite">
    <div class="box">Система управления студентами и их успеваемостью</div>
    <h2>Вход в систему: </h2>
    <form action="/login" method="post">
    <p><label for="login">Введите логин</label>
        <input type="text" id="login" name="login" placeholder="Введите логин" required autofocus></p>

    <p><label for="password">Ввелдте логин</label>
        <input type="text" id="password" name="password" placeholder="Введите пароль" required autofocus></p>

    <p><label for="role">Выберите роль</label>
        <select id="role" name="role">
            <option value="admin">Администратор</option>
            <option value="student">Студент</option>
        </select></p>


    <input type="submit" value="Войти" class="buttonModify">

        <c:if test="${error eq 1}">
            <p>Пользователь не найден!</p>
        </c:if>
    </form>
</div>
</body>
</html>
