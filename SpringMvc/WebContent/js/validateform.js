function validateForm(){


	var flag = true;
	var username = document.getElementById("username").value;
	var email = document.getElementById("email").value;
	var address = document.getElementById("address").value;
	var phonenumber = document.getElementById("phonenumber").value;
	var reg = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/

	var fieldsResult  = validateFields(username,email,phonenumber,address);
	var emailResult = validateEmail(email);
	var phonenumberResult = validatePhoneNumber(phonenumber); 

	if(!fieldsResult){
		flag = false;
		alert("Fields cannot be empty.");
		
	}
	else{
			if(!emailResult){
				flag = false;
			alert("Email is not Valid .");
			}

			if(!phonenumberResult){
				flag = false;
			alert("PhoneNumber is not valid");
			}
	}
	
	return flag;

}
/* Add More Fields here.*/
function validateFields(username,email,phonenumber,address){

		if(!username || !email || !phonenumber || !address){
	
		return  false;
	}
	else{
		return true;
	}
}

function validateEmail(email){

		var flag = true;
		var reg = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/

		if(!reg.test(email)){
		
			return false;
		}else{
			return true;
		}

		
}

function validatePhoneNumber(phonenumber){

	var flag = true;

		if(isNaN(phonenumber) || phonenumber.length != 10){
	
		return false;
	}else{
		return true;
	}


}