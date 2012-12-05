<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*, hk.edu.uic.cosns.model.vo.*"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<%
if (session.getAttribute("SigninUser") == null) {
	//PrintWriter out = response.getWriter();
	out.println("<center><h1>Please signin!</h1></center>");
	out.println("<center><h2>Redirecting to index page ~~ </h2></center>");
	response.setHeader("Refresh","2;URL=./index.jsp");
	return;
}
%>
</body>
</html>