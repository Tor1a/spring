function showCorona(_date) {
    const sendData = {
        date:_date
    }
    $.ajax({
        url:"ApiCall.do",
        dataType:"json",
        data:sendData,
        success:function(data){
            console.log(data.response.body.items.item);
            //배열 출력되는지 확인...
            const coronaArray = data.response.body.items.item;
            const total = coronaArray.length;
            $.each(coronaArray,function(i,item){
                $("#coronaList").append(`
                                        <li>
                                            <h2>${item.gubun}</h2>
                                            <p class="num">${item.localOccCnt}</p>
                                        </li>
                                    `);
            });
            gsap.fromTo("#coronaList > li",{y:-1000},{
                                            y:0,
                                            ease:"back.out",
                                            duration:1.5,
                                            rotation:function(i,item){
                                                if(i!=total-1) {
                                                    return Math.random()*10-5
                                                } else {
                                                    return 0
                                                }
                                            },
                                            stagger:0.1
            })
        }
    });
}


showCorona("20210927");

$("body").on("click","#coronaList > li",function(){
    gsap.to($(this),{
                        y:1500,
                        ease:"power4.in",
                        rotation:Math.random()*180-90,
                        duration:1.5,

                        //gsap 이벤트 핸들러...
                        onComplete:function(item,num){
                            console.log(item);
                            console.log(num);
                            $("#coronaList").prepend(item);
                            gsap.set(item,{y:0,rotation:Math.random()*10-5});
                        },
                        onCompleteParams:[$(this),20]
                    })
});

//////////////////calendar///////////////////////////////

let now = new Data();
let firstDay  = new Data(now.getFullYear(),now.getMonth(),1);
const  dayList = ["SUN","MON","TUE","WED","THU","FRI","SAT"];
const monthList = ["january","february","march","april","may","june","july","august","september","october","november","december"];
const leapYear = [31,29,31,30,31,30,31,31,30,31,30,31]; //윤년
const noneleapYear = [31,28,31,30,31,30,31,31,30,31,30,31]; // 평년
//console.log(firstYoil);

let pageYear;

function makeCalendar(pickedYear,pickedMonth){
    firstDay = new Date(pickedYear,pickedMonth);
    const firstYear = firstDay.getFullYear();
    const month = monthList[pickedMonth];

    //윤년판단
    if(firstYear  % 4 ==  0){
        if(firstYear % 100 == 0){
            pageYear = noneleapYear; // 윤년아님
        }else{
            pageYear = leapYear; // 윤년
        }
    }
    if(firstYear % 400 == 0){
        pageYear = leapYear;
    }
    $("#calendar .monthTitle .year").text(pickedYear);
    $("#calendar .monthTitle .month").text(month);

    let count = 1;
    $("#calendar .dates").html("");
    for(let i=0; i <42; i++){
        if(i<firstDay.getDay()){
            $("#calendar .dates .itemList").append('<li class="blank"><span></span></li>');
        }else{
            $("#calendar .dates .itemList").append('<li><span>${count}</span></li>');
            count++;
        }
        
    }
}

makeCalendar(2021,5);

