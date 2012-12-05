<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*,hk.edu.uic.cosns.model.vo.*,hk.edu.uic.cosns.model.dao.impl.*"%>
<%@include file="issignin.jsp" %>
<%
		User signinUser = (User) session.getAttribute("SigninUser");
		int pid = Integer.parseInt(request.getParameter("pid"));
		System.out.println(pid);
		AnnouncementDAOImpl announcements = new AnnouncementDAOImpl();
		List<Announcement> announcementList = announcements.findAnnounceByPID(pid);
		
		ProjectDAOImpl pdi = new ProjectDAOImpl();
		Project project = pdi.findProjectByID(pid);
		
		MessageDAOImpl msgdi = new MessageDAOImpl();
		List<Message> msgList = null;
		msgList = msgdi.findProjectMsgByMBID(project.getMBID());
%>

<%@include file="header.jsp" %>
	
	<div class="main">
	
		<div class="announcement-left">
			<div style="height:160px;">
				<img src=<%=project.getPUrl() %> height="145px" width="145px" style="margin:5px 0 0 -26px;" />
			</div>
			
			<div class="announcement-pinfo">
				<p>
					<a>Project Name:<%=project.getProjectName() %></a><br />
					<a>Creat Time:<%=project.getUpdateTime().substring(0,19) %></a><br />
					<a>Member Num:<%=project.getMemberCount() %></a> <br />
					<a>Favourite Num:<%=project.getFavCount() %></a>
				</p>

			</div>
			<div >
			<a href="announcement.jsp?pid=<%=pid %>"><img src="images/announcement-link1.png" /></a>
			<a href="task.jsp?pid=<%=pid %>""><img src="images/task-link.png" /></a>
			<a href="documentation.jsp?pid=<%=pid %>""><img src="images/documentation-link.png" /></a>
			<a href="sharing.jsp?pid=<%=pid %>""><img src="images/share-link.png" /></a>
			<a href="#"><img src="images/discussion-link.png" /></a>			
			</div>

		</div>

		<div class="main-middle" >
			<div class="announcement-input" >
				<form method="post" action="PostAnnounceSVL">
				<input type="hidden" name="pid" value="<%=pid %>" />
				<textarea name="announcement_content" style="height:120px;width:420px; margin:13px 0 0 10px; border:0px; "></textarea>
				<input type="image" style="float:right; margin-top:25px;" src="images/announce.png" />
				</form>
			</div>
			<%
			if (announcementList != null) {
				for (int i = 0; i < announcementList.size(); i++ ) { %>
					<div class="announcement">
						<textarea style="width:420px;height:105px;border:0px;background-color:white;margin:20px 0 0 10px; " disabled="disabled"><%=announcementList.get(i).getContent() %></textarea>
						
					
					</div>
				<%}
			}
			%>

		</div>
		<div class="main-right">
		<div class="msg-input">
			<form method="post" action=<%="PostMsgSVL?mbid=" + project.getMBID()%> >
			<textarea name="msg_content" style="height:125px;width:210px; margin:6px 0 10px 8px;border:0px;"cols="20" rows="2"></textarea>
			<input type="image" src="images/pop.png" name="pop" style="float:right;" />
			</form>
		</div>
		<% if (msgList != null) {
			for (int i = 0; i < msgList.size(); i++) { %>
				<div class="msg-content">
					<textarea id="1" class="msg-single" disabled="disabled"><%=msgList.get(i).getUserName() %>:<%=msgList.get(i).getContent() %></textarea>
				</div>
			<%}
		}
		%>
		</div>
	</div>
	<div class="bottom"></div>
</div>
</body>

</html>
