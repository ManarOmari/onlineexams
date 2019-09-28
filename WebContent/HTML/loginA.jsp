<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@page import="java.sql.* , java.io.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Admin Dash board</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/javascript/js1.js"></script>
	<link rel="stylesheet"	href="${pageContext.request.contextPath}/css/bootstrap.css">
<link rel="stylesheet"	href="${pageContext.request.contextPath}/css/all.css">

<!--Custom styles-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>


<div class="row">
<div class="col-md-3"></div>
<div class="col-md-6">
<form method="post" action="<%=request.getContextPath()%>/testServlet">

<%try{%>
<%  Class.forName("com.mysql.jdbc.Driver"); %>
<% Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam", "onlineexams", "onlineexams");%>
<% PreparedStatement ps=con.prepareStatement("select * from subject" );%>
<%  ResultSet rs=ps.executeQuery();  %>
<h1 style="margin-top: 73px;
    padding-left: 30px;
    padding-bottom: 20px;">Select Subject Name</h1>

<select name="subjectid" class="custom-select">
<% while(rs.next()){ %>
 <option value=<%=rs.getInt("idsubject")%>> <%=rs.getInt("idsubject")%>  -  <%=rs.getString("subName")%>
</option>
<%} }catch (Exception e2){e2.printStackTrace();}%>
</select>

<input type="submit"  class="btn btn-login float-center" style="background: #0f5bce;
                                      margin-top: 11px;color:white;" >
</form>

</div>
<div class="col-md-4"></div>
</div>

</body>
</html>