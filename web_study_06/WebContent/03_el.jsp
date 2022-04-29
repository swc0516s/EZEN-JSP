<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	\${5+2}:\${5+2}<br>
	\${5+2}:${5+2}<br>
<%-- 	${5 div 2}--%>
	\${5%2}:${5%2}<br>
	\${5 mod 2}:${5 mod 2}<br>
	\${5>2}:${5>2}<br>
	\${(5>2)? 5:2}:${(5>2)?5:2}<br>
	\${(5>2) ||(2<10)}:${(5>2) || (2<10)}<br>
	\${(5>2) &&(2<10)}:${(5>2) && (2<10)}<br>
	<%String input=null; %>
	\${empty input }:${empty input} <br><br> <%-- empty 널 검사 --%>
	
	<%
	
		if(input==null){
		out.println("텅 빈 객체(null)입니다.");
		}
		%>
		
		
		<%-- JSTL(JSP Standard Tag Library) --%>
</body>
</html>