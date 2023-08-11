<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>사용자 목록</title>
</head>
<body>
    <h2>사용자 목록</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>이름</th>
            <th>전화번호</th>
            <th>주소</th>
        </tr>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.phone}</td>
                <td>${user.addr}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
