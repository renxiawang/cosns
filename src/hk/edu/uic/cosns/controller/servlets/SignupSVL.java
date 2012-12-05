package hk.edu.uic.cosns.controller.servlets;

import hk.edu.uic.cosns.model.dao.impl.UserDAOImpl;
import hk.edu.uic.cosns.model.vo.User;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignupSVL
 */
public class SignupSVL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupSVL() {
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
		// 接收email、pwd、fullname
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String fullName = request.getParameter("fullName");
		String avatarUrl = "./images/b.jpg";
		
		User user = null;

		
		
		UserDAOImpl udi = new UserDAOImpl();
		try {
			user = udi.signup(email, password, fullName, avatarUrl); 
			if (user == null) {
				PrintWriter out = response.getWriter();
				out.println("<center><h1>Signup Failed</h1></center>");
				out.println("<center><h2>Redirecting to index page ~~ </h2></center>");
				response.setHeader("Refresh","4;URL=./index.jsp");
				return;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.getSession().setAttribute("SigninUser", user);
        request.getRequestDispatcher("ShowProjectListSVL").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*
		 * signin、signup、resetpwd、home、profile、project*3、signleproject、announcement、task、documentation、sharing、setting
		 * 1. 接收 eamil pwd fullname
		 * 2. 调用 signup（email， pwd, fullname， avatarUrl） 成功则返回User对象
		 * 3. 调用 signinSVL（User.getEamil， User.getPasswd）
		 */
		doGet(request, response);
	}

}
