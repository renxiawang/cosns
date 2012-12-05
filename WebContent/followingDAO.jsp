<%@page import="hk.edu.uic.cosns.model.dao.impl.*" %>
<%
	UserRelationDAOImpl urdi = new UserRelationDAOImpl();
	List<User> followingList = null;
	try {
		followingList = urdi.findFollowing(signinUser.getUID());
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//request.setAttribute("FollowingList", followingList);
	
%>