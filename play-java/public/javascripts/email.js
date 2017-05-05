function validate(){
if(document.levelForm.query.value.test(/^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/)){
	document.levelForm.submit();
	}
}