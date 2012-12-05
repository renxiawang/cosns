<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*,hk.edu.uic.cosns.model.vo.*"%>
<%@include file="issignin.jsp" %>
<%
	User signinUser = (User) session.getAttribute("SigninUser");
	List<Project> myProjectList = (LinkedList<Project>) session
			.getAttribute("MyProjectList");
%>

<%@include file="header.jsp" %>


		<div class="project-main">

			<div class="project-left">
				<div style="height: 200px;">
					<img src="images/b.jpg" height="145px" width="145px"
						style="margin: 5px 0 0 42px;" />
				</div>
				<a href="my-created-project.jsp"><img src="images/myCP1.png" />
				</a> <a href="my-joined-project.jsp"><img src="images/myJP.png" />
				</a> <a href="my-fav-project.jsp"><img src="images/myFP.png" />
				</a>
				<div
					style="height: 126px; width: 251px; background-image: url('images/search.png')">
					<form method="post" action="ddd">
						<input name="search" type="text"
							style="margin: 88px 5px 0 25px; height: 27px; width: 130px; border: 0px; float: left" />
						<input type="image" src="images/search-button.png"
							style="margin-top: 84px;" />
					</form>
				</div>
			</div>
			<div class="project-right">
				<img src="images/mrp.png" />
				<%
					if (myProjectList != null) {
						for (int i = 0; i < myProjectList.size(); i++) {
				%>
				<div class="project-info">
					<img src=<%=myProjectList.get(i).getPUrl()%> height="120px"
						width="120px" style="margin: 28px 0 0 27px; float: left" />
					<div style="width: 480px; height: 190px; float: right">
						<div style="margin: 30px 0 0 90px;"><%=myProjectList.get(i).getUpdateTime()%></div>
						<div style="margin: 24px 0 0 40px;"><%=signinUser.getFullName()%></div>
						<div style="margin: 23px 0 0 70px; height: 70px; overflow: hidden;"><%=myProjectList.get(i).getDescription()%></div>
						<div style="width:50px;margin:-15px 0 0 -155px;text-align:center;" ><a href="announcement.jsp?pid=<%=myProjectList.get(i).getPID() %>"><%=myProjectList.get(i).getProjectName() %></a></div>
							
					</div>
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
