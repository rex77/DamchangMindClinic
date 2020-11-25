<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="includes/header.jsp"%>
<link href="resources/css/index.css" rel="stylesheet" type="text/css" />

	<div id="section01">
		<div id="hero-wrapper" class="owl-carousel owl-theme">
			<div id="hero1" class="item">
				<img src="resources/img/hero1.png" />
			</div>
			<div id="hero2" class="item">
				<img src="resources/img/hero2.png" />
			</div>
			<div id="hero3" class="item">
				<img src="resources/img/hero3.png" />
			</div>
		</div>
	</div>
<div id="wrapper">
	<div id="section02">
		<ul class="banner4-wrapper">
			<li class="banner4"><a href="/team"><img
					src="resources/img/section02_banner1.png" /></a></li>
			<li class="banner4"><a href="/anxiety"><img
					src="resources/img/section02_banner2.png" /></a></li>
			<li class="banner4"><a href="adhd"><img
					src="resources/img/section02_banner3.png" /></a></li>
			<li class="banner4"><a href="/board/list"><img
					src="resources/img/section02_banner4.png" /></a></li>
		</ul>
	</div>
	<div id="section03">
		<img class="banner-long" src="resources/img/banner_long.png" />
	</div> 
</div>
	<div id="section04">
		<div class="contact-us"><img src="resources/img/contactus.png"/></div>
	</div>
<script>
	$('#hero-wrapper').owlCarousel({
		items : 1,
		loop : true,
		margin : 10,
		autoplay : true,
		autoplayTimeout : 3000,
		autoplayHoverPause : true
	});
</script>
<%@include file="includes/footer.jsp"%>