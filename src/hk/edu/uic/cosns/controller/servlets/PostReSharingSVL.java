package hk.edu.uic.cosns.controller.servlets;

import hk.edu.uic.cosns.model.dao.impl.MsgBoardDAOImpl;
import hk.edu.uic.cosns.model.dao.impl.ReSharingDAOImpl;
import hk.edu.uic.cosns.model.vo.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostReSharing
 */
public class PostReSharingSVL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostReSharingSVL() {
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
		int sharingID = Integer.parseInt(request.getParameter("sharingID"));
		//String content = request.getParameter("content");
		// 写入数据库
		ReSharingDAOImpl rsdi = new ReSharingDAOImpl();
		try {
			if (rsdi.postResharing(user.getUID(), pid, sharingID) == false) {
				request.setAttribute("PostResharingMsg", "Post resharing faild!");
				request.getRequestDispatcher("./jsp/result.jsp");
				return;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("PostResharingMsg", "Post resharing success");
		request.getRequestDispatcher("./jsp/result.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
