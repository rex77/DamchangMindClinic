<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<meta charset="utf-8">
<head>
<title>담창 정신건강의학과</title>
<!-- CSSs -->
<link href="/resources/css/normalize.css" rel="stylesheet"
	type="text/css" />
<link href="/resources/css/admin_navbar.css" rel="stylesheet" type="text/css" />
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
				<li><a class="logo" href=""><img
						src="/resources/img/logo_white.png" alt="로고"></a></li>
				<li class="nav-item"><a href="#" onclick="document.getElementById('logout-form').submit();">로그아웃</a>
					</li>
					<form id="logout-form" action="/logout" method="POST">
   <input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}"/>
</form>
					
				<li class="nav-item"><a href="/admin/notice">공지사항</a>
					</li>
				<li class="nav-item"><a href="/admin/board">질문게시판</a>
					</li>
		</nav>
	</div>
