package hk.edu.uic.cosns.model.dao;

import hk.edu.uic.cosns.model.vo.Task;

import java.util.List;

public interface ITaskDAO {

	/**
	 * 根据当前用户相关的project id数组，查找各个project里的task
	 * 
	 * @param pidArray 相关Project ID数组
	 * @return taskList 对应task List
	 * @throws Exception 
	 */
	public abstract List<Task> findTaskByPIDs(int[] pidArray) throws Exception;

	/**
	 * 根据当前用户ID,查找相关projects里的doc
	 * 
	 * @param uid 用户ID
	 * @return taskList 对应Task List
	 * @throws Exception 
	 */
	public abstract List<Task> findTaskByUID(int uid) throws Exception;

		
		/**
		 * 根据Project ID查找并返回其Task对象List
		 * @param pid 项目ID
		 * @return taskList Task List
		 * @throws Exception 
		 */
		public abstract List<Task> findTaskByPID(int pid) throws Exception;

			
			/**
			 * 新建Task
			 * @param pid 项目ID
			 * @param creatorUID 创建者ID
			 * @param content 公告内容
			 * @param executorUIDs 任务执行者IDS（可为空）
			 * @return result boolean值标志成功与否
			 * @throws Exception 
			 */
			public abstract boolean postTask(int creatorUID, int pid, String executorUIDs, String content) throws Exception;
			
		

}
