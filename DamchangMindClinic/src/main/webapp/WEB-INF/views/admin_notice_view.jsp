<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="includes/admin_header.jsp"%>
<link href="/resources/css/notice_view.css" rel="stylesheet"
	type="text/css" />

<div id="wrapper">
	<div id="subtitle">공지사항</div>
	<div id="content-wrapper">
		<div id="title">
			<div class="title01">
				<c:out value="${board.title}" />
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

		<div id="btns">
			<a href="/admin/notice/modify?bno=<c:out value='${board.bno }'/>">
				<button id="modify" class="btn btn-success">글 수정</button>
			</a> <a href="/admin/notice/remove?bno=<c:out value='${board.bno }'/>">
				<button id="remove" class="btn btn-danger">글 삭제</button>
			</a> <a href="/admin/notice/list"><button id="tolist"
					class="btn btn-primary">목록</button></a>
		</div>
	</div>
</div>

<%@include file="includes/footer.jsp"%>