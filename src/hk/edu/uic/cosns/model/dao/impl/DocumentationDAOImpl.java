package hk.edu.uic.cosns.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import hk.edu.uic.cosns.model.dao.IDocumentationDAO;
import hk.edu.uic.cosns.model.dbc.DatabaseConnection;
import hk.edu.uic.cosns.model.vo.Documentation;


public class DocumentationDAOImpl implements IDocumentationDAO {

	public DocumentationDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Documentation> findDocByPIDs(int[] pidArray) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		List<Documentation> docList = new LinkedList<Documentation>();
		// 搜索语句
		String query="select * from documentation where pid= ? ORDER BY  `Date` DESC";
	
		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			
			for (int i = 0; i < pidArray.length; i++) {
				pStatement.setInt(1, pidArray[i]);
				ResultSet rs = pStatement.executeQuery();
				
				while(rs.next()) {
					Documentation doc = new Documentation();
					doc.setDocID(rs.getInt("DocID"));
					doc.setPublisherID(rs.getInt("PublisherUID"));
					doc.setContent(rs.getString("Content"));
					doc.setTitle(rs.getString("Title"));
					doc.setPID(rs.getInt("PID"));
					
					docList.add(doc);
				}
			}
			// 判断是否为空
			if (docList.size()!=0) {
				System.out.println("Successful!");
			} else {
				System.out.println("No record satisfied!");
				docList = null;
			}
			// 关闭连接，返回结果
			// rs.close();	
			dbc.close();
			return docList;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Documentation> findDocByUID(int uid) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		List<Documentation> docList = new LinkedList<Documentation>();
		// 搜索语句
		String query="select * from documentation where PublisherUID=" + uid + " ORDER BY  `Date` DESC";

		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			ResultSet rs = pStatement.executeQuery();
		
			while(rs.next()) {
				Documentation doc = new Documentation();
				doc.setDocID(rs.getInt("DocID"));
				doc.setPublisherID(rs.getInt("PublisherUID"));
				doc.setContent(rs.getString("Content"));
				doc.setTitle(rs.getString("Title"));
				doc.setPID(rs.getInt("PID"));
				
				docList.add(doc);
			}
			// 判断是否为空
			if (docList.size()!=0) {
				System.out.println("Successful!");
			} else {
				System.out.println("No record satisfied!");
				docList = null;
			}
			// 关闭连接，返回结果
			// rs.close();	
			dbc.close();
			return docList;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Documentation> findDocByPID(int pid) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		List<Documentation> docList = new LinkedList<Documentation>();
		// 搜索语句
		String query="select * from documentation where pid=" + pid + " ORDER BY  `Date` DESC";

		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			ResultSet rs = pStatement.executeQuery();
		
			while(rs.next()) {
				Documentation doc = new Documentation();
				doc.setDocID(rs.getInt("DocID"));
				doc.setPublisherID(rs.getInt("PublisherUID"));
				doc.setContent(rs.getString("Content"));
				doc.setTitle(rs.getString("Title"));
				doc.setPID(rs.getInt("PID"));
				
				docList.add(doc);
			}
			// 判断是否为空
			if (docList.size()!=0) {
				System.out.println("Successful!");
			} else {
				System.out.println("No record satisfied!");
				docList = null;
			}
			// 关闭连接，返回结果
			// rs.close();	
			dbc.close();
			return docList;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean postDoc(int pid, int publisherUID, String title,
			String content) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 判断结果
		boolean isSuccess = false;
		// 插入语句
		String query="INSERT INTO documentation (DocID, PublisherUID, Content, Date, Title, PID) " +
				"VALUES (NULL, ?, ?, CURRENT_TIMESTAMP, ?, ?);";
		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			pStatement.setInt(1, publisherUID);
			pStatement.setString(2, content);
			pStatement.setString(3, title);
			pStatement.setInt(4, pid);
			
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
