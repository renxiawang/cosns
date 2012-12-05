<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>CoSns-Sign up</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>

<body>
<div id="whole">
<span style="float:right;margin:30px 10px 0 0;"><a href="index.html">Sign in</a></span>
<div class="signup-frame">
<form method="post" action="">
<input name="email" type="text" style="margin:94px 0 0 292px; width:138px;height:22px; border:0px;" />
<input name="password" type="text" style="margin:16px 0 0 292px; width:138px;height:22px;border:0px;"  />
<input name="pwdConfirm" type="text" style="margin:17px 0 0 292px; width:138px;height:22px;border:0px;"  />
<input name="fullName" type="text" style="margin:19px 0 0 292px; width:138px;height:22px;border:0px;"  />
<input name="signup" type="image" src="images/signup.png"  style="margin:20px 0 0 160px; float:left;" onclick="this.form.action='SignupSVL'" />
<input name="cancel" type="image" src="images/cancel.png"  style="margin:20px 0 0 100px; float:left;" onclick="this.form.action='index.jsp'" />


</form>

</div>


</div>

</body>

</html>
