package hk.edu.uic.cosns.test;

import java.util.List;
import hk.edu.uic.cosns.model.dao.impl.ProjectDAOImpl;
import hk.edu.uic.cosns.model.vo.Project;

public class TestProjectDAOImpl {
	public final static String projectName = "project1111111111";
	public final static int []pidArray = {1,2,3};
	public final static int pid = 1;
	
	private static void printResult(List<Project> result)  {
		for (int i=0; i<result.size(); i++) {
			System.out.println("Description:" + result.get(i).getDescription() + 
					"  FavCount:" + result.get(i).getFavCount() + 
					"  MBID:" + result.get(i).getMBID() + 
					"  MemberCount:" + result.get(i).getMemberCount() + 
					"  PID:" + result.get(i).getPID() + 
					"  Project Name:" + result.get(i).getProjectName() + 
					"  UpdateTime:" + result.get(i).getUpdateTime()
			);
		}
	}
	
	public static void main(String[] args) throws Exception {
		ProjectDAOImpl testProjectDAOImpl = new ProjectDAOImpl();
		List<Project> result1 = null;
		List<Project> result2 = null;
		List<Project> result3 = null;
		List<Project> result4 = null;
		Project testProject = null;
		Project testProject2 = null;
		
		//test findByProjectName
		System.out.println("---test findByProjectName---");
		result1 = testProjectDAOImpl.findByProjectName(projectName);
		if (result1 != null) {
			printResult(result1);
		}
		//test findFavProjects
		System.out.println("---test findFavProjects---");
		result2 = testProjectDAOImpl.findFavProjects(pidArray);
		if (result2 != null) {
			printResult(result2);	
		}
		
		
		//test findJoinedProjects
		System.out.println("---test findJoinedProjects---");
		result3 = testProjectDAOImpl.findJoinedProjects(pidArray);
		if (result3 != null) {
			printResult(result3);	
		}
		
		
		//test findMyProjects
		System.out.println("---test findMyProject---");
		result4 = testProjectDAOImpl.findMyProjects(pidArray);
		if (result4 != null) {
			printResult(result4);
		}
		//test findProjectByID
		System.out.println("---test findProjectByID---");
		testProject = testProjectDAOImpl.findProjectByID(pid);
		System.out.println("Description:" + testProject.getDescription() + 
				"  FavCount:" + testProject.getFavCount() + 
				"  MBID:" + testProject.getMBID() + 
				"  MemberCount:" + testProject.getMemberCount() + 
				"  PID:" + testProject.getPID() + 
				"  Project Name:" + testProject.getProjectName() + 
				"  UpdateTime:" + testProject.getUpdateTime()
		);
		//test create project
		System.out.println("---test createProject---");
		testProject2 = testProjectDAOImpl.createProject(12, projectName, "test","hj");
		if (testProject2 != null) {
			System.out.println("Description:" + testProject2.getDescription() + 
					"  FavCount:" + testProject2.getFavCount() + 
					"  MBID:" + testProject2.getMBID() + 
					"  MemberCount:" + testProject2.getMemberCount() + 
					"  PID:" + testProject2.getPID() + 
					"  Project Name:" + testProject2.getProjectName() + 
					"  UpdateTime:" + testProject2.getUpdateTime()
			);
		}
	}

}
