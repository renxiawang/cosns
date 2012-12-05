package hk.edu.uic.cosns.model.dao;

import java.util.List;
import java.lang.String;
import hk.edu.uic.cosns.model.vo.Project;

public interface IProjectDAO {

	/**
	 * 根据用户创建的Priject ID数组，查找对应projects
	 * 
	 * @param pids 用户创建的project ID数组
	 * @return projectList 对应Project List
	 * @throws Exception 
	 */
	public abstract List<Project> findMyProjects(int[] pidArray) throws Exception;

	/**
	 * 根据用户加入的Priject ID数组，查找对应projects
	 * 
	 * @param pids 用户加入的project ID数组
	 * @return projectList 对应Project List
	 * @throws Exception 
	 */
	public abstract List<Project> findJoinedProjects(int[] pidArray) throws Exception;

	/**
	 * 根据用户喜欢的Priject ID数组，查找对应projects
	 * 
	 * @param pids 用户喜欢的project ID数组
	 * @return projectList 对应Project List
	 * @throws Exception 
	 */
	public abstract List<Project> findFavProjects(int[] pidArray) throws Exception;

	/**
	 * 根据Project Name搜索project
	 * 
	 * @param projectName 项目名称
	 * @return projects 相关项目List
	 * @throws Exception 
	 */
	public abstract List<Project> findByProjectName(String projectName) throws Exception;

		
		/**
		 * 创建并取得该project信息返回project对象
		 * @param projectName 项目名称
		 * @param description 项目描述
		 * @return project 新建的项目对象
		 * @throws Exception
		 */
		public abstract Project createProject(int creatorUID, String projectName, String description, String projectLogoUrl)	throws Exception ;
		

		
			
			/** 
			 * 根据Project ID查找并返回project对象
			 * @param pid 项目ID
			 * @return project 项目对象
			 * @throws Exception 
			 */
			public abstract Project findProjectByID(int pid) throws Exception;

				
				/**
				 * @throws Exception 
				 */
				public abstract boolean isProjectExisted(String projectName) throws Exception;
				
			
		

}
