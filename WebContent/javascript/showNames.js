/**
 * 
 */

function showEmp(name)
{ 
 if(document.getElementById("address").value!="-1")
 {
 xmlHttp=GetXmlHttpObject()
if (xmlHttp==null)
{
 alert ("Browser does not support HTTP Request")
 return
 }
var url="getvalue2.jsp"
url=url+"?name="+name
xmlHttp.onreadystatechange=stateChanged 
xmlHttp.open("GET",url,true)
xmlHttp.send(null)
}
else{
 alert("Please Select Employee Id");
}
}
function stateChanged()
{ 
if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete") { 
var showdata = xmlHttp.responseText; 
var strar = showdata.split(":");

 }
 } 


function GetXmlHttpObject(){
var xmlHttp=null;
try{
 xmlHttp=new XMLHttpRequest();
 }
catch (e) {
 try {
  xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
  }
 catch (e)  {
  xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
 }
return xmlHttp;
}


function showSub(name)
{ 
 if(document.getElementById("address").value!="-1")
 {
 xmlHttp=GetXmlHttpObject()
if (xmlHttp==null)
{
 alert ("Browser does not support HTTP Request")
 return
 }
var url="getvalue.jsp"
url=url+"?sub="+sub
xmlHttp.onreadystatechange=stateChanged 
xmlHttp.open("GET",url,true)
xmlHttp.send(null)
}
else{
 alert("Please Select Employee Id");
}
}
function stateChanged()
{ 
if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete") { 
var showdata = xmlHttp.responseText; 
var strar = showdata.split(":");

 }
 } 


function GetXmlHttpObject(){
var xmlHttp=null;
try{
 xmlHttp=new XMLHttpRequest();
 }
catch (e) {
 try {
  xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
  }
 catch (e)  {
  xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
 }
return xmlHttp;
}

function getOption() { 
    selectElement = document.querySelector('#DocNames'); 
              
    output =  
      selectElement.options[selectElement.selectedIndex].value; 

   return output; 
} 

