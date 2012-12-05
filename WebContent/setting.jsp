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

<%@include file="header.jsp" %>


		<div class="main">

			<%@include file="main-left.jsp" %>
		<div class="main-middle">
			<div  style="height:200px; background-image:url('images/setting.png');background-repeat:no-repeat;">
			<form method="post" action="UpdateUserProfileSVL">
			<input name="Email" type="text" style="height: 23px; width: 153px;margin:24px 0 0 157px; border:0px;" /><br />
			<input name="Name" type="text"style="height: 23px; width: 153px;margin:15px 0 0 157px; border:0px"  /><br />
			<input name="Avatar" type="text"style="height: 23px; width: 153px;margin:13px 0 0 157px; border:0px"  /><br /><br /><br />
			<input type="image" style="margin-left:150px;" src="images/submit.png" />
			</form>
			</div>


			

		</div>
		<div class="main-right">
		<div class="msg-input">
			<form method="post" action="ssadasda">
			<textarea name="msgInput" style="height:125px;width:210px; margin:6px 0 10px 8px;border:0px;"cols="20" rows="2"></textarea>
			<input type="image" src="images/pop.png" name="pop" style="float:right;" />
			</form>
		</div>
		<div class="msg-content">
			<textarea id="1" class="msg-single">XXXXXX: sadasdsa</textarea>
		</div>
		<div class="msg-content">
			<textarea id="1" class="msg-single">XXXXXX: sadasdsa</textarea>
		</div>


		</div>
	</div>
	<div class="bottom"></div>
</div>
</body>

</html>
