/**
 * 
 */

window.onload=function()
{
	var btn=document.getElementById('submit');
	btn.onclick=function()
			{
		     var password= document.getElementById('password');
		     var confirmPassword=document.getElementById('confirm');
		     if(password!==confirmPassword)
		    	 {
		    	 document.getElementById("error").innerHTML="<h3>Error password do not match</h3>";
		    	 }
		     
			}
	};