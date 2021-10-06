///////////////////////calendar////////////////////
let now = new Date();
let firstDay = new Date(now.getFullYear(), now.getMonth(), 1);
const dayList = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"];
const monthList = ["january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december"];
const leapYear = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]; // 윤년
const noneLeapYear = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]; // 평년

let pageYear;

const pickedNow = new Date();  // 실질적인 달력....
let queryDate;

function makeCalendar(pickedYear, pickedMonth, pickedDate) {

	firstDay = new Date(pickedYear, pickedMonth, pickedDate);  // 넘어오는 날짜를 가지고 달력 구성
	const firstYear = firstDay.getFullYear();
	const month = monthList[pickedMonth];
	queryDate =  firstDay.getFullYear() + "" + addZero(firstDay.getMonth() + 1) + "" + 
	addZero(pickedNow.getDate());

	//윤년판단
	if (firstYear % 4 === 0) {
		if (firstYear % 100 === 0) {
			pageYear = noneLeapYear; //  윤년 아님
		} else {
			pageYear = leapYear; //  윤년 아님
		}
	} else {
		pageYear = noneLeapYear;
	}
	if (firstYear % 400 === 0) {
		pageYear = leapYear;
	}
	$("#calendar .monthTitle .year").text(pickedYear);
	$("#calendar .monthTitle .month").text(month);

	$("#pickedDay").text( dayList[ now.getDay() ]);
	$("#pickedDate").text( addZero(now.getDate()) );

	let count = 1;
	$("#calendar .dates .itemList").html("");
	for (let i = 0; i < 42; i++) {
		//요일을 가지고 판단.  1일이 무슨 요일인지 판단해서 공백 채우기
		if (i < firstDay.getDay()) {
			$("#calendar .dates .itemList").append(`<li class="blank"><span></span></li>`);
		} else {
			$("#calendar .dates .itemList").append(`<li data-num ="${count}"><span>${count}</span></li>`);
			if (pickedNow.getFullYear() === now.getFullYear() &&
				pickedNow.getMonth() === now.getMonth() && count === pickedNow.getDate()) {
				$(`#calendar .dates .itemList li:nth-child(${i + 1})`).addClass("today on");
				//오늘 날짜에 불들어오게.....
			}
			count++;
		}
		if (count > pageYear[firstDay.getMonth()]) {
			break;
		}
	}
	gsap.from("#calendar .dates .itemList li",{
		scale:0,stagger:0.02,duration:1,ease:"power4"
	});
}

makeCalendar(firstDay.getFullYear(), firstDay.getMonth(), firstDay.getDate());

function addZero(num) {
	if (num < 10) {
		return "0" + num;
	} else {
		return "" + num;
	}
}

//now 는 app이 시작하느느 시점의 날짜...
$("#calendar .header .btnNextMonth").on("click", function() {
	now = new Date(now.getFullYear(), now.getMonth() + 1, 1);
	makeCalendar(now.getFullYear(), now.getMonth(), 1);
});
$("#calendar .header .btnPrevMonth").on("click", function() {
	now = new Date(now.getFullYear(), now.getMonth() - 1, 1);
	makeCalendar(now.getFullYear(), now.getMonth(), 1);
});

$(".calendarWrap .dateBox input").val(pickedNow.getFullYear() + "/" + addZero(pickedNow.getMonth() + 1) + "/" + addZero(pickedNow.getDate()));

$("body").on("click", "#calendar .dates .itemList > li", function() {
	console.log($(this).data("num"));
	const clickedDate = $(this).data("num");
	now = new Date(now.getFullYear(), now.getMonth(), clickedDate);
	//20211001
	//console.log(now.getFullYear() + "" + (now.getMonth() + 1) + "" + now.getDate());

	$("#pickedDay").text( dayList[ now.getDay() ]);
	$("#pickedDate").text( addZero(now.getDate()) );


	$(this).addClass("on").siblings().removeClass("on");
	queryDate =  now.getFullYear() + "" + addZero(now.getMonth() + 1) + "" + addZero(now.getDate());
	


	const sendData = {
		todo: $("#todoTxt").val(),
		done: "none",
		pickedDate: queryDate
	}
	$.ajax({
		url: "GetTodoList.do",
		data: JSON.stringify(sendData),  //json문자열 형태로 바꾸기....
		contentType:"application/json",  //보내는 타입을 결정
		dataType:"json",                 //json
		method:"POST",                   //?pickeddate=20211004
		success: function(resultData) {
			//console.log(resultData);
			$(".todoList").html("");
			$.each(resultData.todoList,function(i,item){
				$(".todoList").append(`<li data-no="${item.no}" class="${item.done}">
            				<span>${item.todo}</span>
            				<button class="btnDelete"><span class="material-icons">delete</span></button>
            			</li>`)	
			})
			
		},
		error: function(error) {
			console.log(error);
		}
	})
	
});

$(".calendarWrap .dateBox input").on("click", function() {
	$("#calendar").toggle();
	//$(".calendarWrap .dateBox input").val("2021/10/01");
});

//시작하자마자 데이터 받기...
//pickedNow 는 오늘날짜...
console.log(firstDay.getDate());
const sendData = {
	pickedDate: pickedNow.getFullYear() + "" + addZero(pickedNow.getMonth() + 1) + "" + addZero(pickedNow.getDate())
}
console.log(JSON.stringify(sendData));
$.ajax({
	url: "GetTodoList.do",
	contentType:"application/json",  // 보낼때
	data: JSON.stringify(sendData), // json형태로 바뀜
	dataType:"json", // response되는 데이터를 json받겠다.
	method:"POST",
	success: function(resultData) {
		//console.log(resultData);
		$(".todoList").html("");
		$.each(resultData.todoList,function(i,item){
			$(".todoList").append(`<li data-no="${item.no}" class="${item.done}">
						<span>${item.todo}</span>
						<button class="btnDelete"><span class="material-icons">delete</span></button>
					</li>`)	
		})
		
	},
	error: function(error) {
		console.log(error);
	}
});



/////////todoApp/////////////////////

$("#todoTxt").on("keyup",function(e){
	console.log(e);
	if(e.keyCode===13) {
		$("#calendar .btnAdd").trigger("click");  //dispatchEvent
	}
});

$("#calendar .btnAdd").on("click", function() {
	const _this = $(this);
	_this.addClass("not");
    if($.trim($("#todoTxt").val()) === ""){
        alert("공백은 입력하지 마세요");
		$("#todoTxt").val("");
        $("#todoTxt").focus();
        return;
    }
	$("#todoTxt").focus();
	const sendData = {
		todo: $("#todoTxt").val(),
		done: "none",
		pickedDate: queryDate
	}
	$.ajax({
		url: "InsertTodo.do",
		data: JSON.stringify(sendData),
		contentType:"application/json",
		dataType:"json",
		method:"POST",
		success: function(resultData) {
			//console.log(resultData);
			$("#todoTxt").val("");
			_this.removeClass("not");
			$(".todoList").html("");
			$.each(resultData.todoList,function(i,item){
				$(".todoList").append(`<li data-no="${item.no}" class="${item.done}">
            				<span>${item.todo}</span>
            				<button class="btnDelete"><span class="material-icons">delete</span></button>
            			</li>`)	
			});
			
		},
		error: function(error) {
			console.log(error);
		}
	});
});

//기존에 나와 있던 것들.... 이벤트 위임... currentTarget 으로 찾기...
$(".todoList").on("click",".btnDelete",function(e) {
	const _parent = $(this).parent();
	const sendData= {
		no:_parent.data("no")
	}
	console.log(sendData.no);
	$.ajax({
		url:"DeleteTodo.do",
		data:JSON.stringify(sendData),
		contentType:"application/json",
		dataType:"json",
		method:"POST",
		success:function(resultData) {
			console.log(resultData);
			if(resultData.result>0){
				gsap.to(_parent,{
								x:-800,
								ease:"power4.in",
								onComplete:function() {
									_parent.remove();
								}
							});  // 위치만 이동했다.
			}
		},
		error:function(error) {
			console.log(error);
		}
	})
});


$(".todoList").on("click","li > span",function(){
	const _parent = $(this).parent();
	const sendData = {};
	sendData.no=_parent.data("no");
	if(_parent.hasClass("done")) {
		sendData.done="none";
	} else {
		sendData.done="done";
	}
	console.log(sendData);
	$.ajax({
		url:"UpdateTodo.do",
		data:JSON.stringify(sendData),
		contentType:"application/json",
		dataType:"json",
		method:"POST",
		success:function(resultData){
			if(resultData.result>0) {
				if(_parent.hasClass("done")){
					_parent.removeClass("done").addClass("none");
				} else {
					_parent.removeClass("none").addClass("done");
				}
			}
		},
		error:function(error){
			console.log(error)
		}
	})
});