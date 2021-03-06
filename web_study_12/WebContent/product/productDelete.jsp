<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<script type="text/javascript" src="script/product.js"></script>
</head>
<body>
	<div id="wrap" align="center">
		<h1>상품 삭제-관리자 페이지</h1>
		<form action="productDelete.do" method="post" name="frm">
			<table>
				<tr>
					<td><c:choose>
							<c:when test="${empty product.pictureUrl}">
								<img src="upload/noimage.gif">
							</c:when>
							<c:otherwise>
								<img src="upload/${product.pictureUrl}">
							</c:otherwise>
						</c:choose></td>
					<td>
						<table>
							<tr>
								<th style="width: 80px">상품명</th>
								<td>${product.name}</td>
							<tr>
								<th>가격</th>
									<td>${product.price}원</td>
							</tr>
							<tr>
								<th>설명</th>
								<td>
									<div style="height:220px;width:100%">
										${product.description}
									</div>
								</td>

							</tr>
							<tr>
								<th>설명</th>
								<td><textarea cols="90" rows="10" name="description"
										style="resize: none">${product.description}</textarea></td>
						</table>
					</td>
				</tr>
			</table>
			<br> <input type="hidden" name="code" value="${product.code}"> 
			<input type="submit" value="삭제">
			<input type="button" value="목록" onclick="location.href='productList.do'">
		</form>
	</div>
</body>
</html>