<%@page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title> </title>
<script type="text/javascript" src="jquery-1.7.1.min.js"></script>
<script type="text/javascript">
function addStu(str,callback){
	$.ajax({ 
		type:'POST', 
		url:'rs/student/add.json', 
		contentType:'application/json; charset=utf-8',
		data:str,//可以直接加一个函数名。 
		dataType:'json', 
		success:function(res){
			callback(res);
		},
		error:function(){
			callback("失败");
		}
		});
}

  </script>
</head>
<body>
</body>
</html>