package hk.edu.uic.cosns.controller.servlets;

import hk.edu.uic.cosns.model.dao.impl.ProjectDAOImpl;
import hk.edu.uic.cosns.model.dao.impl.RoleDAOImpl;
import hk.edu.uic.cosns.model.vo.Project;
import hk.edu.uic.cosns.model.vo.User;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateProjectSVL
 */
public class CreateProjectSVL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateProjectSVL() {
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
		Project project = null;
		String projectName = request.getParameter("ProjectName");
		String description = request.getParameter("Description");
		String Projectlogo = request.getParameter("Projectlogo");
		ProjectDAOImpl pdi = new ProjectDAOImpl();
		try {
			project = pdi.createProject(signinUser.getUID(), projectName, description, Projectlogo);
			if (project == null) {
				PrintWriter out = response.getWriter();
				out.println("<center><h1>Creat Project failed</h1></center>");
				out.println("<center><h2>Redirecting to home page ~~ </h2></center>");
				response.setHeader("Refresh","4;URL=./home.jsp");
				return;
			}
			//建立role记录
			RoleDAOImpl role = new RoleDAOImpl();
			role.insertRole(signinUser.getUID(),project.getPID(),1, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.getSession().setAttribute("SigninUser", signinUser);
        request.getRequestDispatcher("ShowProjectListSVL").forward(request, response);
        
		//response.sendRedirect("announcement.jsp"+"?pid="+project.getPID());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
