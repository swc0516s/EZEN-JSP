<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
%>

당신이 입력한 정보입니다.(request방식).<br>
아이디:<%= request.getParameter("id") %><br>
암&nbsp;호:<%= request.getParameter("pwd") %><br><br>

당신이 입력한 정보입니다.(EL방식).<br>
아이디:${param.id} <br>
암&nbsp;호:${param.pwd} <br><br>
암&nbsp;호:${param.["pwd"]} <br><br>

</body>
</html>