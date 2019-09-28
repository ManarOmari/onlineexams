<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Exam Operation</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/all.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
	<form action="<%=request.getContextPath()%>/NameOfInst" method="post">
		<input type="hidden" name="subjectid"
			value=<%=request.getParameter("subjectid")%>><br> <input
			type="hidden" name="doctor_id"
			value=<%=request.getParameter("doctor_id")%>><br>
		<div class="row">
			<div class="col-md-6">
				<table class="table table-striped table-responsive-md btn-table">
					<tr>
						<td><label class="inslabel">start date</label></td>
						<td><input type="datetime-local" name="start" /></td>
					</tr>
					<tr>
						<td><label class="inslabel">end date </label></td>
						<td><input type="datetime-local" name="end" /></td>
					</tr>
					<tr>
						<td><label class="inslabel">Number of question </label></td>
						<td><input type="text" name="QNo"></td>
					</tr>
					<tr>
						<td><label class="inslabel">Total mark </label></td>
						<td><input type="text" name="mark"></td>
					</tr>
					<tr>
						<td colspan="2"><input class="btn btn-primary" type="submit"
							value="submit"></td>
					</tr>
				</table>
			</div>
			<div class="col-md-6"></div>
		</div>
	</form>
	
</body>
</html>