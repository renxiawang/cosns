package hk.edu.uic.cosns.controller.servlets;

import hk.edu.uic.cosns.model.dao.impl.AnnouncementDAOImpl;
import hk.edu.uic.cosns.model.vo.Announcement;
import hk.edu.uic.cosns.model.vo.Project;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowAnnounceSVL
 */
public class ShowAnnounceListSVL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAnnounceListSVL() {
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
		
		List<Announcement> announceList = null;
		
		AnnouncementDAOImpl adi = new AnnouncementDAOImpl();
		
		try {
			announceList = adi.findAnnounceByPID(project.getPID());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("AnnounceList", announceList);
		request.getRequestDispatcher("/announcement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * findAnnounceByPID()
		 * 返回AnnounceList，按时间取前20？
		 * 跳转到announcement。jsp （头部还得get project的session）
		 */
		doGet(request, response);
	}

}
