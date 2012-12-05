package hk.edu.uic.cosns.controller.servlets;

import hk.edu.uic.cosns.model.dao.impl.DocumentationDAOImpl;
import hk.edu.uic.cosns.model.dao.impl.SharingDAOImpl;
import hk.edu.uic.cosns.model.vo.Documentation;
import hk.edu.uic.cosns.model.vo.Project;
import hk.edu.uic.cosns.model.vo.Sharing;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowSharing
 */
public class ShowSharingSVL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowSharingSVL() {
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
		List<Sharing> sharingList = null;
		
		SharingDAOImpl ddi = new SharingDAOImpl();
		
		try {
			sharingList = ddi.findSharingByPID(project.getPID());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("SharingList", sharingList);
		request.getRequestDispatcher("./jsp/documentation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
