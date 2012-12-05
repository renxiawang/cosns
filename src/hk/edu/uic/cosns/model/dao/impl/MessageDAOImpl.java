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

import hk.edu.uic.cosns.model.dao.IMessageDAO;
import hk.edu.uic.cosns.model.dbc.DatabaseConnection;
import hk.edu.uic.cosns.model.vo.Message;
import hk.edu.uic.cosns.model.vo.MsgBoard;

/** 
 * @author cofthew7
 */
public class MessageDAOImpl implements IMessageDAO {

	/**
	 * 
	 */
	public MessageDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see hk.edu.uic.cosns.model.dao.IMessageDAO#findMsgByMBID(int)
	 */
	@Override
	public List<Message> findUserMsgByMBID(int mbid) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		List<Message> msgList = new LinkedList<Message>();
		// 搜索语句
		String query="SELECT uid, fullname, content, DATE FROM user, msgboard " +
				"WHERE user.uid = msgboard.inserUID " +
				"AND inserUID IN " +
				"(SELECT inserUID FROM msgboard WHERE mbid =" + mbid +") " + 
				"ORDER BY Date DESC";
		
		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			ResultSet rs = pStatement.executeQuery();
			
			while(rs.next()) {		
				Message msg = new Message();
				msg.setUID(rs.getInt("uid"));
				msg.setUserName(rs.getString("fullname"));
				msg.setDate(rs.getString("Date"));
				msg.setContent(rs.getString("Content"));
				
				msgList.add(msg);
			}
			// 判断是否为空
			if (msgList.size() != 0) {
				System.out.println("msgList Success!");
			} else {
				System.out.println("No record satisfied! msgList");
				msgList = null;
			}
			// 关闭连接，返回结果
			// rs.close();	
			dbc.close();
			return msgList;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Message> findProjectMsgByMBID(int mbid) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		List<Message> msgList = new LinkedList<Message>();
		// 搜索语句
		String query="SELECT pid, fullname, content, DATE " +
				"FROM project, msgboard, user " +
				"WHERE (msgboard.mbid = project.mbid " +
				"AND user.uid = msgboard.inseruid " +
				"AND msgboard.mbid = " + mbid + ")" +
				"ORDER BY Date DESC";
		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			ResultSet rs = pStatement.executeQuery();
			
			while(rs.next()) {		
				Message msg = new Message();
				msg.setUID(rs.getInt("pid"));
				msg.setUserName(rs.getString("fullname"));
				msg.setDate(rs.getString("Date"));
				msg.setContent(rs.getString("Content"));
				
				msgList.add(msg);
			}
			// 判断是否为空
			if (msgList.size() != 0) {
				System.out.println("msgList Success!");
			} else {
				System.out.println("No record satisfied! msgList");
				msgList = null;
			}
			// 关闭连接，返回结果
			// rs.close();	
			dbc.close();
			return msgList;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
