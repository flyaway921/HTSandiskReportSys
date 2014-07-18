<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>welcome <span style="font-style: italic;">${session.user.username}!</span></h1>
<form action="submitReport.action" method="get">
	<input name="title" type="text" value="title" style="text-align: center;"/><br/>
	<input name="report.authorname" type="hidden" value="${session.user.username}">
	<textarea name="report.content" rows="25" cols="25"></textarea>
	<input type="submit" value="submit"/>
</form>
<s:debug></s:debug>
</center>
</body>
</html>