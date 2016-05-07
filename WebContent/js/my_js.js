//function to validate empty field
function check_empty(){
if(document.getElementById('namef').value == "" 
|| document.getElementById('emailf').value == "" 
||document.getElementById('msgf').value == "" ){
alert ("Fill All Fields !");
}
	else {  
	document.getElementById('form').submit();  
	alert ("Sending Your Feedback....");
	}
}

//function to display Popup
function div_show(){ 
document.getElementById('abc').style.display = "block";
}

//function to hide Popup
function div_hide(){ 
document.getElementById('abc').style.display = "none";
}
