$(function(){
	var content;
	
	$.ajax({
		type: "POST",
		url: "/BookmarkManager/GetBookMarksServlet",
		//data: json,
		success: function(msg){
			
			var obj = jQuery.parseJSON(msg);
			var pageCount = obj.pageCount;
			var bookCount = obj.bookCount;
			content = obj.bookList;
			$(content).each(function(index){
				var item = content[index];
				$(".bookList").append("<li><div class='listContent'>"
						+ item.title +"<button class='deleteBtn' onclick='deleteBook("+index+")'>delete</button></div><div class='listTime'>@created "
						+ item.date + "</div></li>");
				
			});
			
			for(var i=0;i<pageCount;i++){
				$(".pageCount").append("<li><a class='pageNum' id='page_"+i+"' href='javascript:void(0)'  onclick='getBookByPage("+i+")'>["+(i+1)+"]</a></li>");
			}
			
			$(".rescount").html(bookCount);
			
		}

	});
	
	
	
	$("#page_1").click(function(){
		alert("ok");
		var page_id = $(".pageNum").attr("id");
		alert(page_id);
	});
	
	$(".keywords").focus(function(){
		if('please input key words' == $(this).val()) 
		$(this).val("");
	});
	
	$(".keywords").blur(function(){
		if('' == this.value){
			$(this).val("please input key words");
		}
	});
	
	$(".keywords").keyup(function(){
		
		var keywords = $(this).val();
		
			var keywordRE = new RegExp(keywords, "gi");
			

			$(".bookList").html("");  
			
			content.filter(function(obj) {
				return keywordRE.test(obj.title);
			}).map(function (obj) {
				var highlight = obj.title.replace(keywordRE, '<span class="highlight">$&</span>');
				
				$(".bookList").append("<li><div class='listContent'>"
				+ highlight +"</div><div class='listTime'>@created "
				+ obj.date + "</div></li>");
				
			});
		
		});	
			
	$("#addBook").click(function(){
		$(".bookForm").show();
	})
	
	$("#submitBookMark").click(function(){
		var name = $("#bookname").val();
		var addr = $("#bookaddr").val();
		var bookname;
		var bookaddr;
		$(".bookForm").hide();
		$.ajax({
			type: "POST",
			url: "/BookmarkManager/AddBookMarkServlet",
			data: "bookname="+name+"&bookaddr="+addr+"",
			success: function(msg){
				var obj = jQuery.parseJSON(msg);
				var pageCount = obj.pageCount;
				content = obj.bookList;
				$(".bookList").empty();
				$(content).each(function(index){
					var item = content[index];
					$(".bookList").append("<li><div class='listContent'>"
							+ item.title +"<button class='deleteBtn' onclick='deleteBook("+index+")'>delete</button></div><div class='listTime'>@created "
							+ item.date + "</div></li>");
					
				});
				
			}

		});
	});
	
		
	function  getFormatDate(ns){ 
		return new Date(parseInt(ns) * 1000).toLocaleString().replace(new RegExp("\\/","g"), "-");
			
	}
	
	
});
function getBookByPage(page) {
	var pageNum;
	
	$.ajax({
		type: "POST",
		url: "/BookmarkManager/GetBookMarksServlet",
		data: "pageNum="+page,
		success: function(msg){
			var obj = jQuery.parseJSON(msg);
			var pageCount = obj.pageCount;
			content = obj.bookList;
			$(".bookList").empty();
			$(content).each(function(index){
				var item = content[index];
				$(".bookList").append("<li><div class='listContent'>"
						+ item.title +"<button class='deleteBtn' onclick='deleteBook("+index+")'>delete</button></div><div class='listTime'>@created "
						+ item.date + "</div></li>");
				
				
			});
			
			
			
		}

	});
	
}

function deleteBook(_index) {
	var index;
	$.ajax({
		type: "POST",
		url: "/BookmarkManager/DeleteBookMarkServlet",
		data: "index="+_index,
		success: function(msg){
			var obj = jQuery.parseJSON(msg);
			var pageCount = obj.pageCount;
			content = obj.bookList;
			$(".bookList").empty();
			$(content).each(function(index){
				var item = content[index];
				$(".bookList").append("<li><div class='listContent'>"
						+ item.title +"<button class='deleteBtn' onclick='deleteBook("+index+")'>delete</button></div><div class='listTime'>@created "
						+ item.date + "</div></li>");
				
			});
			
		}

	});
	
	
}




