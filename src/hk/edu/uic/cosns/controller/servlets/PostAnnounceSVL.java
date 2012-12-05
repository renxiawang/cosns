package hk.edu.uic.cosns.controller.servlets;

import hk.edu.uic.cosns.model.dao.impl.AnnouncementDAOImpl;
import hk.edu.uic.cosns.model.vo.User;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostAnnounceSVL
 */
public class PostAnnounceSVL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostAnnounceSVL() {
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
		// 获取参数
		User user = (User)request.getSession().getAttribute("SigninUser");
		int pid = Integer.parseInt(request.getParameter("pid"));
		String content = request.getParameter("announcement_content");
		// 写入数据库
		AnnouncementDAOImpl adi = new AnnouncementDAOImpl();
		try {
			if (adi.postAnnouncement(user.getUID(), pid, content) == false) {
				PrintWriter out = response.getWriter();
				out.println("<center><h1>Post Announcement faild!</h1></center>");
				out.println("<center><h2>Redirecting to announcement page ~~ </h2></center>");
				response.setHeader("Refresh","4;URL=./announcement.jsp?pid="+pid);
				return;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("announcement.jsp?pid="+pid);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
