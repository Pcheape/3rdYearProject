function myfunction(){
alert("done")
if(document.levelForm.type.value == 'user'){
	document.levelForm.submit();
}else{
	alert("Hack attempt detected")
	document.reload();
	}
}