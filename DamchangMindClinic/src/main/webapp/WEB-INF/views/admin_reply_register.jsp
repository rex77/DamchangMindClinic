<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<sec:authorize access="isAuthenticated()" />
<%@include file="includes/admin_header.jsp"%>
<link href="/resources/css/sb-admin-2.css" rel="stylesheet"
	type="text/css" />
<link href="/resources/css/board_register.css" rel="stylesheet"
	type="text/css" />

<!-- 권한설정 -->
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page import="org.springframework.security.core.Authentication"%>
<%@ page import="com.dcmc.domain.UserDTO"%>
<%
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();

Object principal = auth.getPrincipal();
String name = "";
String nickname = "";
if (principal != null && principal instanceof UserDTO) {
	name = ((UserDTO) principal).getUsername();
	nickname = ((UserDTO) principal).getNickname();
} else {
	name = "anonymousUser";
}
%>

<div id="wrapper">
	<div id="subtitle">질문게시판 관리자페이지</div>
	<div id="content-wrapper">
		<div id="content">
			<!-- 게시글 리스트 -->
			<div class="container">
				<div class="write-box">
					<div class="write-form">
						<form id="form1" action="/admin/reply/register" method="post">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
							<ul class="write-list">
								<li class="write-nickname">
									<div class="write-nick">
										<input type="text" class="nick" name="nick"
											placeholder="닉네임" value="<%=nickname%>" />
									</div>
								</li>
								<li>
									<div class="content">
										<textarea name="content" placeholder="내용" class="write-memo"><c:choose><c:when test="${board.replyYn == 'n' }">원문 : <c:out value='${board.content}' /></c:when><c:otherwise><c:out value='${reply.content}' /></c:otherwise></c:choose></textarea>
									</div>
								</li>
							</ul>
							<div>
								<div style="width: 100%">
									<div class="okbtn">
										<a href="" class="write-btn"><input type="submit"
											value="확인" id="ok" class="write-ok-btn"></a>
									</div>
								</div>
								<input type="hidden" name="bno"
									value="<c:out value='${board.bno}'/>" /> 
									<input type="hidden"
									name="rno" value="<c:if test='${reply.rno == null}'>0</c:if><c:out value='${reply.rno}'/>" />
									<input type="hidden" name="writer"
									value="<c:out value='<%=name %>'/>" />
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>
<script>
		let rno = <c:out value="${reply.rno}"/>;
		if (rno != "")
			$("#form1").attr("action", "/admin/reply/modify");
		$("#form1").attr("method", "post");
</script>
<%@include file="includes/footer.jsp"%>