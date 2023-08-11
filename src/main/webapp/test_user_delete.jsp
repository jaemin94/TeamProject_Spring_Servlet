<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>사용자 삭제 페이지</title>
</head>
<body>
    <h1>사용자 삭제 페이지</h1>
    
    <form action="${pageContext.request.contextPath}/user/delete.do" method="post">
        <input type="hidden" name="sid" value="<c:out value='${param.id}' />" />
        <button type="submit">사용자 삭제</button>
    </form>
    
    <p>
        <!-- 여기에 메시지나 에러를 표시합니다 -->
        <c:if test="${not empty errorMessage}">
            <span style="color: red;"><c:out value="${errorMessage}" /></span>
        </c:if>
    </p>
</body>
</html>
