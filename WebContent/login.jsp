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
<!-- 
<form action="UserAction/login.action">
	username: <input type="text" name="username"/><br/>
	password: <input type="password" name="password"/><br/>
	<input type="submit" value="submit">
</form>
 -->

   <s:form action="UserAction/login.action" method="post">  
        <s:textfield key="username" name="user.username"/>  
        <s:password key="password" name="user.password" />  
        <s:submit key="submit" value="login" />  
    </s:form>   
</center>
</body>
</html>