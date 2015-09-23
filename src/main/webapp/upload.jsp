<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
</head>
<body>
	<form action="rs/student/upload" method="post" enctype="multipart/form-data">
		<input type="text" name="name" value="测试"/><br/>
		<input type="file" name="file" value="文件上传"/><br/>
		<input type="file" name="file" value="文件上传"/><br/>
		<input type="submit" value="上传"/>
	</form>
</body>
</html>