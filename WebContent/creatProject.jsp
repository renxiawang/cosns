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
	List<Message> msgList = (LinkedList<Message>) session
			.getAttribute("MsgList");
%>


<%@include file="followingDAO.jsp" %>
<%@include file="header.jsp" %>

	
	<div class="main">
	
		<%@include file="main-left.jsp" %>
		
		<div class="main-middle">
			<div  style="height:300px; background-image:url('images/creatProject.png');background-repeat:no-repeat;">
			<form method="post" action="CreateProjectSVL">
			<input name="ProjectName" type="text" style="height: 23px; width: 153px;margin:22px 0 0 157px; border:0px;" /><br />
			<input name="Projectlogo" type="text"style="height: 23px; width: 153px;margin:16px 0 0 157px; border:0px" value="./images/c.jpg" /><br />
			<textarea name="Description" style="width: 240px;height:120px; margin:19px 0 0 160px; border:0px;" ></textarea>
			<br /><br />
			<input type="image" style="margin-left:150px;" src="images/submit.png" />
			</form>
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
