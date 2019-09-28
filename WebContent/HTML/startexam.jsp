<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@page import="java.sql.* , java.io.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Start Exam</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/all.css">
	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
	<%
		int size = 0;
		String Name = "";
		String ExamID = "";
		String ID = "";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con;
		try {
			ExamID = (String) request.getParameter("examid");
			if (ExamID != null && (Integer.parseInt(ExamID) > 0)) {
				ID = (String) (session.getAttribute("idLog"));
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam", "onlineexams",
						"onlineexams");
				PreparedStatement ps = con.prepareStatement(
						"select e.*,s.* from exams e INNER JOIN subject s ON(e.SubId=s.idsubject) INNER JOIN exam_applied ea ON(e.idexams=ea.ExamID) WHERE ea.flag=1  AND userID=? AND idexams=?");
				ps.setInt(1, Integer.parseInt(ID));
				ps.setInt(2, Integer.parseInt(ExamID));
				ResultSet resultSet = ps.executeQuery();

				try {
					resultSet.last();
					size = resultSet.getRow();
					resultSet.beforeFirst();
				} catch (Exception ex) {
					size = 0;
				}

				if (size <= 0) {
	%><h1>No Exam with this ID</h1>
	<%
		} else {
	%><h1>
		EXAM Details as follows:
		</h1>
			<form method="post"
				action="<%=request.getContextPath()%>/StdShowExams">
				<input type="hidden"
					value=<%=(String) request.getParameter("examid")%> name="eID">
				<table class="table table-striped table-responsive-md btn-table">
					<%
						while (resultSet.next()) {
					%>
					<tr>
						<td>Name: </td>
						<td><%= resultSet.getString("subName").toString() %></td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>Start: </td>
						<td><%= resultSet.getString("start").toString() %></td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>Ends: </td>
						<td><%=resultSet.getString("end").toString()%></td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>No of Questions:</td>
						<td><%=resultSet.getString("NoOfQuestion").toString()%></td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>Total Mark:</td>
						<td><%=resultSet.getString("totalMark").toString()%></td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" class="btn btn-primary" value="Start Exam" /></td>
						<td>&nbsp;</td>
					</tr>
					<%
						}
					%>
				</table>
			</form>
			<%
				}

					}
				} catch (Exception e) {
					throw e;
				}
			%>
		
</body>
</html>