<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>CoSns-Home</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script 
language="javascript" src="js/hello.js">
</script>
</head>

<body>
	<div>
		<div class="head">
			&nbsp;
			<div class="menu">
				<ul>
					<li><a href="ShowProjectListSVL">Home</a>
					</li>
					<li style="width: 70px"><a href="profile.jsp?uid=<%=signinUser.getUID() %>">Profile</a>
					</li>
					<li style="width: 68px"><a href="my-created-project.jsp">Project</a>
					</li>
					<li><a href="find-people.jsp">Find</a>
					</li>
					<li style="width:100px;"><a href="creatProject.jsp">Creat Project</a>
					</li>
				</ul>
			</div>
			<div class="head-name">
				|&nbsp;<a>Hello! &nbsp;&nbsp;&nbsp;&nbsp;<%=signinUser.getFullName()%></a>
				<div style="float: right;">
					<img class="triangle" src="images/triangle.png" onclick="setting()" />
					<div id="setting"
						style="position: absolute; margin: 0px 0 0 20px; display: none;">
						<ul>
							<li><a href="setting.jsp">Setting</a>
							</li>
							<li><a href="SignoutSVL">Logout</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>