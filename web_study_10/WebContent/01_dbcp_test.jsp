<%@page import="javax.naming.InitialContext"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>DB연동</h4>
	<%--DBCP(DataBase Connection Pool --%>
	<%
		Context context = null;
	//context 현재 작업하고 있는 프로젝트
		DataSource dataSource = null;
	// 자원
		Connection connection = null;
		
		try{
			context=new InitialContext();
			dataSource=(DataSource)context.lookup("java:/comp/env/jdbc/Oracle11g");
			connection=dataSource.getConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		out.println("DBCP 연동 성공!");
	%>
</body>
</html>