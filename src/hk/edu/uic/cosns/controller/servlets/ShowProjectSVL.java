package hk.edu.uic.cosns.controller.servlets;

import hk.edu.uic.cosns.model.dao.impl.ProjectDAOImpl;
import hk.edu.uic.cosns.model.vo.Project;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowProjectSVL
 */
public class ShowProjectSVL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowProjectSVL() {
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
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		ProjectDAOImpl pdi = new ProjectDAOImpl();
		Project project = null;
		
		try {
			project = pdi.findProjectByID(pid);
			if (project == null) {
				request.setAttribute("ProjectMsg", "Show project faild!");
				request.getRequestDispatcher("./jsp/result.jsp").forward(request, response);
				return;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("ProjectMsg", "Sho project seccess!");
		request.setAttribute("Project", project);
		request.getRequestDispatcher("ShowAnnounceListSVL").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*
		 * findProjectByID() 返回project对象
		 * 调用ShowAnnounceListSVL  
		 */
	}

}
