/**
 * 
 */

function ValidateForm()
{
	var x = document.forms["form1"]["username"].value;
	var y = document.forms["form1"]["password"].value;
    var labelPass=document.getElementById("Passlabel");
   	var labelUsers=document.getElementById("userlabel");
	
	
	  if (x == "")
	  {
	   labelUsers.innerHTML="Name must be filled out";
	 
	   return false;
	  }
	   if (y == "") 
	   {
		 labelPass.innerHTML="Password must be filled out";
	
	    return false;
	  }
	return true;
	}



// Function to open File
