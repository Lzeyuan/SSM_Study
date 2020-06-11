<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10465
  Date: 2020/6/9
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>TEST!!!</h1>
    <table>
        <tbody>
            <c:forEach var="book" items="${list}">
                <tr>
                    <td>${book.id}</td>
                    <td>${book.name}</td>
                    <td>${book.password}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
