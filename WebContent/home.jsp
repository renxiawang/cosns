<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*,hk.edu.uic.cosns.model.vo.*"%>

<%@include file="issignin.jsp" %>



<%
	User signinUser = (User) session.getAttribute("SigninUser");
	
	List<Project> myProjectList = (LinkedList<Project>) session
			.getAttribute("MyProjectList");
	List<Project> joinedProjectList = (LinkedList<Project>) session
			.getAttribute("JoinedProjectList");
	List<Project> favProjectList = (LinkedList<Project>) session
			.getAttribute("FavProjectList");
	List<News> announceList = (LinkedList<News>) session
			.getAttribute("AnnounceList");
	List<News> docList = (LinkedList<News>) session
			.getAttribute("DocList");
	List<News> sharingList = (LinkedList<News>) session
			.getAttribute("SharingList");
	List<News> taskList = (LinkedList<News>) session
			.getAttribute("TaskList");
	List<Message> msgList = (LinkedList<Message>) session
			.getAttribute("MsgList");
%>
<%@include file="followingDAO.jsp" %>
<%@include file="header.jsp" %>

		<div class="main">

			<%@include file="main-left.jsp" %>
			
			<div class="main-middle">
				&nbsp;
				
				<div style="margin-top:-35px;">
				<!-- Announcement 的 News -->
				<h2>New Announcements</h2>
				<%
					if (announceList != null) {
						for (int i = 0; i < announceList.size() && i < 5; i++) {
				%>
				<div class="main-news">
					&nbsp; <img class="news-avatar"
						src=<%="\"" + announceList.get(i).getPurl() + "\""%> />
					<div class="news-pname">
						<a href=<%="announcement.jsp?pid=" + announceList.get(i).getPID() %>><%=announceList.get(i).getProjectName()%></a>
					</div>
					<div class="news-time">
						<a><%=announceList.get(i).getDate()%></a>
					</div>
					<div class="news-content">
						<textarea class="news-content-words" disabled="disabled";><%=announceList.get(i).getContent()%></textarea>
					</div>
				</div>
				<%
					}
					}
					
				%>
				
				</div>
				
				<div>
				<h2>New Documentations</h2>
				<!-- Documentation 的 News -->
				<%
					if (docList != null) {
						for (int i = 0; i < docList.size() && i < 5; i++) {
				%>
				<div class="main-news">
					&nbsp; <img class="news-avatar"
						src=<%="\"" + docList.get(i).getPurl() + "\""%> />
					<div class="news-pname">
						<a href=<%="documentation.jsp?pid=" + docList.get(i).getPID() %>><%=docList.get(i).getProjectName()%></a>
					</div>
					<div class="news-time">
						<a><%=docList.get(i).getDate()%></a>
					</div>
					<div class="news-content">
						<textarea class="news-content-words" disabled="disabled";><%=docList.get(i).getContent()%></textarea>
					</div>
				</div>
				<%
					}
					}
				%>
				
				</div>
				<div>
				<h2>new Sharings</h2>
				<!-- Sharing 的 News -->
				<%
					if (sharingList != null) {
						for (int i = 0; i < sharingList.size() && i < 5; i++) {
				%>
				<div class="main-news">
					&nbsp; <img class="news-avatar"
						src=<%="\"" + sharingList.get(i).getPurl() + "\""%> />
					<div class="news-pname">
						<a href=<%="sharing.jsp?pid=" + sharingList.get(i).getPID() %>><%=sharingList.get(i).getProjectName()%></a>
					</div>
					<div class="news-time">
						<a><%=sharingList.get(i).getDate()%></a>
					</div>
					<div class="news-content">
						<textarea class="news-content-words" disabled="disabled";><%=sharingList.get(i).getContent()%></textarea>
					</div>
				</div>
				<%
					}
					}
				%>
				</div>
				<div>
				<h2>New Tasks</h2>
				<!-- Task 的 News -->
				<%
					if (taskList != null) {
						for (int i = 0; i < taskList.size() && i < 5; i++) {
				%>
				<div class="main-news">
					&nbsp; <img class="news-avatar"
						src=<%="\"" + taskList.get(i).getPurl() + "\""%> />
					<div class="news-pname">
						<a href=<%="task.jsp?pid=" + taskList.get(i).getPID() %>><%=taskList.get(i).getProjectName()%></a>
					</div>
					<div class="news-time">
						<a><%=taskList.get(i).getDate()%></a>
					</div>
					<div class="news-content">
						<textarea class="news-content-words" disabled="disabled";><%=taskList.get(i).getContent()%></textarea>
					</div>
				</div>
				<%
					}
					}
					
				%>
				</div>

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
					<textarea id="1" class="msg-single" disabled="disabled"><%=msgList.get(i).getUserName() %> : <%=msgList.get(i).getContent()%></textarea>
				</div>
				<%
					}
					}
				%>
			</div>
		</div>
		<div class="bottom"></div>
	</div>
</body>

</html>
