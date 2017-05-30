function validate(){

	
	//regex pattern was taken from http://emailregex.com/ on 06/05/2017. 
	var pattern = /^[a-zA-Z0-9.!#$%&’*+/=?^_`'-{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
	var query = document.levelForm.query.value;
	
if(pattern.test(query)){
	document.levelForm.submit();
	}
	alert("error please enter a valid email");
}