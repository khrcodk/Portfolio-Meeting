<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
<script type="text/javascript">
function reservationForm(roomNum){
	location.href = "/room/reservationForm?roomNum="+roomNum;
}
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/menu/menu.jsp" />
	<div>
		<h1>会議室予約状況</h1>
		<c:forEach items="${list }" var="obj">
			<div>
				<div>
					${obj.roomName } <img alt="추가" src="/resources/images/plus.png" onclick="reservationForm(${obj.roomNum });">
				</div>
				<table>
					<tr>
						<th>タイトル</th>
						<th>開始</th>
						<th>終了</th>
						<th>キャンセル</th>
					</tr>
					<c:forEach items="${obj.reservationList }" var="reservation">
						<tr>
							<td>${reservation.title }</td>
							<td>${reservation.startTime }</td>
							<td>${reservation.endTime }</td>
							<td>
								<a href="/room/cancelReservation?reservationNum=${reservation.reservationNum }">キャンセル</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</c:forEach>
	</div>
</body>
</html>