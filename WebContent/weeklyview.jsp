<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	Calendar c = Calendar.getInstance();
	int month = c.get(c.MONTH) + 1;
	
	c.set(c.DAY_OF_WEEK, 2);
	int start = c.get(c.DAY_OF_MONTH);
	c.set(c.DAY_OF_WEEK, 6);
	int end = c.get(c.DAY_OF_MONTH);
%>
<center>
<h2>weekly review</h2>
	<table border="1" bgcolor="#109f5f" height="200" width="400" >
		<tr><td>from <%=month %>.<%=start %> to <%=month %>.<%=end %></td><td>status: not submit</td><td><input type="button" onclick="window.location='report.jsp'" value="Add one"></td></tr>
		<tr><td>xxcv</td><td></td><td></td></tr>
		<tr><td>zz</td><td></td><td></td></tr>
		<tr><td>bbb</td><td></td><td></td></tr>
		<tr><td>eee</td><td></td><td></td></tr>
	</table>
</center>
</body>
</html>