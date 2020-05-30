window.onload = function() {
	let httpRequest = null;
	function getXMLHttpRequest() {
		httpRequest = null;
		if(window.ActiveXObject) {
			try {
				httpRequest = new ActiveXObject("Msxm12.XMLHTTP");
			} catch(e) {
				try {
					httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
				} catch(e2) { httpRequest = null; }
			}
		} else if(window.XMLHttpRequest) {
			httpRequest = new window.XMLHttpRequest();
		}
		return httpRequest;
	}
	
	const form = document.forms[0];
	const year = document.getElementById('year');
	const month = document.getElementById('month');
	const day = document.getElementById('day');
	const resetButton = document.getElementById('resetButton');
	const gender = document.getElementsByName('gender');

	const userId = document.getElementById('userId');
	const checkButton = document.getElementById('checkButton');
	
	const userPassword = document.getElementById('userPassword');
	const userPasswordCheck = document.getElementById('userPasswordCheck');
	const userName = document.getElementById('userName');
	
	userId.addEventListener('input',numberMaxLength);
	userId.addEventListener('input',() => {
		if(checkButton.value !='중복체크') {
			checkButton.value = '중복체크';
			checkButton.style.backgroundColor = "white";
        	checkButton.style.color = "#8e1e13";
            checkButton.disabled = false;
		}
	});
	
	userPassword.addEventListener('input',numberMaxLength);
	userPasswordCheck.addEventListener('input',numberMaxLength);
	userName.addEventListener('input',numberMaxLength);
	function numberMaxLength(){
		if(this.value.length > this.maxLength){
			this.value = this.value.slice(0, this.maxLength);
	    }
	}
	
	
	form.addEventListener('submit',()=> {
		if(userId.value.length==0) {
			alert("아이디를 입력해주세요.");
			userId.focus();
			event.preventDefault();
		} else if (userPassword.value.length==0) {
			alert("패스워드를 입력해주세요.");
			userPassword.focus();
			event.preventDefault();
		} else if(userPassword.value !== userPasswordCheck.value) {
			alert("패스워드와 패스워드(확인)이 같지 않습니다.");
			userPasswordCheck.focus();
			event.preventDefault();
		} else if (userName.value.length==0) {
			alert("이름을 입력해주세요.");
			userPassword.focus();
			event.preventDefault();
		} else if (checkButton.value != '사용가능') {
			alert("아이디 중복체크를 해주세요.");
			userId.focus();
			event.preventDefault();
		} else {
			if(confirm("위의 정보가 맞습니까?")) {
				
			} else {
				event.preventDefault();
			}
		}
	});
	
	checkButton.addEventListener('click',idCheck);
	
	function idCheck(){
		if(userId.value.length<userId.minLength) {
			alert("아이디를 5글자 이상 입력해주세요.");
			userId.focus();
		} else {
			let param = "userId="+userId.value;
			httpRequest = getXMLHttpRequest();
            httpRequest.onreadystatechange = callback;
            httpRequest.open("POST", "CheckAction.do", true);    
            httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded'); 
            httpRequest.send(param);
            checkButton.disabled = 'disabled'
		}
	}
	
	function callback() {
		if(httpRequest.readyState == 4){
            // 결과값을 가져온다.
            var resultText = httpRequest.responseText;
            if(resultText == 1 ){
                checkButton.disabled = false;
                alert("아이디가 중복되었습니다.");
            } 
            else if(resultText ==0 ){ 
            	checkButton.value = '사용가능';
            	checkButton.style.backgroundColor = "#8e1e13";
            	checkButton.style.color = "white";
                alert("사용 가능한 아이디입니다.")
            }
        }
	}
	
	year.addEventListener('change',(event)=>{
		if(month.value==2) {
			if(event.target.value%4==0 && day.options.length==28) {
				let op = new Option();
			    op.value = op.text = 29;
			    day.add(op);
			} else if(event.target.value%4!=0 && day.options.length==29) {
				day.remove(28);
			}
		}
		day[0].selected = true;
	});
	
	month.addEventListener('change',(event)=>{
		const mon = event.target.value;
		if(mon==2) { // 28 or 29
			if(day.options.length==31) {
				day.remove(30);
			}
			day.remove(29);
			if(year.value%4!=0) day.remove(28);
		} else if((mon%2==0 && mon>7) || (mon%2!=0 && mon<=7)) { // 31
			for(let i=day.options.length+1;i<=31;i++) {
				let op = new Option();
			    op.value = op.text = i;
			    day.add(op);
			}
		} else { // 30
			if(day.options.length==31) {
				day.remove(30);
			} else {
				for(let i=day.options.length+1;i<=30;i++) {
					let op = new Option();
				    op.value = op.text = i;
				    day.add(op);
				}
			}
		}
		day[0].selected = true;
	});
	
	
	function init() {
		let yearHtml = null;
		let monthHtml = null;
		let dayHtml = null;
		for(let i=0;i<=100;i++) { yearHtml += "<option value="+(2020-i)+">"+(2020-i)+"</option>"}
		for(let i=1;i<=12;i++) { monthHtml += "<option value="+i+">"+i+"</option>"}
		for(let i=1;i<=31;i++) { dayHtml += "<option value="+i+">"+i+"</option>"}
		year.innerHTML = yearHtml;
		month.innerHTML = monthHtml;
		day.innerHTML = dayHtml
		year[0].selected = month[0].selected = day[0].selected = true;
	}
	
	init();
	
};

