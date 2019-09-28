function validate() {
	var x = document.forms["form2"]["FName"].value;
	var y = document.forms["form2"]["LName"].value;
	var z = document.forms["form2"]["username"].value;
	var w = document.forms["form2"]["password"].value;
	var labelPass = document.getElementById("password");
	var labelUsers = document.getElementById("username");
	var labelFName = document.getElementById("fname");
	var labelLName = document.getElementById("lname");

	if (x == "") {
		labelFName.innerHTML = " First Name must be filled out";
		return false;
	} else {
		labelFName.innerHTML = " d";
	}
	if (y == "") {
		labelLName.innerHTML = "Last  Name  must be filled out";

		return false;
	}
	if (z == "") {
		labelUsers.innerHTML = "Username  must be filled out";

		return false;
	}
	if (w == "") {
		labelPass.innerHTML = "Password must be filled out";

		return false;
	}
	return true;
}