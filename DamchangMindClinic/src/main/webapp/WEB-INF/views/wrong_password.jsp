<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="includes/header.jsp"%>
<link href="/resources/css/password_view.css" rel="stylesheet"
	type="text/css" />

<div id="wrapper">
	<div id="subtitle">질문게시판</div>
	<div id="content-wrapper">
		<div id="title">비밀글로 설정된 게시글입니다</div>
		<div id="content">
			<h2>잘못된 비밀번호입니다!</h2>
			<a href="/board/list"><button class="btn btn-primary">뒤로가기</button></a>
		</div>
	</div>
</div>

<%@include file="includes/footer.jsp"%>