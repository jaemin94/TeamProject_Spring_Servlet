<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>사용자 정보 업데이트 결과</title>
</head>
<body>
    <h2>사용자 정보 업데이트 결과</h2>
    
    <c:choose>
        <c:when test="${rValue}">
            <p>사용자 정보가 성공적으로 업데이트되었습니다.</p>
        </c:when>
        <c:otherwise>
            <p>사용자 정보 업데이트에 실패했습니다.</p>
        </c:otherwise>
    </c:choose>
    
    <p><a href="${pageContext.request.contextPath}/user_select?id=${id}">업데이트한 사용자 정보 확인</a></p>
</body>
</html>
