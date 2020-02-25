<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../../resources/css/style.css">
    <link rel="stylesheet" href="../../resources/lib/jquery-ui-1.12.1/jquery-ui.css">
    <script src="../../resources/lib/jquery-ui-1.12.1/jquery.js"></script>
    <script src="../../resources/js/jquery.min.js"></script>
    <script src="../../resources/lib/jquery-ui-1.12.1/jquery-ui.js"></script>

    <script>
        $( function() {
            $( "#date" ).datepicker({ dateFormat: 'yy-mm-dd', changeMonth: true,
                changeYear: true, yearRange: "1920:2019"});
        } );
    </script>

</head>
<body>
<div>
    <a href="#" class="logout">Logout</a>
</div>
<div>
    <a href="../../index.jsp" class="first">На главную</a>
</div>
<div>
    <a href="javascript:history.back()" title="Вернуться на предыдущую страницу"  class="back">Назад</a>
</div>
<div class="boxSite">
    <div class="box">Система управления студентами и их успеваемостью</div>

    <h2>Для подтверждения изменений нажмите кнопку "Изменить"</h2>
    <form action="/student-modify" method="post">

    <p><label for="secondName">Фамилия</label>
        <input type="text" id="secondName" name="surname" value="${student.surname}" required autofocus></p>
    <p><label for="name">Имя</label>
        <input type="text" id="name" name="name" value="${student.name}" required></p>
    <p><label for="group">Группа</label>
        <input type="text" id="group" name="group" value="${student.group}" required></p>
    <p><label for="date">Дата поступления</label>
        <input type="text" id="date" name="date" value="${student.date}" required></p>
<input type="hidden" name="idModifyStudent" value="${student.id}">

    <input type="submit" value="Применить" class="buttonModify">
    </form>
</div>
</body>
</html>