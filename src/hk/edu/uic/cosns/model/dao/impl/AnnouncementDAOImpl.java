/**
 * 
 */
package hk.edu.uic.cosns.model.dao.impl;

//import java.sql.Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import hk.edu.uic.cosns.model.dbc.*;
import hk.edu.uic.cosns.model.dao.IAnnouncementDAO;
import hk.edu.uic.cosns.model.vo.Announcement;

/** 
 * @author cofthew7
 */
public class AnnouncementDAOImpl implements IAnnouncementDAO {

	/**
	 * 
	 */
	public AnnouncementDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Announcement> findAnnounceByPIDs(int[] pidArray) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		//Announcement announcement=new Announcement();
		List<Announcement> announceList = new LinkedList<Announcement>();
		// 搜索语句
		String query="select * from announcement where pid= ? ORDER BY  `Date` DESC";

		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			
			for (int i = 0; i < pidArray.length; i++) {
				pStatement.setInt(1, pidArray[i]);
				ResultSet rs = pStatement.executeQuery();
				
				while(rs.next()) {
					Announcement announcement=new Announcement();
					announcement.setAnnouncementID(rs.getInt("AnnouncementID"));
					announcement.setAnnouncerUID(rs.getInt("AnnouncerUID"));
					announcement.setDate(rs.getString("Date"));
					announcement.setContent(rs.getString("Content"));
					announcement.setPID(rs.getInt("PID"));
					
					announceList.add(announcement);
				}
			}
			// 判断是否为空
			if (announceList.size()!=0) {
				System.out.println("Successful!");
			} else {
				System.out.println("No record satisfied!");
				announceList = null;
			}
			// 关闭连接，返回结果
			// rs.close();	
			dbc.close();
			return announceList;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	

	@Override
	public List<Announcement> findAnnounceByUID(int uid) throws Exception {
		// TODO Auto-generated method stub
		
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		// Announcement announcement=new Announcement();
		List<Announcement> announceList = new LinkedList<Announcement>();
		// 搜索语句
		String query="select * from announcement where AnnouncerUID=" + uid + " ORDER BY  `Date` DESC";

		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			ResultSet rs = pStatement.executeQuery();
			
			// 若有record符合条件，将结果封装进相应对象
			while(rs.next()) {
				Announcement announcement=new Announcement();
				announcement.setAnnouncementID(rs.getInt("AnnouncementID"));
				announcement.setAnnouncerUID(rs.getInt("AnnouncerUID"));
				announcement.setDate(rs.getString("Date"));
				announcement.setContent(rs.getString("Content"));
				announcement.setPID(rs.getInt("PID"));
				
				announceList.add(announcement);
			}
			// 判断是否为空
			if (announceList.size()!=0) {
				System.out.println("Successful!");
			} else {
				System.out.println("No record satisfied!");
				announceList = null;
			}
			// 关闭连接，返回结果
			rs.close();
			dbc.close();
			return announceList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Announcement> findAnnounceByPID(int pid) throws Exception {
		// TODO Auto-generated method stub;
		
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		// Announcement announcement=new Announcement();
		List<Announcement> announceList = new LinkedList<Announcement>();
		// 搜索语句
		String query="SELECT * FROM  announcement WHERE  PID=" + pid + " ORDER BY  `Date` DESC";
		
		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			ResultSet rs = pStatement.executeQuery();
			
			// 若有record符合条件，将结果封装进相应对象
			while(rs.next()) {
				Announcement announcement=new Announcement();
				announcement.setAnnouncementID(rs.getInt("AnnouncementID"));
				announcement.setAnnouncerUID(rs.getInt("AnnouncerUID"));
				announcement.setDate(rs.getString("Date"));
				announcement.setContent(rs.getString("Content"));
				announcement.setPID(rs.getInt("PID"));
				
				announceList.add(announcement);
			}
			// 判断是否为空
			if (announceList.size()!=0) {
				System.out.println("Successful!");
			} else {
				System.out.println("No record satisfied!");
				announceList = null;
			}
			// 关闭连接，返回结果
			rs.close();	
			dbc.close();
			return announceList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean postAnnouncement(int announcerUID, int pid, String content) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 判断结果
		boolean isSuccess = false;
		// 插入语句
		String query="INSERT INTO announcement (AnnouncementID, AnnouncerUID, Date, Content, PID) " +
				"VALUES (NULL, ?, CURRENT_TIMESTAMP, ?, ?);";
		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			pStatement.setInt(1, announcerUID);
			pStatement.setString(2, content);
			pStatement.setInt(3, pid);
			
			int row = pStatement.executeUpdate();
			
			// 判断是否为空
			if (row > 0) {
				System.out.println("Successful!");
				isSuccess = true;
			} else {
				System.out.println("No record satisfied!");
				isSuccess = false;
			}
			// 关闭连接，返回结果
			//rs.close();	
			dbc.close();
			return isSuccess;	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
