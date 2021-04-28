<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>로그인화면</title>
</head>
<body>
	<div>
		<h1>[ 会議室予約プログラム ]</h1>
		
		<div>
			<c:choose>
				<c:when test="${empty sessionScope.loginId }">
					<form action="/member/login" method="post">
						<table>
							<tr>
								<th>ID</th>
								<td>
									<input type="text" name="id" id="id">
								</td>
							</tr>
							<tr>
								<th>Password</th>
								<td>
									<input type="password" name="password" id="password">
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<input type="submit" value="Login">
								</td>
							</tr>
						</table>
					</form>
				</c:when>
				<c:otherwise>
						${sessionScope.loginName }님 로그인중
						<a href="/member/logout">ログアウト</a>
				</c:otherwise>
			</c:choose>
		</div>
		
	</div>
</body>
</html>
