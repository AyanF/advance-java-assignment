
function validateform(){  



if(loginform.userLoginId.value==0)
{
	alert("Username can't be blank");
	
	return false;
}

if(loginform.password.value==0)
{
	alert("Password is required");
	return false;
}
if(loginform.password.value!=0 && loginform.userLoginId.value!=0)
{
	return true;	
}
  
}


