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
		Cookie[] cookies = request.getCookies();

		for (int i = 0; i < cookies.length; i++) {
			String str = cookies[i].getName();

			if (str.equals("cookieName")) {
				out.println("cookies[" + i + "]name:" + cookies[i].getName() + "<br>");
				out.println("cookies[" + i + "]value:" + cookies[i].getValue() + "<br>");
				out.println("=========================<br>");
			}
				//out.println("cookies[" + i + "]name:" + cookies[i].getName() + "<br>");
				//out.println("cookies[" + i + "]value:" + cookies[i].getValue() + "<br>");
		}
	%>
	
	
	
	<a href="06_cookiedel.jsp"></a>
	
	
	
	
</body>
</html>