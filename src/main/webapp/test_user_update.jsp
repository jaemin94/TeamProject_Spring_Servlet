<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>사용자 정보 수정</title>
</head>
<body>
    <h2>사용자 정보 수정</h2>
    <form action="${pageContext.request.contextPath}/user/update.do" method="post">
        <!-- 수정 페이지로 전달할 파라미터 -->
        <input type="hidden" name="id" value="${id}">
        
        <p>ID: ${id}</p>
        
        <!-- 수정할 정보 입력 -->
        <p>비밀번호: <input type="password" name="pw" required></p>
        <p>이름: <input type="text" name="username" value="${userDto.name}" required></p>
        <p>주소: <input type="text" name="adr_addr" value="${userDto.addr}" required></p>
        <p>전화번호: <input type="text" name="phone" value="${userDto.phone}" required></p>
        <p>역할: <input type="text" name="role" value="${userDto.role}" required></p>
        
        <!-- 수정 버튼 -->
        <p><button type="submit">수정</button></p>
    </form>
    
    <!-- 사용자 정보 보기 페이지로 돌아가는 링크 -->
    <p><a href="${pageContext.request.contextPath}/user_info?id=${id}">사용자 정보 보기</a></p>
</body>
</html>
