<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Question ${questionName}</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/all.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body style="font-weight: 500">
<% int UserId=0;
	try{
		UserId = Integer.parseInt(session.getAttribute("idLog").toString());
	}catch(Exception e){
		response.sendRedirect("login.jsp");
	}%>
	<label>${answersStr}</label>
	<form method="post" action="<%=request.getContextPath()%>/StdShowExams">
		<input type="hidden" value="${examId}" name="eID" /> <input
			type="hidden" value="${questions}" name="questions" /> <input
			type="hidden" value="${qidx}" name="qidx" /> <input type="hidden"
			value="${question_id}" name="qid" />
		<table class="table table-striped table-responsive-md btn-table">
			<tr>
				<th>Question: ${quesion_id}<input type="hidden" name="question"
					value="${quesion_id}" /></th>
				<th>${question_body}</th>
			</tr>
			<tr>
				<td>Your Answer is :</td>
				<td><c:forEach items="${answers}" var="answer">
						<div class="answers">
							<span class="question-answer"> <% //${answer[0]} %><input
								required type="radio" name="myanswer" value="${answer[0]}" />
							</span> <span class="question-answer-body">${answer[1]}</span>
						</div>
					</c:forEach></td>
			</tr>
			<tr>
				<td>${bprev}</td>
				<td>${bnext}</td>
			</tr>
		</table>
	</form>
</body>
</html>