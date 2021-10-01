<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&family=Roboto:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="css/reset.css" rel="stylesheet"></link>
<link href="css/common.css" rel="stylesheet"></link>
<link href="css/layout.css" rel="stylesheet"></link>
<link href="css/main.css" rel="stylesheet"></link>
<link href="css/calendar.css" rel="stylesheet"></link>
<script src="js/jquery-3.6.0.min.js"></script>
<script src="js/gsap/gsap.min.js"></script>
<script src="js/corona.js" defer></script>
</head>
<body>
    <div class="calendarWrap">
        <div id="calendar">
            <div class="todo">
            	<div class="day" id="pickedDay">THU</div>`
            	<div class="date" id="pickedDate">01</div>
            	<div class="inputBox">
            		<input type="text" name="todo" id="todoTxt">
            		<button class="btnAdd"><span class="material-icons">add</span></button>
            	</div>
            	<div class="todoListBox">
            		<ul class="todoList">
            			<li data-no="1" class="done">
            				<span>밥먹기</span>
            				<button class="btnDelete"><span class="material-icons">delete</span></button>
            			</li>
            		</ul>
            	</div>
            </div>
            <div class="calendarBox">
                <div class="header">
                    <button class="btnPrevMonth"><span class="material-icons">chevron_left</span></button>
                    <div class="monthTitle">
                        <span class="year">2021</span>
                        <span class="month">10</span>
                    </div>
                    <button class="btnNextMonth"><span class="material-icons">chevron_right</span></button>
                </div>
                <div class="days">
                    <ul class="itemList">
                        <li class="sun"><span>SUN</span></li>
                        <li><span>MON</span></li>
                        <li><span>TUE</span></li>
                        <li><span>WED</span></li>
                        <li><span>THU</span></li>
                        <li><span>FRI</span></li>
                        <li class="sat"><span>SAT</span></li>
                    </ul>
                </div>
                <div class="dates">
                    <ul class="itemList">
                        <li><span>01</span></li>
                        <li><span>02</span></li>
                        <li><span>03</span></li>
                        <li><span>04</span></li>
                        <li><span>05</span></li>
                        <li><span>06</span></li>
                        <li><span>07</span></li>
                        <li><span>08</span></li>
                        <li><span>09</span></li>
                        <li><span>10</span></li>
                    </ul>
                </div>
            </div>

        </div>
    </div>


</body>
</html>