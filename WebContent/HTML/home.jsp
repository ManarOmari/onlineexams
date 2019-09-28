<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
<link rel="" href="${pageContext.request.contextPath}/javascript/jquery-3.2.1.slim.min.js" > 
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
	font-family: "Lato", sans-serif
}

.mySlides {
	display: none
}
</style>
</head>
<body>

	<div class="w3-bar w3-border w3-blue">
		<a
			class="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right"
			href="javascript:void(0)" onclick="myFunction()"
			title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a> <a
			href="#" class="w3-bar-item w3-button w3-padding-large">HOME</a> <a
			href="#course"
			class="w3-bar-item w3-button w3-padding-large w3-hide-small">Course</a>
		<a href="#teachers"
			class="w3-bar-item w3-button w3-padding-large w3-hide-small">Teachers</a>
		<a href="#contact"
			class="w3-bar-item w3-button w3-padding-large w3-hide-small">CONTACT</a>
		<a href="login.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small w3-blue w3-right">Login</a>
		
		<a href="javascript:void(0)"
			class="w3-padding-large w3-hover-red w3-hide-small w3-right"><i
			class="fa fa-search"></i></a>
	</div>


	<!-- Page content -->
	<div class="w3-content" style="max-width: 2000px">

		<!-- Automatic Slideshow Images -->
		<div class="mySlides w3-display-container w3-center">
			<img src="../imgs/e3.jpg" style="width: 100%">
			<div
				class="w3-display-bottommiddle w3-container w3-text-white w3-padding-32 w3-hide-small">

			</div>
		</div>
		<div class="mySlides w3-display-container w3-center">
			<img src="../imgs/e2.jpg" style="width: 100%">
			<div
				class="w3-display-bottommiddle w3-container w3-text-white w3-padding-32 w3-hide-small">

			</div>
		</div>
		<div class="mySlides w3-display-container w3-center">
			<img src="../imgs/91-Rank-01.jpg" style="width: 100%">
			<div
				class="w3-display-bottommiddle w3-container w3-text-white w3-padding-32 w3-hide-small">

			</div>
		</div>

		<!-- The Course Section -->
		<div class="w3-container w3-content w3-center w3-padding-64"
			style="max-width: 800px" id="course">
			<h2 class="w3-wide">Course</h2>
			<p class="w3-opacity">
				<i>We love music</i>
			</p>
			<p class="w3-justify">We have created a fictional band website.
				Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
				eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim
				ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
				aliquip ex ea commodo consequat. Duis aute irure dolor in
				reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
				pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
				culpa qui officia deserunt mollit anim id est laborum consectetur
				adipiscing elit, sed do eiusmod tempor incididunt ut labore et
				dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
				exercitation ullamco laboris nisi ut aliquip ex ea commodo
				consequat.</p>
			<div class="w3-row w3-padding-32">
				<div class="w3-third">
					<p>Science</p>
					<img src="../imgs/science2.jpg" class="w3-round" alt="Random Name"
						style="width: 95%; height: 200px">
				</div>
				<div class="w3-third">
					<p>Math</p>
					<img src="../imgs/math31.jpg" class="w3-round" alt="Random Name"
						style="width: 82%; height: 182px;">
				</div>
				<div class="w3-third">
					<p>Computer</p>
					<img src="../imgs/comp3.jpg" class="w3-round" alt="Random Name"
						style="width: 94%; height: 182px;">
				</div>
			</div>
		</div>


		<!-- The Teacher Section -->
		<div class="w3-bar w3-border w3-blue">
			<div class="w3-container w3-content w3-center w3-padding-64 "
				style="max-width: 800px" id="teachers">
				<h2 class="w3-wide">Teachers</h2>
				<div class="w3-row w3-padding-32">
					<div class="w3-third">

						<img src="../imgs/p1.jpg" class="w3-round" alt="Random Name"
							style="width: width: 76%; height: 166px;">
						<p>Alia</p>
					</div>
					<div class="w3-third">

						<img src="../imgs/p2.jpg" class="w3-round" alt="Random Name"
							style="width: 85%; height: 166px;">
						<p>Ola</p>
					</div>
					<div class="w3-third">

						<img src="../imgs/p3.jpg" class="w3-round" class="w3-round"
							alt="Random Name" style="width: 68%; height: 172px;">
						<p>Ali</p>
					</div>
					<div class="w3-third">
						<img src="../imgs/p4.jpg" class="w3-round" class="w3-round"
							alt="Random Name" style="width: 69%; height: 175px;">
						<p>Kamel</p>
					</div>
					<div class="w3-third">
						<img src="../imgs/p5.jpg" class="w3-round" alt="Random Name"
							style="width: 66%; height: 174px;">
						<p>Ahmad</p>
					</div>
					<div class="w3-third">
						<img src="../imgs/p6.jpg" class="w3-round" alt="Random Name"
							style="width: 69%">
						<p>Leen</p>

					</div>
				</div>
			</div>

		</div>
		<!-- The Contact Section -->
		<div class="w3-container w3-content w3-padding-64 "
			style="max-width: 800px" id="contact">
			<h2 class="w3-wide w3-center">CONTACT</h2>
			<p class="w3-opacity w3-center">
				<i>Fan? Drop a note!</i>
			</p>
			<div class="w3-row w3-padding-32">
				<div class="w3-col m6 w3-large w3-margin-bottom">
					<i class="fa fa-map-marker" style="width: 30px"></i> Amman, Jordan<br>
					<i class="fa fa-phone" style="width: 30px"></i> Phone: <a
						href="callto:0795066104">0795066104</a><br> <i
						class="fa fa-envelope" style="width: 30px"> </i>Email: <a
						href="mailto:manar@onlineexam.com?Subject=Hello%20again"
						target="_top">manar@onlineexam.com</a><br>
				</div>
				<div class="w3-col m6">
					<form action="/action_page.php" target="_blank">
						<div class="w3-row-padding" style="margin: 0 -16px 8px -16px">
							<div class="w3-half">
								<input class="w3-input w3-border" type="text" placeholder="Name"
									required name="Name">
							</div>
							<div class="w3-half">
								<input class="w3-input w3-border" type="text"
									placeholder="Email" required name="Email">
							</div>
						</div>
						<input class="w3-input w3-border" type="text"
							placeholder="Message" required name="Message">
						<button class="w3-button w3-blue w3-section w3-right" disabled
							type="submit">SEND</button>
					</form>
				</div>
			</div>


			<!-- End Page Content -->
		</div>

		<!-- Image of location/map -->

		<img src="../imgs/map.jpg" class="w3-image w3-greyscale-min"
			style="width: 100%">
	</div>

	<!-- Footer -->
	<footer
		class="w3-container w3-padding-64 w3-center w3-opacity  w3-xlarge w3-blue">
		<a href="https://www.facebook.com"> <i class ="fa
				fa-facebook-officialw3-hover-opacity"></i></a> <a
			href="https://www.instagram.com"><i
			class="fa fa-instagram w3-hover-opacity"></i></a> <a
			href="https://www.snapchat.com"><i
				class="fa fa-snapchat w3-hover-opacity"></i></a> <a
				href="https://www.printers.com"><i
					class="fa fa-pinterest-p w3-hover-opacity"></i></a> <a
					href="https://www.twitter.com"> <i
						class="fa fa-twitter w3-hover-opacity"></i></a> <a
						href="https://www.linkedin.com"><i
							class="fa fa-linkedin w3-hover-opacity"></i></a>
	</footer>

	<script>
		// Automatic Slideshow - change image every 4 seconds
		var myIndex = 0;
		carousel();

		function carousel() {
			var i;
			var x = document.getElementsByClassName("mySlides");
			for (i = 0; i < x.length; i++) {
				x[i].style.display = "none";
			}
			myIndex++;
			if (myIndex > x.length) {
				myIndex = 1
			}
			x[myIndex - 1].style.display = "block";
			setTimeout(carousel, 4000);
		}

		// Used to toggle the menu on small screens when clicking on the menu button
		function myFunction() {
			var x = document.getElementById("navDemo");
			if (x.className.indexOf("w3-show") == -1) {
				x.className += " w3-show";
			} else {
				x.className = x.className.replace(" w3-show", "");
			}
		}

		// When the user clicks anywhere outside of the modal, close it
		var modal = document.getElementById('ticketModal');
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
	</script>
</body>
</html>