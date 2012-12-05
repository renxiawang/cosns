package hk.edu.uic.cosns.controller.servlets;

import hk.edu.uic.cosns.model.dao.impl.ProjectDAOImpl;
import hk.edu.uic.cosns.model.dao.impl.RoleDAOImpl;
import hk.edu.uic.cosns.model.vo.Project;
import hk.edu.uic.cosns.model.vo.User;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowProjectList
 */
public class ShowProjectListSVL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowProjectListSVL() {
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
		// 获取登录用户对象
		User signinUser = (User)request.getSession().getAttribute("SigninUser");
		// 验证用户是否登录
		if (signinUser == null) {
			response.sendRedirect("index.jsp");
			return;
		}
		// 获取与用户相关联的project对象
		ProjectDAOImpl pdi = new ProjectDAOImpl();
		RoleDAOImpl rdi = new RoleDAOImpl();
		
		int[] myProjectArray = null;
		int[] joinedProjectArray = null;
		int[] favProjectArray = null;
		
		List<Project> myProjectList = null;
		List<Project> joinedProjectList = null;
		List<Project> favProjectList = null;
		try {
			// 获取三种类型Project List
			myProjectArray = rdi.findMyProjectIDs(signinUser.getUID(), 1);
			if (myProjectArray != null) {
				myProjectList = pdi.findMyProjects(myProjectArray);
				//System.out.println(myProjectList.get(0).getPID());
			}
			joinedProjectArray = rdi.findJoinedProjectIDs(2, signinUser.getUID());
			if (joinedProjectArray != null) {
				joinedProjectList = pdi.findJoinedProjects(joinedProjectArray);
			}
			favProjectArray = rdi.findFavProjectIDs(signinUser.getUID(), 3);
			if (favProjectArray != null) {
				favProjectList = pdi.findFavProjects(favProjectArray);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ProjectListSVL");
		 //ServletContext context = thiss
		request.getSession().setAttribute("MyProjectList", myProjectList);
		request.getSession().setAttribute("JoinedProjectList", joinedProjectList);
		request.getSession().setAttribute("FavProjectList", favProjectList);
		request.getRequestDispatcher("ShowHomeNewsSVL").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*
		 * 根据uid findFavProjectIDs（） --》 findFavProjects（） 返回一个Fav Project List
		 * 根据uid findJoinedProjectIDs（） --》 findJoinedProjects（） 返回一个 Joined Project List
		 * Myproject同上 不写……
		 * forward多个对象回 home.jsp 或继续调用 ShowHomeNewsSVL
		 */
		doGet(request, response);
	}

}
