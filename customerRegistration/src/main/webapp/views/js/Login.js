
function validateform(){  
	aler("function called");
	console.log("js called");
var name=document.login-form.userLoginId.value;  
var password=document.login-form.password.value;  


  
if (name==null || name==""){  
  alert("Username can't be blank");  
  return false;  
}else if(password==""){  
  alert("Password can't be blank'");  
  return false;  
  }  
}


