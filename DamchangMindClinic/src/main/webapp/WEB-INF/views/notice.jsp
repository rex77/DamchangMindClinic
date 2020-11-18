<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="includes/header.jsp"%>
<link href="/resources/css/notice.css" rel="stylesheet" type="text/css" />

<div id="wrapper">
	<div id="subtitle">공지사항</div>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">번호</th>
				<th scope="col">제목</th>
				<th scope="col">작성자</th>
				<th scope="col">작성일</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="board">
			<tr>
				<th><c:out value="${board.bno}" /></th>
				<td><a href="<c:out value='/notice/view?bno=${board.bno}' />"><c:out value="${board.title}" /></a></td>
				<td><c:out value="${board.writer}" /></td>
				<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.registerDate}" /></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<%@include file="includes/footer.jsp"%>