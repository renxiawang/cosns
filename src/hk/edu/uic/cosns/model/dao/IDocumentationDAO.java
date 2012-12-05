package hk.edu.uic.cosns.model.dao;

import java.util.List;
import hk.edu.uic.cosns.model.vo.Documentation;

public interface IDocumentationDAO {

	/**
	 * 根据当前用户相关的project id数组，查找各个project里的doc
	 * 
	 * @param pidArray 相关Project ID数组
	 * @return docList 对应Doc List
	 * @throws Exception 
	 */
	public abstract List<Documentation> findDocByPIDs(int[] pidArray) throws Exception;

	/**
	 * 根据当前用户ID,查找相关projects里的doc
	 * 
	 * @param uid 用户ID
	 * @return docList 对应Doc List
	 * @throws Exception 
	 */
	public abstract List<Documentation> findDocByUID(int uid) throws Exception;

		
		/**
		 * 根据Project ID查找并返回其Doc对象List
		 * @param pid 项目ID
		 * @return DocList Doc List
		 * @throws Exception 
		 */
		public abstract List<Documentation> findDocByPID(int pid) throws Exception;

			
			/**
			 * 新建Doc
			 * @param pid 项目ID
			 * @param publisherUID 创建者ID
			 * @param content 公告内容
			 * @param title Doc标题
			 * @return result boolean值标志成功与否
			 * @throws Exception 
			 */
			public abstract boolean postDoc(int pid, int publisherUID, String title, String content) throws Exception;
			
		

}
