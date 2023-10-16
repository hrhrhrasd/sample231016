<%--
  Created by IntelliJ IDEA.
  User: admin2
  Date: 2023-10-16
  Time: 오후 4:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>home</title>
</head>
<body>
<h3>Todo list</h3>
<form action="/add" method="post">
    <input type="text" name="todo" placeholder="할 일을 입력하세요">
    <button>추가</button>
</form>
<c:if test="${result}"><div>추가완료</div></c:if>
<h4>Todo</h4>
<div>
    <table>
        <tr>
        <th>id</th>
        <th>todo</th>
        <th>date</th>
        </tr>
        <c:forEach items="${todoList}" var="todo">
            <tr>
                <td>${todo.id}</td>
                <td>${todo.todo}</td>
                <td>${todo.inserted}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
