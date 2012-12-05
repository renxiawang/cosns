package hk.edu.uic.cosns.controller.servlets;

import hk.edu.uic.cosns.model.dao.impl.NewsDAOImpl;
import hk.edu.uic.cosns.model.dao.impl.RoleDAOImpl;
import hk.edu.uic.cosns.model.vo.News;
import hk.edu.uic.cosns.model.vo.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowProfileNewsSVL
 */
public class ShowProfileNewsSVL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowProfileNewsSVL() {
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
		//int uid = Integer.parseInt(request.getParameter("uid"));
		List<News> myAnnounceList = null;
		List<News> myDocList = null;
		List<News> mySharingList = null;
		List<News> myTaskList = null;

		int[] myProjectArray = null;
		// 验证用户是否登录
		if (signinUser == null) {
			//response.sendRedirect("./jsp/index.jsp");
			PrintWriter out = response.getWriter();
			out.println("<center><h1>Please Signin!</h1></center>");
			out.println("<center><h2>Redirecting to index page ~~ </h2></center>");
			response.setHeader("Refresh","4;URL=index.jsp");
			return;
		}
		// 数据库操作
		NewsDAOImpl ndi = new NewsDAOImpl();
		RoleDAOImpl rdi = new RoleDAOImpl();
		
		// 通过用户ID查找所有相关PID
		try {
			myProjectArray = rdi.findMyProjectIDs(signinUser.getUID(), 1);
			if (myProjectArray != null) {
				myAnnounceList = ndi.findNewAnnounceByPIDs(myProjectArray);
				myDocList = ndi.findNewDocByPIDs(myProjectArray);
				mySharingList = ndi.findNewSharingByPIDs(myProjectArray);
				myTaskList = ndi.findNewTaskByPIDs(myProjectArray);
			}
			// 排序？？？
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 把对应的project跟announce等并起来？
		//

		System.out.println("ProfileNewsSVL");
		request.getSession().setAttribute("MyAnnounceList", myAnnounceList);
		request.getSession().setAttribute("MyDocList", myDocList);
		request.getSession().setAttribute("MySharingList", mySharingList);
		request.getSession().setAttribute("MyTaskList", myTaskList);
		response.sendRedirect("profile.jsp");
		//request.setAttribute("AllNews", allNews);
		//request.getRequestDispatcher("ShowMsgBoardListSVL").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*
		 * 还是觉得这个profile设计得太风骚了……不就跟home一样么……
		 * 要不一样的话就：
		 * findDocByUID（）
		 * findAnnounceByUID（）
		 * findSharingByUID（）
		 * findTaskByUID（）
		 * 取前20
		 * 调用ShowMsgBoardListSVL 或跳转至 profile。jsp；应该是前者，因为一个servlet里面无法调用多个srvlet
		 * 那就只能一环扣一环……
		 */
		doGet(request, response);
	}

}
