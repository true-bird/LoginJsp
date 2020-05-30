window.onload = function() {
	const userId = document.getElementById('userId');
	const userPassword = document.getElementById('userPassword');
	const form = document.forms[0];
	
	userId.addEventListener('input',numberMaxLength);
	userPassword.addEventListener('input',numberMaxLength);
	form.addEventListener('submit',()=> {
		if(userId.value.length==0) {
			alert("아이디를 입력해주세요.");
			userId.focus();
			event.preventDefault();
		} else if (userPassword.value.length==0) {
			alert("패스워드를 입력해주세요.");
			userPassword.focus();
			event.preventDefault();
		}
	});
	
	function numberMaxLength(){
		if(this.value.length > this.maxLength){
			this.value = this.value.slice(0, this.maxLength);
	    }
	}
	
};

