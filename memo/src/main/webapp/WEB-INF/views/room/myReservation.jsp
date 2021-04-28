<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>私の会議のリスト</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/menu/menu.jsp" />
	<div>
		<h1>[ 私の会議のリスト ]</h1>
		<table>
			<tr>
				<th>タイトル</th>
				<th>会議室名</th>
				<th>開始</th>
				<th>終了</th>
				<th>不参加</th>
			</tr>
			<c:forEach items="${list }" var="reservation">
				<tr>
					<td>${reservation.TITLE }</td>
					<td>${reservation.ROOMNAME }</td>
					<td>${reservation.STARTTIME }</td>
					<td>${reservation.ENDTIME }</td>
					<td>
						<a href="/room/deleteMyReservation?num=${reservation.MYRESERVATIONNUM  }">不参加</a>
					</td>
				</tr>			
			</c:forEach>
		</table>
	</div>
</body>
</html>