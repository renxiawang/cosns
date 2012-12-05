/**
 * 
 */
package hk.edu.uic.cosns.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hk.edu.uic.cosns.model.dao.IRoleDAO;
import hk.edu.uic.cosns.model.dbc.DatabaseConnection;

/** 
 * @author cofthew7
 */
public class RoleDAOImpl implements IRoleDAO {

	/**
	 * 
	 */
	public RoleDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int[] findJoinedProjectIDs(int participateWay, int uid) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		int[] pidArray;
		// 搜索语句
		String query="select pid from role where uid=? and participateWay=?  order by pid desc";

		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			pStatement.setInt(1, uid);
			pStatement.setInt(2, participateWay);
			ResultSet rs = pStatement.executeQuery();
			
			// 获取结果集大小
			rs.last();
			pidArray = new int[rs.getRow()];
			// 逐个获取结果
			rs.beforeFirst();
			for (int i = 0; rs.next(); i++) {
				pidArray[i] = rs.getInt("pid");
			}
			// 判断是否为空
			if (pidArray.length!=0) {
				System.out.println("findJoinedProjectIDs Successful!");
			} else {
				System.out.println("findJoinedProjectIDs No record satisfied!");
				pidArray = null;
			}
			// 关闭连接，返回结果
			// rs.close();	
			dbc.close();
			return pidArray;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int[] findFavProjectIDs(int uid, int participateWay) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		int[] pidArray;
		// 搜索语句
		String query="select pid from role where uid=? and participateWay=?  order by pid desc";

		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			pStatement.setInt(1, uid);
			pStatement.setInt(2, participateWay);
			ResultSet rs = pStatement.executeQuery();
			
			// 获取结果集大小
			rs.last();
			pidArray = new int[rs.getRow()];
			// 逐个获取结果
			rs.beforeFirst();
			for (int i = 0; rs.next(); i++) {
				pidArray[i] = rs.getInt("pid");
			}
			// 判断是否为空
			if (pidArray.length!=0) {
				System.out.println("findFavProjectIDs Successful!");
			} else {
				System.out.println("findFavProjectIDs No record satisfied!");
				pidArray = null;
			}
			// 关闭连接，返回结果
			// rs.close();	
			dbc.close();
			return pidArray;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int[] findMyProjectIDs(int uid, int participateWay) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		int[] pidArray;
		// 搜索语句
		String query="select pid from role where uid=? and participateWay=? order by pid desc";

		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			pStatement.setInt(1, uid);
			pStatement.setInt(2, participateWay);
			ResultSet rs = pStatement.executeQuery();
			
			// 获取结果集大小
			rs.last();
			pidArray = new int[rs.getRow()];
			// 逐个获取结果
			rs.beforeFirst();
			/*while(rs.next()) {
				int i = 0;
				pidArray[i] = rs.getInt("pid");
				i++;
			}*/
			for (int i = 0; rs.next(); i++) {
				pidArray[i] = rs.getInt("pid");
			}
			// 判断是否为空
			if (pidArray.length!=0) {
				System.out.println("findMyProjectIDs Successful!");
			} else {
				System.out.println("findMyProjectIDs No record satisfied!");
				pidArray = null;
			}
			// 关闭连接，返回结果
			// rs.close();	
			dbc.close();
			return pidArray;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int[] findAllProjectIDs(int uid) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		int[] pidArray;
		// 搜索语句
		String query="select pid from role where uid=" + uid;

		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			ResultSet rs = pStatement.executeQuery();
			
			// 获取结果集大小
			rs.last();
			pidArray = new int[rs.getRow()];
			// 逐个获取结果
			rs.beforeFirst();
			/*while(rs.next()) {
				int i = 0;
				pidArray[i] = rs.getInt("pid");
				i++;
			}*/
			for (int i = 0; rs.next(); i++) {
				pidArray[i] = rs.getInt("pid");
			}
			// 判断是否为空
			if (pidArray.length!=0) {
				System.out.println("findAllProjectID Successful!");
			} else {
				System.out.println("findAllProjectID No record satisfied!");
				pidArray = null;
			}
			// 关闭连接，返回结果
			// rs.close();	
			dbc.close();
			return pidArray;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean insertRole(int uid, int pid, int participateWay,
			boolean isManager) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 判断结果
		boolean isSuccess = false;
		// 插入语句
		String query="INSERT INTO role (RoleID, UID, PID, IsManager, ParticipateWay, Date) " +
				"VALUES (NULL, ?, ?, ?, ?, CURRENT_TIMESTAMP);";
		String updataFavCount = "UPDATE  project SET  FavCount = FavCount + 1 WHERE PID =" + pid;
		String memberCount = "UPDATE  project SET  MemberCount = MemberCount + 1 WHERE PID =" + pid;
		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			pStatement.setInt(1, uid);
			pStatement.setInt(2, pid);
			pStatement.setBoolean(3, isManager);
			pStatement.setInt(4, participateWay);
			
			int row = pStatement.executeUpdate();
			
			// 判断是否为空
			if (row > 0) {
				System.out.println("insertRole Successful!");
				if (participateWay == 3) {
					pStatement = conn.prepareStatement(updataFavCount);
					pStatement.executeUpdate();
				} else {
					pStatement = conn.prepareStatement(memberCount);
					pStatement.executeUpdate();
				}
				isSuccess = true;
			} else {
				System.out.println("insertRole Insert faild!");
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
