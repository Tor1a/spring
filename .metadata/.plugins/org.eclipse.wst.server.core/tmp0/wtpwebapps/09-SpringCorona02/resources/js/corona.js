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




