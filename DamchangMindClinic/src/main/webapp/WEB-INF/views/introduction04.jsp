<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="includes/header.jsp"%>
<link href="resources/css/introduction.css" rel="stylesheet" type="text/css" />
<div id="wrapper">
<div id="subtitle">
병원 둘러보기
</div> 
<div id="content-wrapper">
<img alt="인삿말" src="resources/img/greetings.png">
<div id="section01">
	<div id="gallery-wrapper" class="owl-carousel owl-theme">
		<div id="gallery1" class="item">
			<img src="resources/img/gallery1.png" />
		</div>
		<div id="gallery2" class="item">
			<img src="resources/img/gallery2.png" />
		</div>
		<div id="gallery3" class="item">
			<img src="resources/img/gallery3.png" />
		</div>
	</div>
</div>
<div id="section02">
	<div id="gallery-wrapper-min" class="owl-carousel owl-theme">
		<div id="gallery1-min" class="item">
			<img src="resources/img/gallery1.png" />
		</div>
		<div id="gallery2-min" class="item">
			<img src="resources/img/gallery2.png" />
		</div>
		<div id="gallery3-min" class="item">
			<img src="resources/img/gallery3.png" />
		</div>
	</div>
</div>
</div>

</div>
<script>
	$('#gallery-wrapper').owlCarousel({
		items : 1,
		loop : true,
		margin : 10,
		autoplay : true,
		autoplayTimeout : 3000,
		autoplayHoverPause : true
	});
	$('#gallery-wrapper-min').owlCarousel({
		items : 5,
		loop : true,
		margin : 10,
		autoplay : true,
		autoplayTimeout : 3000,
		autoplayHoverPause : true
	});
</script>
<%@include file="includes/footer.jsp"%>