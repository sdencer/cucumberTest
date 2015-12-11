<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>别人的 bookmarks</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
	
		<link href="stylesheets/main.css" type="text/css" rel="stylesheet" >
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/main.js"></script>
		<!-- <script type="text/javascript">
		function getBookByPage() {
			alert(ok);
		}
		</script> -->
    
</head>
<body>
	<div class="domainDiv">
		<header>
			<input type="text"  class="keywords" value="please input key words"/>
			<font>have<span class="rescount"></span>results</font>
		</header>
		<div class="content">
			 <ul class="bookList"></ul>
			 <div class="bottomDiv"><button id="addBook">add</button><ul class="pageCount"></ul></div>
		</div>
		
	</div>
	
	<div class="bookForm">
		
		bookmark name:<input id="bookname" type="text"><br/>
		bookmark addr:<input id="bookaddr" type="text"><br/>
		<button id="submitBookMark">submit</button>
		
	
		
	</div>

</body>
</html>