/**
 * 
 */
package hk.edu.uic.cosns.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import hk.edu.uic.cosns.model.dao.IProjectDAO;
import hk.edu.uic.cosns.model.dbc.DatabaseConnection;
import hk.edu.uic.cosns.model.vo.Documentation;
import hk.edu.uic.cosns.model.vo.MsgBoard;
import hk.edu.uic.cosns.model.vo.Project;
import hk.edu.uic.cosns.model.vo.User;

/** 
 * @author cofthew7
 */
public class ProjectDAOImpl implements IProjectDAO {

	/**
	 * 
	 */
	public ProjectDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Project> findMyProjects(int[] pidArray) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		List<Project> myProjectList = new LinkedList<Project>();
		// 搜索语句
		String query="select * from project where pid = ? ORDER BY  `UpdateTime` DESC";
	
		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			
			for (int i = 0; i < pidArray.length; i++) {
				pStatement.setInt(1, pidArray[i]);
				ResultSet rs = pStatement.executeQuery();
				
				while(rs.next()) {
					Project project = new Project();
					project.setPID(rs.getInt("PID"));
					project.setProjectName(rs.getString("ProjectName"));
					project.setDescription(rs.getString("Description"));
					project.setFavCount(rs.getInt("FavCount"));
					project.setMemberCount(rs.getInt("MemberCount"));
					project.setMBID(rs.getInt("MBID"));
					project.setUpdateTime(rs.getString("UpdateTime"));
					project.setPUrl(rs.getString("PUrl"));
					
					myProjectList.add(project);
				}
			}
			// 判断是否为空
			if (myProjectList.size()!=0) {
				System.out.println("Successful!");
			} else {
				System.out.println("No record satisfied!");
				myProjectList = null;
			}
			// 关闭连接，返回结果
			// rs.close();	
			dbc.close();
			return myProjectList;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Project> findJoinedProjects(int[] pidArray) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		List<Project> joinedProjectList = new LinkedList<Project>();
		// 搜索语句
		String query="select * from project where pid = ? ORDER BY  `UpdateTime` DESC";
	
		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			
			for (int i = 0; i < pidArray.length; i++) {
				pStatement.setInt(1, pidArray[i]);
				ResultSet rs = pStatement.executeQuery();
				
				while(rs.next()) {
					Project project = new Project();
					project.setPID(rs.getInt("PID"));
					project.setProjectName(rs.getString("ProjectName"));
					project.setDescription(rs.getString("Description"));
					project.setFavCount(rs.getInt("FavCount"));
					project.setMemberCount(rs.getInt("MemberCount"));
					project.setMBID(rs.getInt("MBID"));
					project.setUpdateTime(rs.getString("UpdateTime"));
					project.setPUrl(rs.getString("PUrl"));
					
					joinedProjectList.add(project);
				}
			}
			// 判断是否为空
			if (joinedProjectList.size()!=0) {
				System.out.println("findJoinedProjects Successful!");
			} else {
				System.out.println("findJoinedProjects No record satisfied!");
				joinedProjectList = null;
			}
			// 关闭连接，返回结果
			// rs.close();	
			dbc.close();
			return joinedProjectList;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Project> findFavProjects(int[] pidArray) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		List<Project> favProjectList = new LinkedList<Project>();
		// 搜索语句
		String query="select * from project where pid = ? ORDER BY  `UpdateTime` DESC";
	
		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			
			for (int i = 0; i < pidArray.length; i++) {
				pStatement.setInt(1, pidArray[i]);
				ResultSet rs = pStatement.executeQuery();
				
				while(rs.next()) {
					Project project = new Project();
					project.setPID(rs.getInt("PID"));
					project.setProjectName(rs.getString("ProjectName"));
					project.setDescription(rs.getString("Description"));
					project.setFavCount(rs.getInt("FavCount"));
					project.setMemberCount(rs.getInt("MemberCount"));
					project.setMBID(rs.getInt("MBID"));
					project.setUpdateTime(rs.getString("UpdateTime"));
					project.setPUrl(rs.getString("PUrl"));
					
					favProjectList.add(project);
				}
			}
			// 判断是否为空
			if (favProjectList.size()!=0) {
				System.out.println("findFavProjects Successful!");
			} else {
				System.out.println("findFavProjects No record satisfied!");
				favProjectList = null;
			}
			// 关闭连接，返回结果
			// rs.close();	
			dbc.close();
			return favProjectList;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Project> findByProjectName(String projectName) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		List<Project> projectList = new LinkedList<Project>();
		// 搜索语句
		String query="select * from project where ProjectName LIKE '%" + projectName + "%'";
		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			ResultSet rs = pStatement.executeQuery();
		
			while(rs.next()) {
				Project project = new Project();
				project.setPID(rs.getInt("PID"));
				project.setProjectName(rs.getString("ProjectName"));
				project.setDescription(rs.getString("Description"));
				project.setFavCount(rs.getInt("FavCount"));
				project.setMemberCount(rs.getInt("MemberCount"));
				project.setMBID(rs.getInt("MBID"));
				project.setUpdateTime(rs.getString("UpdateTime"));
				project.setPUrl(rs.getString("PUrl"));
				
				projectList.add(project);
			}
			// 判断是否为空
			if (projectList.size()!=0) {
				System.out.println("findByProjectName Successful!");
			} else {
				System.out.println("findByProjectName No record satisfied!");
				projectList = null;
			}
			// 关闭连接，返回结果
			// rs.close();	
			dbc.close();
			return projectList;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Project createProject(int creatorUID, String projectName, String description, String projectLogoUrl) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 结果
		Project project = new Project();
		// 搜索语句
		String query="INSERT INTO project (PID, creatorUID,ProjectName, Description, FavCount, MemberCount, MBID, UpdateTime, PUrl) " +
				"VALUES (NULL, ?, ?, ?, '0', '0', ?, CURRENT_TIMESTAMP, ?);";
		String result="select * from project where ProjectName = ?";
		
		if (isProjectExisted(projectName)) {
			return null;
		} else {
			try{
				// 新建MsgBoard给新project
				MsgBoardDAOImpl mdi = new MsgBoardDAOImpl();
				MsgBoard msgBoard = mdi.createMsgBoard();
				// 执行插入
				pStatement = conn.prepareStatement(query);
				pStatement.setInt(1, creatorUID);
				pStatement.setString(2, projectName);
				pStatement.setString(3, description);
				pStatement.setInt(4, msgBoard.getMBID());
				pStatement.setString(5, projectLogoUrl);
		
				int row = pStatement.executeUpdate();
				// 判断是否为空
				if (row > 0) {
					// 若不为空，返回刚插入的对象
					System.out.println("createProject Successful!");
					pStatement = conn.prepareStatement(result);
					pStatement.setString(1, projectName);
					ResultSet rs = pStatement.executeQuery();
					// 获取刚刚增加的project
					if (rs.next()) {
						project.setPID(rs.getInt("pid"));
						project.setProjectName(rs.getString("projectName"));
						project.setDescription(rs.getString("Description"));
						project.setMBID(rs.getInt("mbid"));
						project.setUpdateTime(rs.getString("UpdateTime"));
						project.setCreatorUID(rs.getInt("creatorUID"));
						project.setPUrl(rs.getString("PUrl"));
					}
				} else {
					System.out.println("createProject Insert faild!");
					project = null;
				}
				// 关闭连接，返回结果
				//rs.close();
					dbc.close();
					return project;
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return null;
		}
	}

	@Override
	public Project findProjectByID(int pid) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		Project project = new Project();
		// 搜索语句
		String query="select * from project where pid=" + pid;
		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			ResultSet rs = pStatement.executeQuery();
		
			while(rs.next()) {
				project.setPID(rs.getInt("PID"));
				project.setProjectName(rs.getString("ProjectName"));
				project.setDescription(rs.getString("Description"));
				project.setFavCount(rs.getInt("FavCount"));
				project.setMemberCount(rs.getInt("MemberCount"));
				project.setMBID(rs.getInt("MBID"));
				project.setUpdateTime(rs.getString("UpdateTime"));
				project.setPUrl(rs.getString("PUrl"));
			}
			// 判断是否为空
			if (project.getProjectName() != null) {
				System.out.println("findProjectByID Successful!");
			} else {
				System.out.println("findProjectByID No record satisfied!");
				project = null;
			}
			// 关闭连接，返回结果
			// rs.close();	
			dbc.close();
			return project;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

		
		/**
		 * @throws Exception 
		 */
		public boolean isProjectExisted(String projectName) throws Exception{
			// 连接数据库
			DatabaseConnection dbc = new DatabaseConnection();
			Connection conn = dbc.getConnection();
			PreparedStatement pStatement = null;
			// 声明变量用于存取结果
			boolean isExisted = false;
			// 搜索语句
			String query = "select * from project where projectName=\'" + projectName + "\'";
			try{
				// 执行搜索
				pStatement = conn.prepareStatement(query);
				ResultSet rs = pStatement.executeQuery();
				
				// 判断是否为空
				if (!rs.next()) {
					System.out.println("Not Existed!");
					isExisted = false;
				} else {
					System.out.println("Existed!");
					isExisted = true;
				}
				// 关闭连接，返回结果
				// rs.close();	
				dbc.close();
				return isExisted;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return isExisted;
		}

}
