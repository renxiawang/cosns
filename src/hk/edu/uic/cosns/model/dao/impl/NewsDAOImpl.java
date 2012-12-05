/**
 * 
 */
package hk.edu.uic.cosns.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import hk.edu.uic.cosns.model.dao.INewsDAO;
import hk.edu.uic.cosns.model.dbc.DatabaseConnection;
import hk.edu.uic.cosns.model.vo.News;
import hk.edu.uic.cosns.model.vo.Project;

/** 
 * @author cofthew7
 */
public class NewsDAOImpl implements INewsDAO {

	/**
	 * 
	 */
	public NewsDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see hk.edu.uic.cosns.model.dao.INewsDAO#findNewAnnounceByPIDs(int[])
	 */
	@Override
	public List<News> findNewAnnounceByPIDs(int[] pidArray) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		List<News> announceNewsList = new LinkedList<News>();
		// 搜索语句
		String query="SELECT project.pid, purl, projectName, AnnouncementID, content, DATE " +
				"FROM project, announcement " +
				"WHERE announcement.pid = project.pid " +
				"AND AnnouncementID " +
				"IN ( SELECT AnnouncementID " +
				"FROM announcement " +
				"WHERE pid= ? ) ORDER BY date DESC";
	
		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			
			for (int i = 0; i < pidArray.length; i++) {
				pStatement.setInt(1, pidArray[i]);
				ResultSet rs = pStatement.executeQuery();
				
				//System.out.println(pidArray.length);
				//System.out.println(pidArray[i]);
				
				while(rs.next()) {
					
					News announceNews = new News();
					announceNews.setPID(rs.getInt("PID"));
					announceNews.setProjectName(rs.getString("ProjectName"));
					announceNews.setPurl(rs.getString("Purl"));
					announceNews.setID(rs.getInt("AnnouncementID"));
					announceNews.setContent(rs.getString("content"));
					announceNews.setDate(rs.getString("Date"));
					
					announceNewsList.add(announceNews);
				}
			}
			// 判断是否为空
			if (announceNewsList.size()!=0) {
				System.out.println("announceNewsList Successful!");
			} else {
				System.out.println("No record satisfied! announceNewsList");
				announceNewsList = null;
			}
			// 关闭连接，返回结果
			// rs.close();	
			dbc.close();
			return announceNewsList;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see hk.edu.uic.cosns.model.dao.INewsDAO#findNewDocByPIDs(int[])
	 */
	@Override
	public List<News> findNewDocByPIDs(int[] pidArray) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		List<News> docNewsList = new LinkedList<News>();
		// 搜索语句
		String query="SELECT project.pid, purl, projectName, DocID, content, DATE " +
			"FROM project, documentation " +
			"WHERE documentation.pid = project.pid " +
			"AND DocID " +
			"IN ( SELECT DocID " +
			"FROM documentation " +
			"WHERE pid= ? ) ORDER BY date DESC";
	
		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			
			for (int i = 0; i < pidArray.length; i++) {
				pStatement.setInt(1, pidArray[i]);
				ResultSet rs = pStatement.executeQuery();
				
				while(rs.next()) {
					News docNews = new News();
					docNews.setPID(rs.getInt("PID"));
					docNews.setProjectName(rs.getString("ProjectName"));
					docNews.setPurl(rs.getString("Purl"));
					docNews.setID(rs.getInt("DocID"));
					docNews.setContent(rs.getString("content"));
					docNews.setDate(rs.getString("Date"));
					
					docNewsList.add(docNews);
				}
			}
			// 判断是否为空
			if (docNewsList.size()!=0) {
				System.out.println("docNewsList Successful!");
			} else {
				System.out.println("No record satisfied! docNewsList");
				docNewsList = null;
			}
			// 关闭连接，返回结果
			// rs.close();	
			dbc.close();
			return docNewsList;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see hk.edu.uic.cosns.model.dao.INewsDAO#findNewSharingByPIDs(int[])
	 */
	@Override
	public List<News> findNewSharingByPIDs(int[] pidArray) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		List<News> sharingNewsList = new LinkedList<News>();
		// 搜索语句
		String query="SELECT project.pid, purl, projectName, sharingID, content, DATE " +
			"FROM project, sharing " +
			"WHERE sharing.pid = project.pid " +
			"AND sharingID " +
			"IN ( SELECT sharingID " +
			"FROM sharing " +
			"WHERE pid= ? ) ORDER BY date DESC";
	
		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			
			for (int i = 0; i < pidArray.length; i++) {
				pStatement.setInt(1, pidArray[i]);
				ResultSet rs = pStatement.executeQuery();
				System.out.println(pidArray[i]);
				while(rs.next()) {
					News sharingNews = new News();
					sharingNews.setPID(rs.getInt("PID"));
					sharingNews.setProjectName(rs.getString("ProjectName"));
					sharingNews.setPurl(rs.getString("Purl"));
					sharingNews.setID(rs.getInt("sharingID"));
					sharingNews.setContent(rs.getString("content"));
					sharingNews.setDate(rs.getString("Date"));
					
					sharingNewsList.add(sharingNews);
				}
			}
			// 判断是否为空
			if (sharingNewsList.size()!=0) {
				System.out.println("sharingNewsList Successful!");
			} else {
				System.out.println("No record satisfied! sharingNewsList");
				sharingNewsList = null;
			}
			// 关闭连接，返回结果
			// rs.close();	
			dbc.close();
			return sharingNewsList;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see hk.edu.uic.cosns.model.dao.INewsDAO#findNewTaskByPIDs(int[])
	 */
	@Override
	public List<News> findNewTaskByPIDs(int[] pidArray) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		List<News> taskNewsList = new LinkedList<News>();
		// 搜索语句
		String query="SELECT project.pid, purl, projectName, taskID, content, DATE " +
			"FROM project, task " +
			"WHERE task.pid = project.pid " +
			"AND taskID " +
			"IN ( SELECT taskID " +
			"FROM task " +
			"WHERE pid= ? ) ORDER BY date DESC";
	
		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			
			for (int i = 0; i < pidArray.length; i++) {
				pStatement.setInt(1, pidArray[i]);
				ResultSet rs = pStatement.executeQuery();
				
				while(rs.next()) {
					News taskNews = new News();
					taskNews.setPID(rs.getInt("PID"));
					taskNews.setProjectName(rs.getString("ProjectName"));
					taskNews.setPurl(rs.getString("Purl"));
					taskNews.setID(rs.getInt("TaskID"));
					taskNews.setContent(rs.getString("content"));
					taskNews.setDate(rs.getString("Date"));
					
					taskNewsList.add(taskNews);
				}
			}
			// 判断是否为空
			if (taskNewsList.size()!=0) {
				System.out.println("taskNewsList Successful!");
			} else {
				System.out.println("No record satisfied! taskNewsList");
				taskNewsList = null;
			}
			// 关闭连接，返回结果
			// rs.close();	
			dbc.close();
			return taskNewsList;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
