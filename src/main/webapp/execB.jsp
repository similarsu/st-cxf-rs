<%@page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title> </title>
<script type="text/javascript">
		parent.window.myframe.addStu('<%=request.getParameter("json") %>',<%=request.getParameter("callback") %>); // execute parent myframe fIframe function
</script>
</head>
<body>
</body>
</html>