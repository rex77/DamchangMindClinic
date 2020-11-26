<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="includes/header.jsp"%>
<link href="/resources/css/board.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<div id="wrapper">
	<div id="subtitle">질문게시판</div>
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
					<td><a href="<c:out value='/board/view?bno=${board.bno}' />"><c:out
								value="${board.title}" />
								<c:if test="${board.replyYn == 'y'}">&nbsp<i class="fa fa-comment"/></c:if>
								<c:if test="${board.secretYn == 'y'}">&nbsp<i class="fa fa-lock"/></c:if>
								</a></td>
					<td><c:out value="${board.writer}" /></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd"
							value="${board.registerDate}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div id="btns"><a href="/board/register"><button class="btn btn-primary">작성</button></a></div>
	<div class="pagination-center">
		<ul class="pagination">
			<c:if test="${pageMaker.prev }">
				<li class="page-link previous"><a
					href="${pageMaker.startPage - 1 }"> Previous </a></li>
			</c:if>
			<c:forEach var="num" begin="${pageMaker.startPage }"
				end="${pageMaker.endPage }">
				<li class="page-item ${pageMaker.cri.pageNum == num ? 'active':'' }"><a
					class="page-link" href="${num}">${num}</a></li>
			</c:forEach>
			<c:if test="${pageMaker.next }">
				<li class="page-link next"><a href="${pageMaker.endPage + 1 }">
						Next </a></li>
			</c:if>
		</ul>

	</div>

	<!--  가짜 폼 -->

	<form id="actionForm" action="/board/list" method="get">
		<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }" />
		<input type="hidden" name="amount" value="${pageMaker.cri.amount }" />
	</form>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		$(".page-item a").on("click", function(e) {
			e.preventDefault();
			console.log('click');
			$('#actionForm').find("input[name='pageNum']").val($(this).attr("href"));
			$('#actionForm').submit();
		});

		$(".page-link a").on("click", function(e) {
			e.preventDefault();
			console.log('click');
			$('#actionForm').find("input[name='pageNum']").val($(this).attr("href"));
			$('#actionForm').submit();
		});

	});
</script>

<%@include file="includes/footer.jsp"%>