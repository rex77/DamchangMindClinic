<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="includes/header.jsp"%>
<link href="/resources/css/board_view.css" rel="stylesheet"
	type="text/css" />

<div id="wrapper">
	<div id="subtitle">질문게시판</div>
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
	</div>


	<c:if test="${board.replyYn == 'n'}">
		<button id="modify" class="btn btn-success" data-toggle="modal"
			data-target="#modifyModal">수정</button>
	</c:if>
	<button id="modify" class="btn btn-danger" data-toggle="modal"
		data-target="#deleteModal">삭제</button>
	<a href="/board/list"><button id="tolist" class="btn btn-primary">목록</button></a>
</div>

<!-- 수정 Modal -->
<div class="modal fade" id="modifyModal" tabindex="-1" role="dialog"
	aria-labelledby="modifyModalLabel" aria-hidden="true">

	<form action="/board/modify" method="post">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<span class="span-info">수정하려면 비밀번호를 입력하세요 </span><br>
					<input type="text" id="password" name="password"/>
					<input type="hidden" id="bno1" name="bno"/>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				</div>
				<div class="modal-footer">
					<input type="submit" value="확인" class="btn btn-success"/>
				</div>
			</div>
		</div>

	</form>
</div>

<!-- 삭제 Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">

	<form action="/board/remove" method="post">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<span class="span-info">삭제하려면 비밀번호를 입력하세요</span><br>
					<input type="text" id="password" name="password"/>
					<input type="hidden" id="bno2" name="bno"/>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				</div>
				<div class="modal-footer">
					<input type="submit" value="확인" class="btn btn-danger"/>
				</div>
			</div>
		</div>

	</form>
</div>

<script>
$(document).ready(function() {
$('#bno1').val(${board.bno});
$('#bno2').val(${board.bno});
})


</script>
<%@include file="includes/footer.jsp"%>