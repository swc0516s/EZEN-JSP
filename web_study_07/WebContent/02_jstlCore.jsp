<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%--var 변수  --%>
	<c:set var="msg" value="Hello" />
	\${msg}=${msg}<br>
	
	<c:set var="age">30</c:set>
	\${aeg}=${age}<br><br>
	
	<c:set var="member" value="<%=new com.saeyan.javabeans.MemberBean() %>"></c:set>
	<c:set target="${member}" property="name" value="홍길동"/>
	<c:set target="${member}" property="userid" value="hong"/>
	\${member.name}=${member.name}<br><br>
	\${member.userid}=${member.userid}<br><br>
	
	<c:set var="add" value="${10+5}"/>	
	\${add}=${add} <br>
	
	<c:set var="flag" value="${10>5}"/>	
	\${flag}=${flag} <br>
	
	<c:remove var="flag"/>
	\${flag}=${flag} <br>
	
</body>
</html>






