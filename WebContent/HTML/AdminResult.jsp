<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Admin Result</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/all.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/styles.css">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
h1,h4{font-weight:500;color:blue}
</style>
</head>
<body style="background: linear-gradient(to bottom, #f1f1f1, #0b97ea);">

  <div class="w3-bar ">
   <a href="HTML/login.jsp" class="w3-bar-item w3-button w3-blue w3-right">Logout</a>
 
  </div>
  
 <div class="row">

 <div class="col-md-2">
 <img src="${pageContext.request.contextPath}/imgs/nike_blue.ico">
 </div>
  <div class="col-md-10">
  <table class="table table-hover">
<tr><td><h1>Success uplaod  Exam File</h1></td></tr>
<tr><td><h4>User Name :</h4></td><td><h4> ${username}</h4></td></tr>
<tr><td><h4>User ID :</h4></td><td><h4> ${userID}</h4></td></tr>
<tr><td><h4>Subject ID : </h4></td><td><h4>${subjectId}</h4></td></tr>
<tr><td><h4>Number of Questions :</h4></td><td><h4> ${qNo}</h4></td></tr>
<tr><td><h4>Start Time :</h4></td><td><h4>${start}</h4></td></tr>
<tr><td><h4>End Time :</h4></td><td><h4>${end}</h4></td></tr>
<tr><td><h4>Total Mark : </h4></td><td><h4>${mark}</h4></td></tr>
</table>
</div>
</div>
</body>
</html>