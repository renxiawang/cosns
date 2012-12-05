package hk.edu.uic.cosns.controller.servlets;

import hk.edu.uic.cosns.model.dao.impl.RoleDAOImpl;
import hk.edu.uic.cosns.model.vo.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FavProjectSVL
 */
public class FavProjectSVL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavProjectSVL() {
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
		// 接收参数
		User user = (User)request.getSession().getAttribute("SigninUser");
		int pid = Integer.parseInt(request.getParameter("pid"));
		RoleDAOImpl rdi = new RoleDAOImpl();
		// 建立fav关系，更新project的FavCount记录
		try {
			if (rdi.insertRole(user.getUID(), pid, 3, false) == false) {
				request.setAttribute("FavMsg", "Fav faild!");
				request.getRequestDispatcher("./result.jsp").forward(request, response);
				return;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("FavMsg", "Fav success");
		request.getRequestDispatcher("./result.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
