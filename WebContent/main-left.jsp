<div class="main-left">
				<div style="height: 180px;">
					<img src="<%=signinUser.getAvatarUrl()%>" height="145px"
						width="145px" style="margin: 5px 0 0 -24px;" />

					<h2>
						<a href="profile.jsp?uid=<%=signinUser.getUID() %>"><%=signinUser.getFullName()%></a>
					</h2>
				</div>
				<div style="height: 145px;">
				<div style="position:absolute;margin:25px 0 0 180px;">
			<a href="my-created-project.jsp">more...</a>
			</div>
					<ul>
						<%
							if (myProjectList != null) {
								for (int i = 0; i < myProjectList.size() && i < 3; i++) {
						%>
						<li><img
							src=<%="\"" + myProjectList.get(i).getPUrl() + "\""%>
							width="65px" height="65px"
							title=<%="\"" + myProjectList.get(i).getProjectName()
							+ "\""%> />
						</li>
						<%
							}
							}
						%>
					</ul>

					<ul
						style="margin: -10px 0 0 -30px; height: 17px; overflow: hidden;">
						<%
							if (myProjectList != null) {
								for (int i = 0; i < myProjectList.size() && i < 3; i++) {
						%>
						<li style="height: 17px; overflow: hidden;"><a href=<%="announcement.jsp?pid=" + myProjectList.get(i).getPID() %>><%=myProjectList.get(i).getProjectName() %></a>
						</li>
						<%
							}
							}
						%>
					</ul>

				</div>
				<div style="height: 140px;">
				<div style="position:absolute;margin:25px 0 0 180px;">
			<a href="my-joined-project.jsp">more...</a>
			</div>
					<ul>
						<%
							if (joinedProjectList != null) {
								for (int i = 0; i < joinedProjectList.size() && i < 3; i++) {
						%>
						<li><img
							src=<%="\"" + joinedProjectList.get(i).getPUrl() + "\""%>
							width="65px" height="65px"
							title=<%="\"" + joinedProjectList.get(i).getProjectName()
							+ "\""%> />
						</li>
						<%
							}
							}
						%>
					</ul>

					<ul
						style="margin: -10px 0 0 -30px; height: 17px; overflow: hidden;">
						<%
							if (joinedProjectList != null) {
								for (int i = 0; i < joinedProjectList.size() && i < 3; i++) {
						%>
						<li style="height: 17px; overflow: hidden;"><a href=<%="announcement.jsp?pid=" + joinedProjectList.get(i).getPID() %>><%=joinedProjectList.get(i).getProjectName()%></a>
						</li>
						<%
							}
							}
						%>
					</ul>

				</div>

				<div style="height: 150px;">
				<div style="position:absolute;margin:25px 0 0 180px;">
			<a href="my-fav-project.jsp">more...</a>
			</div>
					<ul>
						<%
							if (favProjectList != null) {
								for (int i = 0; i < favProjectList.size() && i < 3; i++) {
						%>
						<li><img
							src=<%="\"" + favProjectList.get(i).getPUrl() + "\""%>
							width="65px" height="65px"
							title=<%="\"" + favProjectList.get(i).getProjectName()
							+ "\""%> />
						</li>
						<%
							}
							}
						%>
					</ul>
					<ul
						style="margin: -10px 0 0 -30px; height: 17px; overflow: hidden;">
						<%
							if (favProjectList != null) {
								for (int i = 0; i < favProjectList.size() && i < 3; i++) {
						%>
						<li style="height: 17px; overflow: hidden;"><a href=<%="announcement.jsp?pid=" + favProjectList.get(i).getPID() %>><%=favProjectList.get(i).getProjectName()%></a>
						</li>
						<%
							}
							}
						%>
					</ul>

				</div>
				
				<div style="height:200px;">
				<ul style="margin-top:30px;">
				<%
					if (followingList != null) {
						for (int i = 0; i < followingList.size() && i < 3; i++) { %>
							<li>
							<img src=<%=followingList.get(i).getAvatarUrl() %> width="65px" height="65px" title=<%=followingList.get(i).getFullName() %>/>
							</li>
						<%}
					}
				%>
					
				</ul>
				<ul style="margin:-10px 0 0 -30px;height:17px;;">
					<%
					 if (followingList != null) {
						 for (int i = 0; i < followingList.size() && i < 3; i++) { %>
							 <li style="height: 17px;overflow:hidden;" >
								<a href=<%="profile.jsp?uid=" + followingList.get(i).getUID() %> ><%=followingList.get(i).getFullName() %></a>
								</li>
						<% }
					 }
					%>
					
					
				</ul>

			</div>
				

			</div>