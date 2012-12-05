package hk.edu.uic.cosns.controller.servlets;

import hk.edu.uic.cosns.model.dao.impl.DocumentationDAOImpl;
import hk.edu.uic.cosns.model.dao.impl.MessageDAOImpl;
import hk.edu.uic.cosns.model.dao.impl.MsgBoardDAOImpl;
import hk.edu.uic.cosns.model.vo.Message;
import hk.edu.uic.cosns.model.vo.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostMsgSVL
 */
public class PostMsgSVL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostMsgSVL() {
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
		//8888
		int mbid;
		if (request.getParameter("mbid") != null) {
			mbid = Integer.parseInt(request.getParameter("mbid"));
		} else { 
			mbid = user.getMBID();
		}
		//8888
		String content = request.getParameter("msg_content");
		List<Message> msgList = null;
		// 写入数据库
		MsgBoardDAOImpl mbdi = new MsgBoardDAOImpl();
		MessageDAOImpl msgdi = new MessageDAOImpl();
		try {
			if (mbdi.postMsg(user.getUID(), content, mbid) == false) {
				PrintWriter out = response.getWriter();
				out.println("<center><h1>Post Message faild!</h1></center>");
				out.println("<center><h2>Redirecting to Home page ~~ </h2></center>");
				response.setHeader("Refresh","3;URL=./home.jsp");
				return;
			}
			if (mbid == user.getMBID()) {
				msgList = msgdi.findUserMsgByMBID(user.getMBID());
			} 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (mbid == user.getMBID()) {
			request.getSession().setAttribute("MsgList", msgList);
		} 
		response.sendRedirect(request.getHeader("referer"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
