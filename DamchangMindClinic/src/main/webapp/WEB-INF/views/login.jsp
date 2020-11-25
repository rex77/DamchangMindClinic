<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="includes/admin_header.jsp"%>
<link href="resources/css/login.css" rel="stylesheet" type="text/css" />
<div id="wrapper">
	<div id="content-wrapper">

		<div class="container">
			<div class="row">
				<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
					<div class="card card-signin my-5">
						<div class="card-body">
							<h5 class="card-title text-center">Sign In</h5>
							<form class="form-signin" action="/login" method="post">
								<div class="form-label-group">
									<input type="text" name="username" id="inputEmail"
										class="form-control" placeholder="Email address" required
										autofocus> <label for="inputEmail">Id</label>
								</div>

								<div class="form-label-group">
									<input type="password" name="password" id="inputPassword"
										class="form-control" placeholder="Password" required>
									<label for="inputPassword">Password</label>
								</div>

								<div class="custom-control custom-checkbox mb-3">
									<input type="checkbox" name="autoLogin" class="custom-control-input"
										id="customCheck1"> <label class="custom-control-label"
										for="customCheck1">자동 로그인</label>
								</div>
								<div class="error">
								<c:out value="${error}"/>
								<c:out value="${logout }"/>
								</div>
								<input class="btn btn-lg btn-danger btn-block text-uppercase"
									type="submit" value="sign in">
								</button>
								<hr class="my-4">
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>


	</div>

</div>
<%@include file="includes/footer.jsp"%>