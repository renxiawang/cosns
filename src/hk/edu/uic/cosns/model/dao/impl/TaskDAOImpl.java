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

import hk.edu.uic.cosns.model.dao.ITaskDAO;
import hk.edu.uic.cosns.model.dbc.*;
import hk.edu.uic.cosns.model.vo.Task;

/** 
 * @author cofthew7
 */
public class TaskDAOImpl implements ITaskDAO {

	/**
	 * 
	 */
	public TaskDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Task> findTaskByPIDs(int[] pidArray) throws Exception{
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		//Announcement announcement=new Announcement();
		List<Task> taskList = new LinkedList<Task>();
		// 搜索语句
		String query="select * from task where pid= ? ORDER BY  `Date` DESC";

		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			
			for (int i = 0; i < pidArray.length; i++) {
				pStatement.setInt(1, pidArray[i]);
				ResultSet rs = pStatement.executeQuery();
				
				while(rs.next()) {
					Task task=new Task();
					task.setTaskID(rs.getInt("TaskID"));
					task.setCreatorUID(rs.getInt("CreatorUID"));
					task.setDate(rs.getString("Date"));
					task.setContent(rs.getString("Content"));
					task.setPID(rs.getInt("PID"));
					task.setExecutorUID(rs.getString("ExecutorUID"));
					
					taskList.add(task);
				}
			}
			// 判断是否为空
			if (taskList.size()!=0) {
				System.out.println("Successful!");
			} else {
				System.out.println("No record satisfied!");
				taskList = null;
			}
			// 关闭连接，返回结果
			// rs.close();	
			dbc.close();
			return taskList;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Task> findTaskByUID(int uid) throws Exception {
		// TODO Auto-generated method stub
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		//Announcement announcement=new Announcement();
		List<Task> taskList = new LinkedList<Task>();
		// 搜索语句
		String query="select * from task where CreatorUID=" + uid + " ORDER BY  `Date` DESC";

		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			ResultSet rs = pStatement.executeQuery();
			
			// 若有record符合条件，将结果封装进相应对象
			while(rs.next()) {
				Task task=new Task();
				task.setTaskID(rs.getInt("TaskID"));
				task.setCreatorUID(rs.getInt("CreatorUID"));
				task.setDate(rs.getString("Date"));
				task.setContent(rs.getString("Content"));
				task.setPID(rs.getInt("PID"));
				task.setExecutorUID(rs.getString("ExecutorUID"));
				
				taskList.add(task);
			}
			// 判断是否为空
			if (taskList.size()!=0) {
				System.out.println("Successful!");
			} else {
				System.out.println("No record satisfied!");
				taskList = null;
			}
			// 关闭连接，返回结果
			//rs.close();
			dbc.close();
			return taskList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Task> findTaskByPID(int pid) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		// Announcement announcement=new Announcement();
		List<Task> taskList = new LinkedList<Task>();
		// 搜索语句
		String query="SELECT * FROM  task WHERE  PID=" + pid + " ORDER BY  `Date` DESC";
		
		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			ResultSet rs = pStatement.executeQuery();
			
			// 若有record符合条件，将结果封装进相应对象
			while(rs.next()) {
				Task task=new Task();
				task.setTaskID(rs.getInt("TaskID"));
				task.setCreatorUID(rs.getInt("CreatorUID"));
				task.setDate(rs.getString("Date"));
				task.setContent(rs.getString("Content"));
				task.setPID(rs.getInt("PID"));
				task.setExecutorUID(rs.getString("ExecutorUID"));
				
				taskList.add(task);
			}
			// 判断是否为空
			if (taskList.size()!=0) {
				System.out.println("Successful!");
			} else {
				System.out.println("No record satisfied!");
				taskList = null;
			}
			// 关闭连接，返回结果
			//rs.close();	
			dbc.close();
			return taskList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public boolean postTask(int creatorUID, int pid, String executorUIDs,
			String content) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 判断结果
		boolean isSuccess = false;
		// 插入语句
		String query="INSERT INTO task (TaskID, CreatorUID, ExecutorUID, Date, Content, PID) " +
				"VALUES (NULL, ?, ?, CURRENT_TIMESTAMP, ?, ?)";
		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			pStatement.setInt(1, creatorUID);
			pStatement.setString(2, executorUIDs);
			pStatement.setString(3, content);
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
