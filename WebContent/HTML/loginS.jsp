<%@page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@page import="java.sql.* , java.io.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Student Landing Page</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/all.css">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/styles.css">
<style>
.w3-bar {
	position: absolute;
	float: right;
	right: 0;
}
</style>
</head>
<body>
	<%
		int UserId = 0;
		try {
			UserId = Integer.parseInt(session.getAttribute("idLog").toString());
		} catch (Exception e) {
			response.sendRedirect("login.jsp");
		}
	%>
	<div class="w3-bar">
		<a class="btn btn-secondary" href="login.jsp"
			class="w3-bar-item w3-button w3-blue w3-right">Logout</a>
	</div>
	<div class="col-md-2">
		<img src="../imgs/std4.png" style="height: 30%; width: 80%">
	</div>
	<table class="table table-striped table-responsive-md btn-table">
		<tr>
			<th>Exam ID</th>
			<th>Subject Name</th>
			<th>Doctor</th>
			<th>Start Date</th>
			<th>End Date</th>
			<th>Result</th>
			<th>Action</th>
		</tr>
		<%
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam", "onlineexams",
						"onlineexams");

				PreparedStatement ps = con.prepareStatement(
						" SELECT ea.ExamID, s.subName, d.doctorName, e.start, e.end, ea.flag , ea.answers, e.NoOfQuestion, e.totalMark FROM exam_applied ea "
								+ " INNER JOIN exams e ON (ea.ExamID=e.idexams) "
								+ " INNER JOIN subject s ON (s.idsubject=e.SubId) "
								+ " INNER JOIN doctors d ON (d.iddoctors=e.doctor_id) WHERE ea.userID=?");

				ps.setInt(1, UserId);

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					int ExamID = Integer.parseInt(rs.getString("ExamID"));
					String Subject = rs.getString("subName");
					String Doctor = rs.getString("doctorName");
					String Start = rs.getString("start");
					String End = rs.getString("end");
					String Status = "";
					String HTML = "";
					String AnswersStr = "";
					int Flag = Integer.parseInt(rs.getString("flag"));
					if (Flag == 1) {
						Status = "";
						HTML = "<a href=\"" + request.getContextPath() + "/HTML/startexam.jsp?examid=" + ExamID
								+ "\" class=\"btn btn-primary\">Start Exam</a>";
					} else {

						HTML = "<label style=\"color:red\">Already Taken</label>";
						int NoQuestions = Integer.parseInt(rs.getString("NoOfQuestion"));
						Double totalMark = Double.valueOf(rs.getString("totalMark"));
						int Correct = 0;
						AnswersStr = rs.getString("answers");

						if (!AnswersStr.equals("") && !AnswersStr.equals("null")) {

							String[] q_w_m = AnswersStr.split("-");
							int[] Questions = new int[q_w_m.length];
							int[] Answers = new int[q_w_m.length];

							for (int i = 0; i < Questions.length; i++) {
								Questions[i] = 0;
							}

							int QuestionID = 0;
							int AnswerID = 0;
							int Counter = 0;
							int CorreectAnswers = 0;

							for (int i = 0; i < q_w_m.length; i++) {

								String[] marks = (q_w_m[i]).split(",");

								if (marks.length == 2) {
									QuestionID = Integer.parseInt(marks[0].toString());
									AnswerID = Integer.parseInt(marks[1].toString());

									int addtoarray = 1;
									for (int j = 0; j <= i; j++) {
										if (Questions[j] == QuestionID) {
											addtoarray = 0;
										}
									}

									if (addtoarray == 1) {
										Questions[Counter] = QuestionID;
										Answers[Counter] = AnswerID;
										Counter++;
									}
								}
							}

							for (int i = 0; i < Questions.length; i++) {
								PreparedStatement QAps = con.prepareStatement(
										"SELECT idanswers FROM answers WHERE questionID=? AND ISCorrect = 1 ORDER BY idanswers ASC LIMIT 1");
								QAps.setInt(1, Questions[i]);

								ResultSet QArs = QAps.executeQuery();

								String test = "SELECT idanswers FROM answers WHERE questionID=" + Questions[i]
										+ " AND ISCorrect = 1 ORDER BY idanswers ASC LIMIT 1";
								int testA = Answers[i];
								while (QArs.next()) {

									if (QArs.getInt("idanswers") == Answers[i]) {
										CorreectAnswers++;
									}
								}

							}

							Status = ((double) CorreectAnswers / NoQuestions * totalMark) + " out of " + totalMark;
						}
					}
		%>
		<tr>
			<td><label style="color: blue"><%=ExamID%></label></td>
			<td><label style="color: blue"><%=Subject%></label></td>
			<td><label style="color: blue"><%=Doctor%></label></td>
			<td><label style="color: blue"><%=Start%></label></td>
			<td><label style="color: blue"><%=End%></label></td>
			<td><label style="color: blue"><%=Status%></label></td>
			<td><label style="color: blue"><%=HTML%></label></td>
		</tr>
		<%
			}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		%>

	</table>
</body>
</html>