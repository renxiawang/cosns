<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*,hk.edu.uic.cosns.model.vo.*,hk.edu.uic.cosns.model.dao.impl.*"%>
<%@include file="issignin.jsp" %>
<%
		User signinUser = (User) session.getAttribute("SigninUser");
		int pid = Integer.parseInt(request.getParameter("pid"));
		System.out.println(pid);
		DocumentationDAOImpl ddi = new DocumentationDAOImpl();
		List<Documentation> documentationList = ddi.findDocByPID(pid);
		
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
			<a href="announcement.jsp?pid=<%=pid %>"><img src="images/announcement-link.png" /></a>
			<a href="task.jsp?pid=<%=pid %>""><img src="images/task-link.png" /></a>
			<a href="documentation.jsp?pid=<%=pid %>""><img src="images/documentation-link1.png" /></a>
			<a href="sharing.jsp?pid=<%=pid %>""><img src="images/share-link.png" /></a>
			<a href="#""><img src="images/discussion-link.png" /></a>			
			</div>

		</div>
		<div class="main-middle">
			<div style="height:330px; margin-bottom:40px;">
				<form method="post" action="PostDocSVL">
				<input type="hidden" name="pid" value="<%=pid %>" />
					<div>
						<a>Title:</a>
						<input name="title" style="border: 3px black solid;"  type="text" />
					</div>
					<div>
					<a>Content:</a><br />
					<textarea name="Doc_Content" style="height:250px;width:435px; border: 3px black solid;" ></textarea>
					<input src="images/submit.png" style="margin-left:170px;" type="image" />
					</div>
				</form>
			</div>
			<hr />
			<%
			if (documentationList != null) {
				for (int i = 0; i < documentationList.size(); i++) { %>
				<div class="documentation" >
				<div style=" margin:-6px 0 0 80px;float:left;"><h3><%=documentationList.get(i).getTitle() %></h3></div>
				<div style=" margin:20px 0 0 175px;float:left; width:35px; overflow:hidden;"><%=documentationList.get(i).getPublisherID() %></div>
				<div style=" margin:20px 0 0 40px;float:left; width:35px; overflow:hidden;"><%=documentationList.get(i).getDate() %></div>
				<textarea style="width:410px;height:440px; margin:10px 0 0 14px; background-color:white; border:0px;" disabled="disabled"><%=documentationList.get(i).getContent() %></textarea>
				
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
