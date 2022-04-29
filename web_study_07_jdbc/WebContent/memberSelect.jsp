<%@page import="com.javalec.daotoex.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.javalec.daotoex.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="400" border="1">
		<tr>
			<th>이름</th>
			<th>아이디</th>
			<th>암호</th>
			<th>전화번호</th>
			<th>성별</th>
		</tr>

		<%
			MemberDAO memberDAO = new MemberDAO();
			ArrayList<MemberDTO> dtos = memberDAO.memberSelect();

			for (int i = 0; i < dtos.size(); i++) {

				MemberDTO dto = dtos.get(i);
				String name = dto.getName();
				String id = dto.getId();
				String pw = dto.getPw();
				String phone = dto.getPhone1() + "-" + dto.getPhone2() + "-" + dto.getPhone3();
				String gender = dto.getGender();

				out.println("<tr>");
				out.println("<td>" + name + "</td>");
				out.println("<td>" + id + "</td>");
				out.println("<td>" + pw + "</td>");
				out.println("<td>" + phone + "</td>");
				out.println("<td>" + gender + "</td>");
				out.println("</tr>");

			}
		%>
	</table>

</body>
</html>