/**
 * 
 */
package hk.edu.uic.cosns.model.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.sql.Connection;


import hk.edu.uic.cosns.model.dao.ISharingDAO;
import hk.edu.uic.cosns.model.dbc.*;
import hk.edu.uic.cosns.model.vo.Sharing;

/** 
 * @author cofthew7
 */
public class SharingDAOImpl implements ISharingDAO {

	/**
	 * 
	 */
	public SharingDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Sharing> findSharingByPIDs(int[] pidArray) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		//Announcement announcement=new Announcement();
		List<Sharing> sharingList = new LinkedList<Sharing>();
		// 搜索语句
		String query="select * from sharing where pid= ? ORDER BY  `Date` DESC";

		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			
			for (int i = 0; i < pidArray.length; i++) {
				pStatement.setInt(1, pidArray[i]);
				ResultSet rs = pStatement.executeQuery();
				
				while(rs.next()) {
					Sharing sharing=new Sharing();
					sharing.setSharingID(rs.getInt("SharingID"));
					sharing.setSharerUID(rs.getInt("SharerUID"));
					sharing.setDate(rs.getString("Date"));
					sharing.setContent(rs.getString("Content"));
					sharing.setPID(rs.getInt("PID"));
					sharing.setSharingType(rs.getInt("Type"));
					
					sharingList.add(sharing);
				}
			}
			// 判断是否为空
			if (sharingList.size()!=0) {
				System.out.println("Successful!");
			} else {
				System.out.println("No record satisfied!");
				sharingList = null;
			}
			// 关闭连接，返回结果
			//rs.close();	
              dbc.close();			
			return sharingList;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	    

	@Override
	public List<Sharing> findSharingByUID(int uid) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		//Announcement announcement=new Announcement();
		List<Sharing> sharingList = new LinkedList<Sharing>();
		// 搜索语句
		String query="select * from sharing where SharerUID=" + uid + " ORDER BY  `Date` DESC";

		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			ResultSet rs = pStatement.executeQuery();
			
			// 若有record符合条件，将结果封装进相应对象
			while(rs.next()) {
				Sharing sharing=new Sharing();
				sharing.setSharingID(rs.getInt("SharingID"));
				sharing.setSharerUID(rs.getInt("SharerUID"));
				sharing.setDate(rs.getString("Date"));
				sharing.setContent(rs.getString("Content"));
				sharing.setPID(rs.getInt("PID"));
				sharing.setSharingType(rs.getInt("Type"));
				
				sharingList.add(sharing);
			}
			// 判断是否为空
			if (sharingList.size()!=0) {
				System.out.println("Successful!");
			} else {
				System.out.println("No record satisfied!");
				sharingList = null;
			}
			// 关闭连接，返回结果
			//rs.close();
			dbc.close();
			return sharingList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Sharing> findSharingByPID(int pid) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		// Announcement announcement=new Announcement();
		List<Sharing> sharingList = new LinkedList<Sharing>();
		// 搜索语句
		String query="SELECT * FROM  sharing WHERE  PID=" + pid + " ORDER BY  `Date` DESC";
		
		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			ResultSet rs = pStatement.executeQuery();
			
			// 若有record符合条件，将结果封装进相应对象
			while(rs.next()) {
				Sharing sharing=new Sharing();
				sharing.setSharingID(rs.getInt("SharingID"));
				sharing.setSharerUID(rs.getInt("SharerUID"));
				sharing.setDate(rs.getString("Date"));
				sharing.setContent(rs.getString("Content"));
				sharing.setPID(rs.getInt("PID"));
				sharing.setSharingType(rs.getInt("Type"));
				
				sharingList.add(sharing);
			}
			// 判断是否为空
			if (sharingList.size()!=0) {
				System.out.println("Successful!");
			} else {
				System.out.println("No record satisfied!");
				sharingList = null;
			}
			// 关闭连接，返回结果
			//rs.close();	
			dbc.close();
			return sharingList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean postSharing(int pid, int sharerUID, String content, int type) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 判断结果
		boolean isSuccess = false;
		// 插入语句
		String query="INSERT INTO sharing (SharingID, SharerUID, Type, Date, Content, PID) " +
				"VALUES (NULL, ?, ?, CURRENT_TIMESTAMP, ?, ?);";
		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			pStatement.setInt(1, sharerUID);
			pStatement.setInt(2, type);
			pStatement.setString(3, content);
			pStatement.setInt(4, pid);
			
			int row = pStatement.executeUpdate();
			
			// 判断是否为空
			if (row > 0) {
				System.out.println("Successful!");
				isSuccess = true;
			} else {
				System.out.println("post faild!");
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
