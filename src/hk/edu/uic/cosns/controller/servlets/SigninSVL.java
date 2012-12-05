package hk.edu.uic.cosns.controller.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hk.edu.uic.cosns.model.dao.impl.UserDAOImpl;
import hk.edu.uic.cosns.model.vo.*;
/**
 * Servlet implementation class SigninSVL
 */
public class SigninSVL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SigninSVL() {
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
		
		String email = request.getParameter("email");
		String password = request.getParameter("password"); 
		//boolean rememberMe = Boolean.parseBoolean(request.getParameter("rememberMe"));
		
		User signinUser = new User();
		UserDAOImpl udi = new UserDAOImpl();
		// 匹配数据库，返回User对象
		try {
			signinUser = udi.signin(email, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (signinUser == null) {
			PrintWriter out = response.getWriter();
			out.println("<center><h1>Signin faild! please check your email and password!</h1></center>");
			out.println("<center><h2>Redirecting to index page ~~ </h2></center>");
			response.setHeader("Refresh","4;URL=./index.jsp");
			return;
			//response.sendRedirect("index.jsp");
			//request.setAttribute("SigninMsg", "Signin faild! please check your email and password!");
			//out.print()
			//request.getRequestDispatcher("index.jsp");//.forward(request, response);
			//return;
		}
		
		request.getSession().setAttribute("SigninUser", signinUser);
        request.getRequestDispatcher("ShowProjectListSVL").forward(request, response);
		//response.sendRedirect("ShowProjectListSVL");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*
		 * signin、signup、resetpwd、home、profile、project*3、signleproject、announcement、task、documentation、sharing
		 * 1. 接收 eamil pwd
		 * 2. 调用 signin（email， pwd）返回User对象
		 * 3. 跳转到home。jsp 或调用ShowProjectListSVL 
		 */
		doGet(request, response);
	}

}
