<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<title>Upload Exam File</title>
<meta charset="windows-1256">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/all.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-2">
			<img src="${pageContext.request.contextPath}/imgs/folder_blue.ico">
			</div>

			<div class="col-md-6">
				<form action="<%=request.getContextPath()%>/uploadFileExam"
					method="post">

					<input type="hidden" name="subjectid" value="${subjectid}"> <input
						type="hidden" name="doctor_id" value="${doctor_id}"> <input
						type="hidden" name="startDate" value="${start}"> <input
						type="hidden" name="endDate" value="${end}"> <input
						type="hidden" name="numberOfQ" value="${NoQ}"> <input
						type="hidden" name="mark" value="${markk}">


					<table class="table-responsive-xl">
						<tr>
							<td><label class="inslabel" style="color: black;">Upload
									File of Exam</label></td>
							<td><input type="file" id="fileToUpload"
								onchange="return openFile()" class="btn btn-outline-info" style="font-weight: 500;color: #131415;border-color: #49afb5"></td>
						</tr>
						<tr>
							<td><input type="hidden" id="inputTextToSave" name="readf"></td>
						</tr>
						<tr>
							<td><input type="submit" value="Upload" name="uploadBtn"
								class="btn btn-primary"></td>
						</tr>
					</table>
			
			</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function openFile() {
			var output = document.getElementById("fileToUpload").files[0];

			var Reader = new FileReader();
			Reader.onload = function(event) {
				var input = event.target.result;
				document.getElementById("inputTextToSave").value = input; // String
			};

			Reader.readAsText(output, "UTF-8");
		}
	</script>
</body>
</html>