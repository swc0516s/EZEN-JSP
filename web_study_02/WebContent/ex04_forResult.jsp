<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!public int sum(int a) {
		int total = 0;

		for (int i = 1; i <= a; i++) {
			total += i;
		}
		return total;
	}%>


	<h1>계산 결과</h1>

	<%
		int n = Integer.parseInt(request.getParameter("num"));

		for (int i = 1; i <= n; i++) {
			if (i == n) {
				out.print(i);
			} else {
				out.print(i + "+");
			}
		}
			out.print("=" + sum(n));
	%>
</body>
</html>