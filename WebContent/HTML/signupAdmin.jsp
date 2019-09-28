<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/javascript/js2.js"></script>
<meta charset="windows-1256">
<title>Signup Page</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.css">
<link href=${pageContext.request.contextPath}/css/s2.css
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/all.css">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!--Custom styles-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body style="background: linear-gradient(to bottom, #0b97ea, #f1f1f1);">
	<div class="container register"
		style="background: linear-gradient(to bottom, #0b97ea, #f1f1f1);">
		<div class="row">
			<div class="col-md-3 register-left">
				<img src="https://image.ibb.co/n7oTvU/logo_white.png" alt="" />
				<h3>Welcome</h3>
				<p>Login if you have acoount</p>
				<a href="login.jsp" class="btn btn-login float-left"
					style="background: #0f5bce; margin-top: 11px; color: white">Login</a><br />
				<!-- ToDo  -->
			</div>
			<div class="col-md-9 register-right">


				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="home" role="tabpanel"
						aria-labelledby="home-tab">
						<h3 class="register-heading" style="color: blue">Sign UP</h3>
						<div class="row register-form">
							<div class="col-md-6">
								<form name="form2" method="post"
									action="<%=request.getContextPath()%>/register"
									onsubmit="return validate()">

									<div class="form-group">
										<div class="input-group form-group">
											<div class="input-group-prepend">
												<span class="input-group-text">First Name</span>
											</div>
											<input type="text" name="FName" class="form-control"
												placeholder="first name"> <label id="fname"></label>

										</div>
										<div class="input-group form-group">
											<div class="input-group-prepend">
												<span class="input-group-text">Last Name</span>
											</div>
											<input type="text" name="LName" class="form-control"
												placeholder="last name"> <label id="lname"></label>
										</div>

										<div class="input-group form-group">
											<div class="input-group-prepend">
												<span class="input-group-text">User Name</span>
											</div>
											<input type="text" name="username" class="form-control"
												placeholder="username"> <label id="username"></label>
										</div>
										<div class="input-group form-group">
											<div class="input-group-prepend">
												<span class="input-group-text">Password</span>
											</div>
											<input type="password" name="password" class="form-control"
												placeholder="Password"> <label id="password"></label>
										</div>
										<div class="input-group form-group">
											<div class="input-group-prepend">
												<span class="input-group-text">UserType</span>
											</div>
											<select class="form-control" name="isAdminSelect">
												<option value="std">Student</option>
												<option value="admin">Admin</option>
											</select>
										</div>
										<div class="form-group">
											<input type="submit" value="Sign up"
												class="btn btn-login float-right"
												style="background: #0f5bce; margin-top: 11px; color: white">
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>