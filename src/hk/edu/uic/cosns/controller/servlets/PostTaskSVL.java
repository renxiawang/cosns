package hk.edu.uic.cosns.controller.servlets;

import hk.edu.uic.cosns.model.dao.impl.SharingDAOImpl;
import hk.edu.uic.cosns.model.dao.impl.TaskDAOImpl;
import hk.edu.uic.cosns.model.vo.User;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostTaskSVL
 */
public class PostTaskSVL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostTaskSVL() {
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
		String executorUIDs = "nmb";
		String content = request.getParameter("task_content");
		// 写入数据库
		TaskDAOImpl tdi = new TaskDAOImpl();
		try {
			if (tdi.postTask(user.getUID(), pid, executorUIDs, content) == false) {
				PrintWriter out = response.getWriter();
				out.println("<center><h1>Post Task faild!</h1></center>");
				out.println("<center><h2>Redirecting to announcement page ~~ </h2></center>");
				response.setHeader("Refresh","4;URL=./task.jsp?pid="+pid);
				return;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("111111111111");
		response.sendRedirect("task.jsp?pid="+pid);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
