package hk.edu.uic.cosns.controller.servlets;

import hk.edu.uic.cosns.model.dao.impl.MessageDAOImpl;
import hk.edu.uic.cosns.model.dao.impl.MsgBoardDAOImpl;
import hk.edu.uic.cosns.model.dao.impl.ProjectDAOImpl;
import hk.edu.uic.cosns.model.dao.impl.UserDAOImpl;
import hk.edu.uic.cosns.model.vo.Message;
import hk.edu.uic.cosns.model.vo.MsgBoard;
import hk.edu.uic.cosns.model.vo.Project;
import hk.edu.uic.cosns.model.vo.User;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowMsgBoardList
 */
public class ShowMsgBoardListSVL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowMsgBoardListSVL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 判断是user还是project ------------- 此serlet仅支持user
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		User signinUser = (User)request.getSession().getAttribute("SigninUser"); 
		int uid = signinUser.getUID();
		//int pid = Integer.parseInt(request.getParameter("pid"));
		MessageDAOImpl msgdi = new MessageDAOImpl();
		List<Message> msgList = null;
		
		if (uid != 0) {
			try {
				msgList = msgdi.findUserMsgByMBID(signinUser.getMBID());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
		// 如果是Project则获取projct对象
//			ProjectDAOImpl pdi = new ProjectDAOImpl();
//			Project crrentProject = null;
//			try {
//				crrentProject = pdi.findProjectByID(pid);
//				msgList = msgdi.findProjectMsgByMBID(crrentProject.getMBID());
//			} catch (Exception e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
		}

		System.out.println("MsgBoardSVL");
		request.getSession().setAttribute("MsgList", msgList);
		//request.getRequestDispatcher("/home.jsp").forward(request, response);
		response.sendRedirect("home.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*
		 * 通过User或Project的MBID属性 findMsgBoardByMBID（） 应该是一个List？
		 * 通过MsgBoard的insertUID属性，查找留言用户 findByUIDs（） -- 暂无此方法 返回User List
		 * 跳转至home。jsp 或 project。jsp 或 profile。jsp
		 * 返回上述两个List，并一一对应输出
		 */
		doGet(request, response);
	}

}
