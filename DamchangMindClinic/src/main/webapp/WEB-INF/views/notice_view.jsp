<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="includes/header.jsp"%>
<link href="/resources/css/notice_view.css" rel="stylesheet" type="text/css" />
<script async charset="utf-8" src="//cdn.embedly.com/widgets/platform.js"></script>
<div id="wrapper">
	<div id="subtitle">공지사항</div>
	<div id="content-wrapper">
		<div id="title">
		<div class="title01"><c:out value="${board.title}" /></div>
		<div class="title02"><c:out value="${board.writer}" /></div>
		<div class="title03"><fmt:formatDate pattern="yyyy-MM-dd" value="${board.registerDate}" /></div>
		</div>
		<div id="content"><c:out value="${board.content}" escapeXml="false" /></div>
		<a href="/notice/list"><button id="tolist" class="btn btn-primary">목록</button></a>
	</div>
</div>
<script>
document.querySelectorAll( 'oembed[url]' ).forEach( element => {
    // Create the <a href="..." class="embedly-card"></a> element that Embedly uses
    // to discover the media.
    const anchor = document.createElement( 'a' );

    anchor.setAttribute( 'href', element.getAttribute( 'url' ) );
    anchor.className = 'embedly-card';

    element.appendChild( anchor );
} );

</script>
<%@include file="includes/footer.jsp"%>