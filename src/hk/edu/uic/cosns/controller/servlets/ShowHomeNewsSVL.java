package hk.edu.uic.cosns.controller.servlets;

import hk.edu.uic.cosns.model.dao.impl.AnnouncementDAOImpl;
import hk.edu.uic.cosns.model.dao.impl.DocumentationDAOImpl;
import hk.edu.uic.cosns.model.dao.impl.NewsDAOImpl;
import hk.edu.uic.cosns.model.dao.impl.ProjectDAOImpl;
import hk.edu.uic.cosns.model.dao.impl.RoleDAOImpl;
import hk.edu.uic.cosns.model.dao.impl.SharingDAOImpl;
import hk.edu.uic.cosns.model.dao.impl.TaskDAOImpl;
import hk.edu.uic.cosns.model.vo.Announcement;
import hk.edu.uic.cosns.model.vo.Documentation;
import hk.edu.uic.cosns.model.vo.News;
import hk.edu.uic.cosns.model.vo.Project;
import hk.edu.uic.cosns.model.vo.Sharing;
import hk.edu.uic.cosns.model.vo.Task;
import hk.edu.uic.cosns.model.vo.User;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowHomeNewsSVL
 */
public class ShowHomeNewsSVL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowHomeNewsSVL() {
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
		// 获取登录用户对象/Project对象
		User signinUser = (User)request.getSession().getAttribute("SigninUser");
		List<News> announceList = null;
		List<News> docList = null;
		List<News> sharingList = null;
		List<News> taskList = null;
		
		int[] allProjectArray = null;
		// 验证用户是否登录
		if (signinUser == null) {
			response.sendRedirect("./index.jsp");
			return;
		}
		// 数据库操作
		NewsDAOImpl ndi = new NewsDAOImpl();
		RoleDAOImpl rdi = new RoleDAOImpl();
		
		// 通过用户ID查找所有相关PID
		try {
			allProjectArray = rdi.findAllProjectIDs(signinUser.getUID());
			if (allProjectArray != null) {
				announceList = ndi.findNewAnnounceByPIDs(allProjectArray);
				docList = ndi.findNewDocByPIDs(allProjectArray);
				sharingList = ndi.findNewSharingByPIDs(allProjectArray);
				taskList = ndi.findNewTaskByPIDs(allProjectArray);
			}
			// 排序？？？
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 把对应的project跟announce等并起来？
		//

		System.out.println("HomeNewsSVL");
		request.getSession().setAttribute("AnnounceList", announceList);
		request.getSession().setAttribute("DocList", docList);
		request.getSession().setAttribute("SharingList", sharingList);
		request.getSession().setAttribute("TaskList", taskList);
		//request.setAttribute("AllNews", allNews);
		request.getRequestDispatcher("ShowMsgBoardListSVL").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*
		 *  通过用户ID查找所有相关PID findAllProjectIDs
		 *  通过PIDs分别查找 findAnnounceByPIDs（）、findDocByPIDs（）、findSharingByPIDs（）、findTaskByPIDs（） 各取前10
		 *  按时间排序取前20 ？？？各种信息各是不一致 - -   
		 *  跳转至home。jsp 或继续调用ShowMsgBoardSVL？             
		 */
		doGet(request, response);
	}

}
