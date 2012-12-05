package hk.edu.uic.cosns.controller.servlets;

import hk.edu.uic.cosns.model.dao.impl.RoleDAOImpl;
import hk.edu.uic.cosns.model.vo.User;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinProjectSVL
 */
public class JoinProjectSVL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinProjectSVL() {
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
		// 接收参数
		User signinUser = (User)request.getSession().getAttribute("SigninUser");
		if (signinUser == null) {
			PrintWriter out = response.getWriter();
			out.println("<center><h1>Please signin!</h1></center>");
			out.println("<center><h2>Redirecting to index page ~~ </h2></center>");
			response.setHeader("Refresh","2;URL=./index.jsp");
			return;
		}
		int pid = Integer.parseInt(request.getParameter("pid"));
		RoleDAOImpl rdi = new RoleDAOImpl();
		// 建立fav关系，更新project的FavCount记录
		try {
			if (rdi.insertRole(signinUser.getUID(), pid, 2, false) == false) {
				PrintWriter out = response.getWriter();
				out.println("<center><h1>Join in faild!</h1></center>");
				out.println("<center><h2>Rturnning back ~~ </h2></center>");
				response.sendRedirect(request.getHeader("referer"));
				return;
			} else {
				PrintWriter out = response.getWriter();
				out.println("<center><h1>Join in successfully!</h1></center>");
				out.println("<center><h2>Rturnning back ~~ </h2></center>");
				request.getSession().setAttribute("ProjectList", null);
				response.setHeader("Refresh","2;URL=./find-project.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//request.setAttribute("JoinedMsg", "Join success");
		//request.getRequestDispatcher("./jsp/result.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
