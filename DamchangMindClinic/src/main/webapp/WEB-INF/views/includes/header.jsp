<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<meta charset="utf-8">
<head>
<title>담창 정신건강의학과</title>
<!-- CSSs -->
<link href="/resources/css/normalize.css" rel="stylesheet"
	type="text/css" />
<link href="/resources/css/navbar.css" rel="stylesheet" type="text/css" />
<link href="/resources/css/footer.css" rel="stylesheet" type="text/css" />

<!--bootstrap css-->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<!-- owl carousel -->
<link href="resources/css/owl.carousel.min.css" rel="stylesheet"
	type="text/css" />
<link href="resources/css/owl.theme.default.min.css" rel="stylesheet"
	type="text/css" />

<!-- slick carousel -->
<link rel="stylesheet" type="text/css"
	href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />


<!-- JSs -->
<!--jquery.js / bootstrap.js-->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"
	crossorigin="anonymous"></script>
<!-- owl carousel -->
<script src="resources/js/owl.carousel.min.js" crossorigin="anonymous"></script>

<!-- slick carousel -->
<script type="text/javascript"
	src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
</head>

<body>
	<div id="header">
		<nav id="navbar" class="navbar navbar-expand fixed-top">
			<ul class="navbar-nav depth01">
				<li><a class="logo" href="/"><img
						src="/resources/img/logo_white.png" alt="로고"></a></li>
				<li class="nav-item"><a href="/greetings">담창정신건강의학과소개</a>
					<ul class="depth02">
						<li><a href="/greetings">인삿말</a></li>
						<li><a href="/team">의료진 소개</a></li>
						<li><a href="/map">오시는 길</a></li>
						<li><a href="/gallery">병원 둘러보기</a></li>
					</ul></li>
				<li class="nav-item"><a href="/anxiety">성인정신건강클리닉</a>
					<ul class="depth02">
						<li><a href="/anxiety">불안장애</a></li>
						<li><a href="/panic">공황장애</a></li>
						<li><a href="/schizophrenia">조현병</a></li>
						<li><a href="/dementia">치매</a></li>
						<li><a href="/insomnia">불면증</a></li>
					</ul></li>
				<li class="nav-item"><a href="/adhd">아동정신건강클리닉</a>
					<ul class="depth02">
						<li><a href="/adhd">ADHD</a></li>
						<li><a href="/asperger">아스퍼거 증후군</a></li>
					</ul></li>
				<li class="nav-item"><a href="/notice/list">담창정신건강의학과소식</a>
					<ul class="depth02">
						<li><a href="/notice/list">공지사항</a></li>
						<li><a href="#">QnA</a></li>
						<li><a href="/board/list">질문게시판</a></li>
					</ul></li>
		</nav>
	</div>

	<script>
		$('.depth01 > li').hover(function() {
			if (!$(".depth02").is(":animated")) {
				$('.depth02').slideDown(350);
			}
		}, function() {
			$('.depth02').slideUp(300);
		});
	</script>