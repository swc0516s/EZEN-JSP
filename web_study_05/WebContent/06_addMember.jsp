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
	<h2>입력된 회원 정보</h2>
	<jsp:useBean id="member" class="com.saeyan.javabeans.MemberBean"></jsp:useBean>
	<jsp:setProperty name="member" property="*"></jsp:setProperty>
	<table>
		<tr>
			<td>이름</td>
			<td><jsp:getProperty property="name" name="member"></jsp:getProperty></td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><jsp:getProperty property="userid" name="member"></jsp:getProperty></td>
		</tr>
		<tr>
			<td>별명</td>
			<td><jsp:getProperty property="nickname" name="member"></jsp:getProperty></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><jsp:getProperty property="pwd" name="member"></jsp:getProperty></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><jsp:getProperty property="email" name="member"></jsp:getProperty></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><jsp:getProperty property="phone" name="member"></jsp:getProperty></td>
		</tr>
	</table>


</body>
</html>