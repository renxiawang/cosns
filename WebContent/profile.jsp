<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*,hk.edu.uic.cosns.model.vo.*,hk.edu.uic.cosns.model.dao.impl.*"%>
<%@include file="issignin.jsp" %>
<%
	int uid = Integer.parseInt(request.getParameter("uid"));

	User signinUser = (User) session.getAttribute("SigninUser");
	
	String signinUserName = signinUser.getFullName();
	int signinUserUid = signinUser.getUID();
	
	List<Project> myProjectList = null;
	List<Project> joinedProjectList = null;
	List<Project> favProjectList = null;
	List<News> myAnnounceList = null;
	List<News> myDocList = null;
	List<News> mySharingList = null;
	List<News> myTaskList = null;
	List<Message> msgList = null;
	
	
		UserDAOImpl udi = new UserDAOImpl();
		
		signinUser = udi.findByUID(uid); 
		
		ProjectDAOImpl pdi = new ProjectDAOImpl();
		RoleDAOImpl rdi = new RoleDAOImpl();
		
		int[] myProjectArray = null;
		int[] joinedProjectArray = null;
		int[] favProjectArray = null;

			// 获取三种类型Project List
			myProjectArray = rdi.findMyProjectIDs(signinUser.getUID(), 1);
			if (myProjectArray != null) {
				myProjectList = pdi.findMyProjects(myProjectArray);
				//System.out.println(myProjectList.get(0).getPID());
			}
			joinedProjectArray = rdi.findJoinedProjectIDs(2, signinUser.getUID());
			if (joinedProjectArray != null) {
				joinedProjectList = pdi.findJoinedProjects(joinedProjectArray);
			}
			favProjectArray = rdi.findFavProjectIDs(signinUser.getUID(), 3);
			if (favProjectArray != null) {
				favProjectList = pdi.findFavProjects(favProjectArray);
			}

		NewsDAOImpl ndi = new NewsDAOImpl();
		
		// 通过用户ID查找所有相关PID
	
		if (myProjectArray != null) {
			myAnnounceList = ndi.findNewAnnounceByPIDs(myProjectArray);
			myDocList = ndi.findNewDocByPIDs(myProjectArray);
			mySharingList = ndi.findNewSharingByPIDs(myProjectArray);
			myTaskList = ndi.findNewTaskByPIDs(myProjectArray);
		}
		
		MessageDAOImpl msgdi = new MessageDAOImpl();

		msgList = msgdi.findUserMsgByMBID(signinUser.getMBID());
		
		
%>
<%@include file="followingDAO.jsp" %>



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
					<li style="width: 70px"><a href="profile.jsp?uid=<%=signinUserUid %>">Profile</a>
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
				|&nbsp;<a>Hello!&nbsp;&nbsp;&nbsp;&nbsp; <%=signinUserName%></a>
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

		<div class="main">

			<%@include file="main-left.jsp" %>
			
			<div class="main-middle">
				&nbsp;
				<div style="margin-top:-35px;">
				<!-- Announcement 的 News -->
				<h2>Announcements</h2>
				<%
					if (myAnnounceList != null) {
						for (int i = 0; i < myAnnounceList.size(); i++) {
				%>
				<div class="main-news">
					&nbsp; <img class="news-avatar"
						src=<%="\"" + myAnnounceList.get(i).getPurl() + "\""%> />
					<div class="news-pname">
						<a href=<%="announcement.jsp?pid=" + myAnnounceList.get(i).getPID() %>><%=myAnnounceList.get(i).getProjectName()%></a>
					</div>
					<div class="news-time">
						<a><%=myAnnounceList.get(i).getDate()%></a>
					</div>
					<div class="news-content">
						<textarea class="news-content-words" disabled="disabled";><%=myAnnounceList.get(i).getContent()%></textarea>
					</div>
				</div>
				<%
					}
					}
				%>
				</div>
				<!-- Documentation 的 News -->
				<h2>Documentations</h2>
				<%
					if (myDocList != null) {
						for (int i = 0; i < myDocList.size(); i++) {
				%>
				<div class="main-news">
					&nbsp; <img class="news-avatar"
						src=<%="\"" + myDocList.get(i).getPurl() + "\""%> />
					<div class="news-pname">
						<a href=<%="documentation.jsp?pid=" + myDocList.get(i).getPID() %>><%=myDocList.get(i).getProjectName()%></a>
					</div>
					<div class="news-time">
						<a><%=myDocList.get(i).getDate()%></a>
					</div>
					<div class="news-content">
						<textarea class="news-content-words" disabled="disabled";><%=myDocList.get(i).getContent()%></textarea>
					</div>
				</div>
				<%
					}
					}
				%>
				<!-- Sharing 的 News -->
				<h2>Sharings</h2>
				<%
					if (mySharingList != null) {
						for (int i = 0; i < mySharingList.size(); i++) {
				%>
				<div class="main-news">
					&nbsp; <img class="news-avatar"
						src=<%="\"" + mySharingList.get(i).getPurl() + "\""%> />
					<div class="news-pname">
						<a href=<%="sharing.jsp?pid=" + mySharingList.get(i).getPID() %>><%=mySharingList.get(i).getProjectName()%></a>
					</div>
					<div class="news-time">
						<a><%=mySharingList.get(i).getDate()%></a>
					</div>
					<div class="news-content">
						<textarea class="news-content-words" disabled="disabled";><%=mySharingList.get(i).getContent()%></textarea>
					</div>
				</div>
				<%
					}
					}
				%>
				<!-- Task 的 News -->
				<h2>Tasks</h2>
				<%
					if (myTaskList != null) {
						for (int i = 0; i < myTaskList.size(); i++) {
				%>
				<div class="main-news">
					&nbsp; <img class="news-avatar"
						src=<%="\"" + myTaskList.get(i).getPurl() + "\""%> />
					<div class="news-pname">
						<a href=<%="task.jsp?pid=" + myTaskList.get(i).getPID() %>><%=myTaskList.get(i).getProjectName()%></a>
					</div>
					<div class="news-time">
						<a><%=myTaskList.get(i).getDate()%></a>
					</div>
					<div class="news-content">
						<textarea class="news-content-words" disabled="disabled";><%=myTaskList.get(i).getContent()%></textarea>
					</div>
				</div>
				<%
					}
					}
				%>
			
				
				
				
				
				
				
				
				
			</div>
			<div class="main-right">
				<div class="msg-input">
					<form method="post" action="PostMsgSVL">
						<textarea name="msg_content"
							style="height: 125px; width: 210px; margin: 6px 0 10px 8px; border: 0px;"
							cols="20" rows="2"></textarea>
						<input type="image" src="images/pop.png" name="pop"
							style="float: right;" />
					</form>
				</div>
				<%
					if (msgList != null) {
						for (int i = 0; i < msgList.size(); i++) {
				%>
				<div class="msg-content">
					<textarea id="1" class="msg-single" disabled="disabled"><%=msgList.get(i).getUserName()%> : <%=msgList.get(i).getContent()%></textarea>
				</div>
				<%
					}
					}
				%>

			</div>


		</div>
	</div>
	<div class="bottom"></div>
	</div>
</body>

</html>
