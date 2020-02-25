<%--
  Created by IntelliJ IDEA.
  User: lukich
  Date: 2019-08-23
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <a href="#" class="logout">Logout</a>
</div>
<div>
    <a href="../../index.jsp" class="first">На главную</a>
</div>
<div>
    <a href="javascript:history.back()" class="back">Назад</a>
</div>
<div class="boxSite">
    <div class="box">Система управления студентами и их успеваемостью</div>

    <div class="firstRow">
        <div class="table">
            <div class="table-row">
                <div class="table-cellH checkbox"></div>
                <div class="table-cellH secondName">Наименование дисциплины</div>
            </div>

            <c:forEach items="${disciplines}" var ="d">
            <div class="table-row">
                <div class="table-cell checkbox">
                    <fieldset>
                        <input type="checkbox" value="${d.id}">
                    </fieldset>
                </div>
                <div class="table-cell">${d.discipline}</div>
            </div>
            </c:forEach>

<%--            <div class="table-row">--%>
<%--                <div class="table-cell">--%>
<%--                    <fieldset>--%>
<%--                        <input t   ype="checkbox">--%>
<%--                    </fieldset>--%>
<%--                </div>--%>
<%--                <div class="table-cell">История Науки и Техники</div>--%>
<%--            </div>--%>
        </div>
    </div>

    <div class="secondRow">
        <div class="admin-bottom">

            <form action="/create-discipline">
                <button>Создать дисциплину</button>
            </form>

                <input type="submit" onclick="modifyDiscipline()" value="Модифицировать дисциплину">
             <form action="/modify-discipline" id="modifDiscForm">
                 <input type="hidden" name="idModifyDisc" id="idModifyDisc">
            </form>

            <input type="submit" onclick="deleteDiscipline()" value="Удалить дисциплину">

            <form action="/delete-discipline" id="deleteDiscForm" method="get">
                <input type="hidden" name="idsDeleteDisc" id="idsDeleteDisc">
            </form>
        </div>
    </div>
</div>
</body>