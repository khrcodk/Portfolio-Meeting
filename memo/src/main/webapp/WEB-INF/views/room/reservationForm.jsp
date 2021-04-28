<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会議室予約</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/menu/menu.jsp" />
	<div>
		<h1>会議室予約</h1>
		<form action="/room/reservation" method="post">
			<table>
				<tr>
					<th>	会議室名</th>
					<td>
						${map.room.name }
					</td>
				</tr>
				<tr>
					<th>タイトル</th>
					<td>
						<input type="text" name="title">
					</td>
				</tr>
				<tr>
					<th>開始</th>
					<td>
						<input type="text" name="startTime">
					</td>
				</tr>
				<tr>
					<th>終了</th>
					<td>
						<input type="text" name="endTime">
					</td>
				</tr>
				<tr>
					<th>参加者</th>
					<td>
						<c:forEach items="${map.memberList }" var="member">
							<input type="checkbox" name="entry" value="${member.id }">${member.name }
						</c:forEach>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="予約">
					</td>
				</tr>
			</table>
			<input type="hidden" name="roomNum" value="${map.room.num }">
		</form>
	</div>
</body>
</html>