package hk.edu.uic.cosns.controller.servlets;

import hk.edu.uic.cosns.model.dao.impl.RoleDAOImpl;
import hk.edu.uic.cosns.model.dao.impl.UserRelationDAOImpl;
import hk.edu.uic.cosns.model.vo.User;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FollowSVL
 */
public class FollowSVL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FollowSVL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		// 取得自己的User对象
		User signinUser = (User)request.getSession().getAttribute("SigninUser");
		if (signinUser == null) {
			PrintWriter out = response.getWriter();
			out.println("<center><h1>Please signin!</h1></center>");
			out.println("<center><h2>Redirecting to index page ~~ </h2></center>");
			response.setHeader("Refresh","2;URL=./index.jsp");
			return;
		}
		// 取得被关注者的User ID
		int userId = Integer.parseInt(request.getParameter("uid"));
		
		UserRelationDAOImpl urdi = new UserRelationDAOImpl();
		try {
			if(urdi.follow(signinUser.getUID(), userId) == false) {
				PrintWriter out = response.getWriter();
				out.println("<center><h1>Follow faild!</h1></center>");
				out.println("<center><h2>Rturnning back ~~ </h2></center>");
				response.sendRedirect(request.getHeader("referer"));
				return;
			} else {
				PrintWriter out = response.getWriter();
				out.println("<center><h1>Follow successfully!</h1></center>");
				out.println("<center><h2>Rturnning back ~~ </h2></center>");
				request.getSession().setAttribute("UserList", null);
				response.setHeader("Refresh","2;URL=./find-people.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//request.setAttribute("FollowMsg", "Follow success!");
		//request.getRequestDispatcher("./result.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*
		 * 根据uid1，uid2插入新record，建立联系 follow（）
		 * 返回boolean
		 */
	}

}
