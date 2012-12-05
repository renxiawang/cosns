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

import hk.edu.uic.cosns.model.dao.IUserRelationDAO;
import hk.edu.uic.cosns.model.dbc.DatabaseConnection;
import hk.edu.uic.cosns.model.vo.Task;
import hk.edu.uic.cosns.model.vo.User;

/** 
 * @author cofthew7
 */
public class UserRelationDAOImpl implements IUserRelationDAO {

	/**
	 * 
	 */
	public UserRelationDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<User> findFollower(int uid) throws Exception {
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		// Announcement announcement=new Announcement();
		List<User> userList = new LinkedList<User>();
		// 搜索语句
		String query="SELECT * FROM user WHERE uid IN " +
				"(SELECT uid2 FROM userrelation WHERE uid1 =" + uid + ")";

		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			ResultSet rs = pStatement.executeQuery();
			
			// 若有record符合条件，将结果封装进相应对象
			while(rs.next()) {
				User user=new User();
				user.setMBID(rs.getInt("MBID"));
				user.setFullName(rs.getString("FullName"));
				user.setAvatarUrl(rs.getString("AvatarUrl"));
				user.setEmail(rs.getString("Email"));
				user.setPassWord(rs.getString("PassWord"));
				user.setUID(rs.getInt("UID"));
				
				userList.add(user);
			}
			// 判断是否为空
			if (userList.size()!=0) {
				System.out.println("Successful!");
			} else {
				System.out.println("No record satisfied!");
				userList = null;
			}
			// 关闭连接，返回结果
			rs.close();
			dbc.close();
			return userList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<User> findFollowing(int uid) throws Exception {
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		// Announcement announcement=new Announcement();
		List<User> userList = new LinkedList<User>();
		// 搜索语句
		String query="SELECT * FROM user WHERE uid IN " +
			"(SELECT uid2 FROM userrelation WHERE uid1 =" + uid + ")";

		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			ResultSet rs = pStatement.executeQuery();
			
			// 若有record符合条件，将结果封装进相应对象
			while(rs.next()) {
				User user = new User();
				user.setMBID(rs.getInt("MBID"));
				user.setFullName(rs.getString("FullName"));
				user.setAvatarUrl(rs.getString("AvatarUrl"));
				user.setEmail(rs.getString("Email"));
				user.setPassWord(rs.getString("PassWord"));
				user.setUID(rs.getInt("UID"));
				System.out.println(user.getFullName());
				userList.add(user);
			}
			// 判断是否为空
			if (userList.size()!=0) {
				System.out.println("Successful!");
			} else {
				System.out.println("No record satisfied!");
				userList = null;
			}
			// 关闭连接，返回结果
			rs.close();
			dbc.close();
			return userList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}


	@Override
	public boolean follow(int uid1, int uid2) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 结果
		boolean isSuccess = false;
		// 搜索语句
		String query="INSERT INTO `userrelation` (`UID1`, `UID2`) VALUES (? , ?);";
		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			pStatement.setInt(1, uid1);
			pStatement.setInt(2, uid2);
			
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

	@Override
	public boolean unFollow(int uid1, int uid2) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 结果
		boolean isSuccess = false;
		// 搜索语句
		String query="DELETE FROM userrelation WHERE UID1 = ? AND UID2 = ?";
		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			pStatement.setInt(1, uid1);
			pStatement.setInt(2, uid2);
			
			int row = pStatement.executeUpdate();
			
			// 判断是否为空
			if (row > 0) {
				System.out.println("Successful!");
				isSuccess = true;
			} else {
				System.out.println("delete faild!");
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
