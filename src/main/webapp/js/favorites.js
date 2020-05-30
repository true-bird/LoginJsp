window.onload = function() {
	const form = document.forms[0];
	const favorite = document.getElementsByName('favorite');
	const button = document.getElementsByClassName('burgundyButton');
	form.addEventListener('submit',()=> {
		let cnt = 0;
		for(i=0;i<favorite.length;i++) {
			if(favorite[i].checked == true) {
				cnt++;
			}
		}
		if(cnt==0) {
			alert("선수를 선택해 주세요.");
			event.preventDefault();
		}
	});	
};