<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/javascript/js1.js"></script>

<meta charset="windows-1256">
<title>Login Page</title>
<link
	href=${pageContext.request.contextPath}/css/style1.css
	rel="stylesheet" >
	<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<!--Custom styles-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
	<section class="login-block">
		<div class="container">
			<div class="row">
				<div class="col-md-4 login-sec">
					<h2 class="text-center">Login Now</h2>
					<form name="form1" action="<%=request.getContextPath()%>/login"
						method="post" onsubmit="return ValidateForm()" class="login-form">
						<div class="form-group">
							<label for="exampleInputEmail1" class="text-uppercase">UserName</label>
							<input type="text" name="username" class="form-control"
								placeholder="username">

						</div>
						<div class="form-group">
							<label for="exampleInputPassword1" class="text-uppercase">Password</label>

							<input type="password" class="form-control"
								placeholder="password" name="password" />

						</div>

						<div class="form-check">
							<label class="form-check-label"> <input type="checkbox"
								class="form-check-input"> <small>Remember Me</small>
							</label>
							<button type="submit" class="btn btn-login float-right" style="background: #0f5bce;
                                      margin-top: 11px;color:white;">Login
							</button>
						</div>
						<div class="card-footer">
						<div class="d-flex justify-content-center links">
							<p>Don't have an account?<a href="/OnlineExam/HTML/signupAdmin.jsp">Sign
								Up</a></p>
						</div>
						</div>
					</form>

				</div>

				<div class="col-md-8 banner-sec">
					
						
						<div id="carouselExampleIndicators" class="carousel slide"
							data-ride="carousel">
							<ol class="carousel-indicators">
								<li data-target="#carouselExampleIndicators" data-slide-to="0"
									class="active"></li>
								<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
								<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
							</ol>
							<div class="carousel-inner" role="listbox">
								<div class="carousel-item active">
									<img class="d-block img-fluid"
										src="https://static.pexels.com/photos/33972/pexels-photo.jpg"
										alt="First slide">
								
								</div>
								<div class="carousel-item">
									<img class="d-block img-fluid"
										src="https://images.pexels.com/photos/7097/people-coffee-tea-meeting.jpg"
										alt="First slide">
									
								</div>
							</div>
						</div>
					</div>


				</div>
	</div>
	</section>

</body>
</html>