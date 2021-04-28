<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<div>
		<table>
			<tr>
				<td>
					<a href="/room/main">会議室予約状況</a>
				</td>
				<td>
					<a href="/room/myReservation">私の会議のリスト</a>
				</td>
				<td>
					${sessionScope.loginName }さんがログイン中
				</td>
				<td>
					<a href="/member/logout">ログアウト</a>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>