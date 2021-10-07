let sendNo;

$.ajax({
	url: "GalleryJsonList.do",
	success: function(resultData) {
		console.log(resultData.galleryList);
		const galleryList = resultData.galleryList;
		$("#galleryList").append(`<ul class="list"></ul>`);
		$.each(galleryList, function(i, item) {
			console.log(item.img);
			$("#galleryList ul").append(`
										<li class="item" data-no=${item.no}>
											<div class="imgBox">
												<img src="${item.img}"
											</div>
											<div class="info">
												<h2>${item.title}</h2>
												<p>${item.contents}</p>
											</div>
										</li>
									   `);

		});
		$("#galleryList").imagesLoaded(function() {
			$("#galleryList .list").isotope({
				itemSelector: ".item",
				layoutMode: "masonry"
			});
		});

	}
});
$("#galleryList").on("click","li",function(){
	const imgSrc = $(this).find("img").attr("src");
	const no = $(this).data("no");
	sendNo = no;
	$("big .img img").attr({"src":""})
	gsap.to("#big",{top:0, duration:1,ease:"power4"});
});

$("#big .btnReply").on("click",function(){
	const  _parent = $(this)._parent();
	const sendData = {
		boardId: sendNo,
		reply:_parent.find("#reply").val()
	}
	$.ajax({
		url:"ReplyWrite.do",
		type:"POST",
		data:sendData,
		success:function(resultData){

		},
		error:function(errorMsg){
			console.log(erroeMsg)
		}
	})
})