<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="includes/admin_header.jsp"%>
<link href="/resources/css/board_view.css" rel="stylesheet"
	type="text/css" />

<div id="wrapper">
	<div id="subtitle">질문게시판</div>
	<div id="content-wrapper">
		<h2>질문</h2>
		<div id="title">
			<div class="title01">
				<c:if test="${board.replyYn == 'y'}"> 답변입니다.	</c:if>
			</div>
			<div class="title02">
				<c:out value="${board.writer}" />
			</div>
			<div class="title03">
				<fmt:formatDate pattern="yyyy-MM-dd" value="${board.registerDate}" />
			</div>
		</div>
		<div id="content">
			<c:out value="${board.content}" />
		</div>
	</div>
	<div id="reply-wrapper">
		<h2>답변</h2>
		<div id="title">
			<div class="title01">
				<c:out value="${reply.title}" />
			</div>
			<div class="title02">
				<c:out value="${reply.writer}" />
			</div>
			<div class="title03">
				<fmt:formatDate pattern="yyyy-MM-dd" value="${reply.registerDate}" />
			</div>
		</div>

		<div id="content">
			<c:if test="${board.replyYn == 'n'}"> 아직 답변이 없습니다.	</c:if>
			<c:out value="${reply.content}" />
		</div>

	</div>
	<div id="btns">
		<c:if test="${board.replyYn == 'n'}">
			<a href="/admin/reply/register?bno=<c:out value='${board.bno }'/>"><button
					id="reply" class="btn btn-success">답글 추가</button></a>
		</c:if>
		<c:if test="${board.replyYn == 'y'}">
			<a href="/admin/reply/modify?bno=<c:out value='${board.bno }'/>"><button
					id="modify" class="btn btn-success">답글 수정</button></a>
		</c:if>
		<a href="/admin/board/remove?bno=<c:out value='${board.bno }'/>">
			<button id="modify" class="btn btn-danger">글 삭제</button>
		</a> <a href="/admin/board/list"><button class="btn btn-primary">목록</button></a>
	</div>

</div>

<%@include file="includes/footer.jsp"%>