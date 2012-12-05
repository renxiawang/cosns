package hk.edu.uic.cosns.controller.servlets;

import hk.edu.uic.cosns.model.dao.impl.ReSharingDAOImpl;
import hk.edu.uic.cosns.model.dao.impl.SharingDAOImpl;
import hk.edu.uic.cosns.model.vo.User;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostSharing
 */
public class PostSharingSVL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostSharingSVL() {
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
		int type = Integer.parseInt(request.getParameter("type"));
		String content = request.getParameter("sharing_content");
		// 写入数据库
		SharingDAOImpl sdi = new SharingDAOImpl();
		try {
			if (sdi.postSharing(pid, user.getUID(), content, type) == false) {
				PrintWriter out = response.getWriter();
				out.println("<center><h1>Post Sharing faild!</h1></center>");
				out.println("<center><h2>Redirecting to announcement page ~~ </h2></center>");
				response.setHeader("Refresh","4;URL=./sharing.jsp?pid="+pid);
				return;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("sharing.jsp?pid="+pid);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
