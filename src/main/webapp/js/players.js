window.onload = function() {
	const form = document.forms[0];
	const player = document.getElementsByName('player');
	const button = document.getElementsByClassName('burgundyButton');
	form.addEventListener('submit',()=> {
		if(button[0].id=="impossible") {
			alert("로그인 후 이용가능합니다.");
			event.preventDefault();
		} else {
			let cnt = 0;
			for(i=0;i<player.length;i++) {
				if(player[i].checked == true) {
					cnt++;
				}
			}
			if(cnt==0) {
				alert("선수를 선택해 주세요.");
				event.preventDefault();
			}
		}
	});
	
	
	
};