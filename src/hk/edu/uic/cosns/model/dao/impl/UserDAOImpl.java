/**
 * 
 */
package hk.edu.uic.cosns.model.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.sql.Connection;

import hk.edu.uic.cosns.model.dao.IUserDAO;
import hk.edu.uic.cosns.model.dbc.DatabaseConnection;
import hk.edu.uic.cosns.model.vo.MsgBoard;
import hk.edu.uic.cosns.model.vo.Project;
import hk.edu.uic.cosns.model.vo.User;

/** 
 * @author cofthew7
 */
public class UserDAOImpl implements IUserDAO {

	/**
	 * 
	 */
	public UserDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public User signin(String email, String password) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		User user= new User();
		// 搜索语句
		String query="select * from user where email= ? and password= ?";
		
		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			pStatement.setString(1, email);
			pStatement.setString(2, password);
			ResultSet rs = pStatement.executeQuery();
		
			while(rs.next()) {				
				user.setMBID(rs.getInt("MBID"));
				user.setFullName(rs.getString("FullName"));
				user.setAvatarUrl(rs.getString("AvatarUrl"));
				user.setEmail(rs.getString("Email"));
				user.setPassWord(rs.getString("PassWord"));
				user.setUID(rs.getInt("UID"));
			}
			// 判断是否为空
			if (user.getUID() != 0) {
				System.out.println("Signin Successfully!");
			} else {
				System.out.println("Signin Faild!");
				user = null;
			}
			// 关闭连接，返回结果
			// rs.close();	
			dbc.close();
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String resetPwd(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User signup(String email, String password, String fullName,
			String avatarUrl) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 结果
		User user = new User();
		// 搜索语句
		String query="INSERT INTO user (UID, Email, Password, Fullname, AvatarURL, MBID) " +
				"VALUES (NULL, ?, ?, ?, ?, ?)";
		String result="select * from user where email=?";
		if (isUserExisted(email)) {
			return null;
		} else {
			try{
				// 新建MsgBoard给新用户
				MsgBoardDAOImpl mdi = new MsgBoardDAOImpl();
				MsgBoard msgBoard = mdi.createMsgBoard();
				// 执行插入
				pStatement = conn.prepareStatement(query);
				pStatement.setString(1, email);
				pStatement.setString(2, password);
				pStatement.setString(3, fullName);
				pStatement.setString(4, avatarUrl);
				pStatement.setInt(5, msgBoard.getMBID());
	
				int row = pStatement.executeUpdate();
				// 判断是否为空
				if (row > 0) {
					// 若不为空，返回刚插入的对象
					System.out.println("Signup Successful!");
					pStatement = conn.prepareStatement(result);
					pStatement.setString(1, email);
					ResultSet rs = pStatement.executeQuery();
					if (rs.next()) {
						user.setMBID(rs.getInt("MBID"));
						user.setFullName(rs.getString("FullName"));
						user.setAvatarUrl(rs.getString("AvatarUrl"));
						user.setEmail(rs.getString("Email"));
						user.setPassWord(rs.getString("PassWord"));
						user.setUID(rs.getInt("UID"));
					}
				} else {
					System.out.println("Signup faild!");
					user = null;
				}
				// 关闭连接，返回结果
				//rs.close();
				dbc.close();
				return user;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public boolean isUserExisted(String email) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		boolean isExisted = false;
		// 搜索语句
		String query = "select * from user where email=\'" + email + "\'";
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

	@Override
	public List<User> findByUserName(String userName) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		List<User> userList = new LinkedList<User>();
		// 搜索语句
		String query="SELECT * FROM user WHERE Fullname LIKE '%"+ userName +"%'";
		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			//pStatement.setString(1, userName);
			ResultSet rs = pStatement.executeQuery();
		
			while(rs.next()) {				
				User user = new User();
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
				System.out.println("findByUserName Successful!");
			} else {
				System.out.println("findByUserName No record satisfied!");
				userList = null;
			}
			// 关闭连接，返回结果
			// rs.close();	
			dbc.close();
			return userList;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User updateProfile(User user) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		User updatedUser = new User();
		// 搜索语句
		String query="UPDATE user SET Email = ?, FullName = ?, AvatarUrl = ?, Password = ? " +
				"WHERE  uid = ?";
		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			pStatement.setString(1, user.getEmail());
			pStatement.setString(2, user.getFullName());
			pStatement.setString(3, user.getAvatarUrl());
			pStatement.setString(4, user.getPassWord());
			pStatement.setInt(5, user.getUID());
			int row = pStatement.executeUpdate();
			
			// 判断是否为空
			if (row > 0) {
				updatedUser = user;
				System.out.println("updateProfile Successful!");
			} else {
				System.out.println("updateProfile No record satisfied!");
				user = null;
			}
			// 关闭连接，返回结果
			// rs.close();	
			dbc.close();
			return updatedUser;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User findByUID(int uid) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		User user = new User();
		// 搜索语句
		String query="select * from user where uid=" + uid;
		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			ResultSet rs = pStatement.executeQuery();
		
			while(rs.next()) {
				user.setMBID(rs.getInt("MBID"));
				user.setFullName(rs.getString("FullName"));
				user.setAvatarUrl(rs.getString("AvatarUrl"));
				user.setEmail(rs.getString("Email"));
				user.setPassWord(rs.getString("PassWord"));
				user.setUID(rs.getInt("UID"));
			}
			// 判断是否为空
			if (user.getFullName() != null) {
				System.out.println("findByUID Successful!");
			} else {
				System.out.println("findByUID No record satisfied!");
				user = null;
			}
			// 关闭连接，返回结果
			// rs.close();	
			dbc.close();
			return user;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> findByUIDs(int[] uidArray) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		List<User> userList = new LinkedList<User>();
		// 搜索语句
		String query="select * from user where uid = ?";
	
		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			
			for (int i = 0; i < uidArray.length; i++) {
				pStatement.setInt(1, uidArray[i]);
				ResultSet rs = pStatement.executeQuery();
				
				while(rs.next()) {
					User user = new User();
					user.setMBID(rs.getInt("MBID"));
					user.setFullName(rs.getString("FullName"));
					user.setAvatarUrl(rs.getString("AvatarUrl"));
					user.setEmail(rs.getString("Email"));
					user.setPassWord(rs.getString("PassWord"));
					user.setUID(rs.getInt("UID"));
					
					userList.add(user);
				}
			}
			// 判断是否为空
			if (userList.size()!=0) {
				System.out.println("Successful!");
			} else {
				System.out.println("No record satisfied!");
				userList = null;
			}
			// 关闭连接，返回结果
			// rs.close();	
			dbc.close();
			return userList;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
