<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Exam Result</title>
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
<body>
<% int UserId=0;
	try{
		UserId = Integer.parseInt(session.getAttribute("idLog").toString());
	}catch(Exception e){
		response.sendRedirect("login.jsp");
	}%>
<div class="w3-bar ">
   <a href="HTML/login.jsp" class="w3-bar-item w3-button w3-blue w3-right">Logout</a>
  </div>
  <div class="row">
 <div class="col-md-2">
 <img src="${pageContext.request.contextPath}/imgs/res.png" style="width:77%;height:99px">
 </div>
  <div class="col-md-12">
  <table class="table table-hover">
<tr><td><H1>You finish the exam </H6></td></tr>


</table>
</div>
<form method="post" action="<%=request.getContextPath()%>/appliedExam">
<input type="hidden" value="${mark}" name="mark">
<input type="hidden" value="${TotalMark}" name="TotalMark">
<input type="hidden" value="${examId}" name="examId">
<input type="hidden" value="<%=session.getAttribute("idLog") %>" name="">
<input type="submit" class="btn btn-primary" value="Confirm">
</form>
</div>
</body>
</html>