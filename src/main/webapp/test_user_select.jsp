<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>사용자 정보</title>
</head>
<body>
    <h2>사용자 정보</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>이름</th>
            <th>전화번호</th>
            <th>주소</th>
        </tr>
        <tr>
            <td>${userDto.id}</td>
            <td>${userDto.name}</td>
            <td>${userDto.phone}</td>
            <td>${userDto.addr}</td>
        </tr>
    </table>
    
    <p><a href="${pageContext.request.contextPath}/test_user_update.jsp?id=${userDto.id}">정보 수정</a></p>
     <p><a href="${pageContext.request.contextPath}/test_user_delete.jsp?id=${userDto.id}">회원삭제</a></p>
</body>
</html>
