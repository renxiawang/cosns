package hk.edu.uic.cosns.controller.servlets;

import hk.edu.uic.cosns.model.dao.impl.AnnouncementDAOImpl;
import hk.edu.uic.cosns.model.dao.impl.DocumentationDAOImpl;
import hk.edu.uic.cosns.model.vo.Announcement;
import hk.edu.uic.cosns.model.vo.Documentation;
import hk.edu.uic.cosns.model.vo.Project;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowDocListSVL
 */
public class ShowDocListSVL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowDocListSVL() {
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
		
		Project project = (Project)request.getAttribute("Project");
		List<Documentation> docList = null;
		
		DocumentationDAOImpl ddi = new DocumentationDAOImpl();
		
		try {
			docList = ddi.findDocByPID(project.getPID());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("DocList", docList);
		request.getRequestDispatcher("./jsp/documentation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*
		 * findDocByPID()
		 * 返回Doc List 取前20
		 * 跳转到document。jsp
		 */
		doGet(request, response);
	}

}
