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
import hk.edu.uic.cosns.model.dao.IReSharingDAO;
import hk.edu.uic.cosns.model.dbc.DatabaseConnection;
import hk.edu.uic.cosns.model.vo.Sharing;

/** 
 * @author cofthew7
 */
public class ReSharingDAOImpl implements IReSharingDAO {

	/**
	 * 
	 */
	public ReSharingDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Sharing> findReSharingByUID(int uid) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		// Announcement announcement=new Announcement();
		List<Sharing> sharingList = new LinkedList<Sharing>();
		// 搜索语句
		String query="SELECT * FROM sharing WHERE sharingid IN " +
				"(SELECT sharingid FROM resharing WHERE uid =" + uid + ")";
		
		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			ResultSet rs = pStatement.executeQuery();
			
			// 若有record符合条件，将结果封装进相应对象
			while(rs.next()) {
				Sharing sharing = new Sharing();
				sharing.setSharingID(rs.getInt("SharingID"));
				sharing.setSharerUID(rs.getInt("SharerUID"));
				sharing.setSharingType(rs.getInt("Type"));
				sharing.setDate(rs.getString("Date"));
				sharing.setContent(rs.getString("Content"));
				sharing.setPID(rs.getInt("PID"));
				
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
			rs.close();	
			dbc.close();
			return sharingList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean postResharing(int uid, int pid, int sharingID) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 判断结果
		boolean isSuccess = false;
		// 插入语句
		String query="INSERT INTO resharing (UID, PID, SharingID) " +
				"VALUES (?, ?, ?);";
		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			pStatement.setInt(1, uid);
			pStatement.setInt(2, pid);
			pStatement.setInt(3, sharingID);
			
			int row = pStatement.executeUpdate();
			
			// 判断是否为空
			if (row > 0) {
				System.out.println("Successful!");
				isSuccess = true;
			} else {
				System.out.println("Insert faild!");
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
