<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="issignin.jsp" %>
<%@page import="java.util.*,hk.edu.uic.cosns.model.vo.*"%>
<%
	User signinUser = (User) session.getAttribute("SigninUser");
	List<Project> myProjectList = (LinkedList<Project>) session
			.getAttribute("MyProjectList");
	List<Project> joinedProjectList = (LinkedList<Project>) session
			.getAttribute("JoinedProjectList");
	List<Project> favProjectList = (LinkedList<Project>) session
			.getAttribute("FavProjectList");
	List<Message> msgList = (LinkedList<Message>) session
			.getAttribute("MsgList");
	List<Project> resultList = (LinkedList<Project>) session.getAttribute("ProjectList");
%>
<%@include file="followingDAO.jsp" %>
<%@include file="header.jsp" %>

	<div class="main">
	
		<%@include file="main-left.jsp" %>
		<div class="main-middle">
				<div>
					
					
					<form method="post" action="FindUserSVL">
						<input name="userName" onclick="this.form.userName.value=''" value="Find User Here" type="text" style="margin-left:100px; height: 27px; width: 130px;  float: left" />
						<input type="image" src="images/search-button.png" " />
					</form>
					<form method="post" action="FindProjectSVL">
						<input name="projectName" onclick="this.form.projectName.value=''" value="Find Project Here" type="text" style="margin-left:100px; height: 27px; width: 130px;  float: left" />
						<input type="image" src="images/search-button.png"  />
					</form>
					
					
					
					
					
				</div>
				<hr />
			<%
			if (resultList!=null) {
				for (int i = 0; i < resultList.size(); i++) { %>
					<div  style="height:70px;">&nbsp;
					<img class="news-avatar" style="margin-top:5px;" src=<%=resultList.get(i).getPUrl() %> />
					
					<div style="margin:-10px 0 0 100px;">
						<div style="float:left;width:200px;"><h3><a href=<%="announcement.jsp?pid=" + resultList.get(i).getPID() %>><%=resultList.get(i).getProjectName() %></a></h3></div>
						<div style="float:right;"><a href=<%="JoinProjectSVL?pid=" + resultList.get(i).getPID() %>><img style="margin-right:50px" src="images/follow.png" /></a>	</div>
					</div>
					
				</div>
				<%}
			}
			%>
			
			
			<hr />
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
