function myfunction(){
if(document.levelForm.type.value == 'user'){
	document.levelForm.submit();
}else{
	alert("Hack attempt detected")
	document.reload();
	}
}