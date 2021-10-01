///////////////////////calendar////////////////////
let now = new Date();
let firstDay = new Date(now.getFullYear(), now.getMonth(), 1);
const dayList = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"];
const monthList = ["january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december"];
const leapYear = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]; // 윤년
const noneLeapYear = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]; // 평년

let pageYear;

const pickedNow = new Date();
let queryDate;

function makeCalendar(pickedYear, pickedMonth, pickedDate) {
	firstDay = new Date(pickedYear, pickedMonth, pickedDate);
	const firstYear = firstDay.getFullYear();
	const month = monthList[pickedMonth];
	queryDate =  firstDay.getFullYear() + "" + addZero(firstDay.getMonth() + 1) + "" + addZero(firstDay.getDate());
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

	let count = 1;
	$("#calendar .dates .itemList").html("");
	console.log(firstDay.getMonth());
	for (let i = 0; i < 42; i++) {
		//요일을 가지고 판단.  1일이 무슨 요일인지 판단해서 공백 채우기
		if (i < firstDay.getDay()) {
			$("#calendar .dates .itemList").append(`<li class="blank"><span></span></li>`);
		} else {
			$("#calendar .dates .itemList").append(`<li data-num ="${count}"><span>${count}</span></li>`);
			if (pickedNow.getFullYear() === now.getFullYear() &&
				pickedNow.getMonth() === now.getMonth() && count === now.getDate()) {
				$(`#calendar .dates .itemList li:nth-child(${i + 1})`).addClass("today on");
				//오늘 날짜에 불들어오게.....
			}
			count++;
		}
		if (count > pageYear[firstDay.getMonth()]) {
			break;
		}
	}
}

makeCalendar(now.getFullYear(), now.getMonth(), now.getDate());

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
	console.log("난 출력이 되지 않습니다.");
	console.log($(this).data("num"));
	const clickedDate = $(this).data("num");
	now = new Date(now.getFullYear(), now.getMonth(), clickedDate);
	//20211001
	console.log(now.getFullYear() + "" + (now.getMonth() + 1) + "" + now.getDate());

	$(this).addClass("on").siblings().removeClass("on");
	queryDate =  now.getFullYear() + "" + addZero(now.getMonth() + 1) + "" + addZero(now.getDate());
	
	const sendData = {
		todo: $("#todoTxt").val(),
		done: "none",
		pickedDate: queryDate
	}
	$.ajax({
		url: "GetTodoList.do",
		data: sendData,
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


/////////todoApp/////////////////////

$("#calendar .btnAdd").on("click", function() {
	const sendData = {
		todo: $("#todoTxt").val(),
		done: "none",
		pickedDate: queryDate
	}
	$.ajax({
		url: "InsertTodo.do",
		data: sendData,
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




























