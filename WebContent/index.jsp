<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
if (session.getAttribute("SigninUser") != null) {
	//PrintWriter out = response.getWriter();
	//out.println("<center><h1>Please signin!</h1></center>");
	//out.println("<center><h2>Redirecting to index page ~~ </h2></center>");
	response.setHeader("Refresh","0;URL=ShowProjectListSVL");
	return;
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="zh-cn" http-equiv="Content-Language" />
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>CoSns-index</title>
</head>

<body>
	<div id="whole">
		<span style="float: right; margin: 30px 10px 0 0;"><a href="signup.jsp">Sign
				up</a>
		</span>

		<div class="index-logo"></div>
		<div class="index-signin">
			<form method="post" action="SigninSVL">
				<input name="email" type="text"
					style="margin: 25px 0 5px 5px; height: 25px; width: 200px; border: 0px;" />
				<input name="password" type="password"
					style="margin: 25px 0 5px 44px; height: 25px; width: 200px; border: 0px;" />
				<input type="image" src="images/signin-button.png"
					style="margin: 20px 0 0 0; float: right;" /> 
			</form>
		</div>
	</div>


</body>

</html>
