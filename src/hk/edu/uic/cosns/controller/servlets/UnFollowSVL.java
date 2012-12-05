package hk.edu.uic.cosns.controller.servlets;

import hk.edu.uic.cosns.model.dao.impl.UserRelationDAOImpl;
import hk.edu.uic.cosns.model.vo.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UnFollowSVL
 */
public class UnFollowSVL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnFollowSVL() {
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
			response.sendRedirect("./jsp/index.jsp");
			return;
		}
		// 取得被关注者的User ID
		int userId = Integer.parseInt(request.getParameter("uid"));
		
		UserRelationDAOImpl urdi = new UserRelationDAOImpl();
		try {
			if(urdi.unFollow(signinUser.getUID(), userId) == false) {
				request.setAttribute("UnFollowMsg", "UnFollow Faild!");
				request.getRequestDispatcher("./jsp/result.jsp").forward(request, response);
				return;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("UnFollowMsg", "UnFollow success!");
		request.getRequestDispatcher("./jsp/result.jsp").forward(request, response);
		/*
		 * 根据uid1，uid2
		 * unFollow（）删除记录
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
