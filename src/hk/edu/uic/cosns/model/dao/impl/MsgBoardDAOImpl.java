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


import hk.edu.uic.cosns.model.dao.IMsgBoardDAO;
import hk.edu.uic.cosns.model.dbc.DatabaseConnection;
import hk.edu.uic.cosns.model.vo.MsgBoard;

/** 
 * @author cofthew7
 */
public class MsgBoardDAOImpl implements IMsgBoardDAO {

	/**
	 * 
	 */
	public MsgBoardDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<MsgBoard> findMsgBoardByMBID(int mbid) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		List<MsgBoard> msgBoardList = new LinkedList<MsgBoard>();
		// 搜索语句
		String query="select * from msgboard where mbid=" + mbid;
		
		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			ResultSet rs = pStatement.executeQuery();
			
			while(rs.next()) {		
				MsgBoard msgBoard = new MsgBoard();
				msgBoard.setMBID(rs.getInt("MBID"));
				msgBoard.setMsgID(rs.getInt("MsgID"));
				msgBoard.setInsertUID(rs.getInt("InserUID"));
				msgBoard.setDate(rs.getString("Date"));
				msgBoard.setContent(rs.getString("Content"));
				
				msgBoardList.add(msgBoard);
			}
			// 判断是否为空
			if (msgBoardList.size() != 0) {
				System.out.println("Success!");
			} else {
				System.out.println("No record satisfied!");
				msgBoardList = null;
			}
			// 关闭连接，返回结果
			// rs.close();	
			dbc.close();
			return msgBoardList;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean postMsg(int insertorUid, String content, int mbid) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 判断结果
		boolean isSuccess = false;
		// 插入语句
		String query="INSERT INTO msgboard (MBID, MsgID, InserUID, Date, Content) " +
				"VALUES (?, NULL, ?, CURRENT_TIMESTAMP, ?);";
		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			pStatement.setInt(1, mbid);
			pStatement.setInt(2, insertorUid);
			pStatement.setString(3, content);
			
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
	public MsgBoard createMsgBoard() throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		MsgBoard msgBoard = new MsgBoard();
		boolean isMbidLegal = false;
		// 插入语句
		String query="INSERT INTO msgboard (MBID, MsgID, InserUID, Date, Content) " +
				"VALUES (?, NULL, 0, CURRENT_TIMESTAMP, 'Welcome to Cosns')";
		
		try {
			pStatement = conn.prepareStatement(query);
			int row = 0;
			// 插入不重复mbid
			while (!isMbidLegal)
				try {
						{
							int mbid = (int)(Math.random()*1000);
							pStatement.setInt(1, mbid);
							// 判断是否插入成功
							row = pStatement.executeUpdate();
							
							if(row > 0) {
								isMbidLegal = true;
								msgBoard = findSingleMsgBoardByMBID(mbid);
							}
						}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			dbc.close();
			return msgBoard;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public MsgBoard findSingleMsgBoardByMBID(int mbid) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		MsgBoard msgBoard = new MsgBoard();
		// 搜索语句
		String query="select * from msgboard where mbid=" + mbid;
		
		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			ResultSet rs = pStatement.executeQuery();
			
			while(rs.next()) {		
				msgBoard.setMBID(rs.getInt("MBID"));
				msgBoard.setMsgID(rs.getInt("MsgID"));
				msgBoard.setInsertUID(rs.getInt("InserUID"));
				msgBoard.setDate(rs.getString("Date"));
				msgBoard.setContent(rs.getString("Content"));
			}
			// 判断是否为空
			if (msgBoard.getContent() != null) {
				System.out.println("Success!");
			} else {
				System.out.println("No record satisfied!");
				msgBoard = null;
			}
			// 关闭连接，返回结果
			// rs.close();	
			dbc.close();
			return msgBoard;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
