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
			게시글을 열람하시려면 비밀번호를 입력하세요
			<form id="passwordForm" action="/board/view" method="post">
				<input type="password" name="password" /> <input type="hidden"
					name="bno" value="${bno}" /> <input type="hidden"
					name="${_csrf.parameterName}" value="${_csrf.token}" /> <input
					type="submit" value="확인" />
			</form>

		</div>
	</div>
</div>

<%@include file="includes/footer.jsp"%>