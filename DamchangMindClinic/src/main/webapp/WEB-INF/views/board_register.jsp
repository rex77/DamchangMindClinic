<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="includes/header.jsp"%>
<link href="/resources/css/sb-admin-2.css" rel="stylesheet"
	type="text/css" />
<link href="/resources/css/board_register.css" rel="stylesheet"
	type="text/css" />

<div id="wrapper">
	<div id="subtitle">질문게시판</div>
	<div id="content-wrapper">
		<div id="content">
			<!-- 게시글 리스트 -->
			<div class="container">
				<div class="write-box">
					<div class="write-form">
						<form id="form1" action="/board/register" method="post">
							<ul class="write-list">
								<li class="write-nickname">
									<div class="write-nick">
										<input type="text" class="nick" name="writer"
											placeholder="닉네임" value="<c:out value='${board.writer}'/>"> <label for="" class="check-secret">비밀글</label>
										<input type="checkbox" class="write-secret" id="secret"
											name="secretYn" value="y">
									</div>
								</li>
								<li>
									<div class="write-subject">
										<input type="text" class="subject" name="title"
											placeholder="제목" value="<c:out value='${board.title}'/>">
									</div>
								</li>
								<li>
									<div class="content">
										<textarea name="content" placeholder="내용" class="write-memo" value="<c:out value='${board.content}'/>"></textarea>
									</div>
								</li>
								<li>
									<div class="write-subject">
										<input type="password" class="subject" name="password"
											placeholder="비밀번호" value="<c:out value='${board.password}'/>">
									</div>
								</li>
							</ul>
							<div>
								<div style="width: 100%">
									<div class="okbtn">
										<a href="Community_Board.html" class="write-btn"><input
											type="submit" value="확인" id="ok" class="write-ok-btn"></a>
									</div>
								</div>
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>
<script>
	
	$("#ok").on("click",function() {
			if($('#form1 [name="password"]').val() == "") {
			alert("비밀번호는 필수입력사항입니다.");
			return false;
		}
		else {
			$('#form1').submit();
		}
	});
	

</script>
<%@include file="includes/footer.jsp"%>