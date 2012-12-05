package hk.edu.uic.cosns.model.dao;

import hk.edu.uic.cosns.model.vo.Sharing;

import java.util.List;

public interface ISharingDAO {

	/**
	 * 根据当前用户相关的project id数组，查找各个project里的sharing
	 * 
	 * @param pidArray 相关Project ID数组
	 * @return sharingList 对应sharing List
	 * @throws Exception 
	 */
	public abstract List<Sharing> findSharingByPIDs(int[] pidArray) throws Exception;

	/**
	 * 根据当前用户ID,查找相关projects里的sharing
	 * 
	 * @param uid 用户ID
	 * @return sharingList 对应sharing List
	 * @throws Exception 
	 */
	public abstract List<Sharing> findSharingByUID(int uid) throws Exception;

		
			
				
				/** 
				 * 根据Project ID查找并返回其sharing对象List
				 * @param pid 项目ID
				 * @return sharingList sharing List
				 * @throws Exception 
				 */
				public abstract List<Sharing> findSharingByPID(int pid) throws Exception;

					
					/**
					 * 新建Sharing
					 * @param pid 项目ID
					 * @param sharerUID 创建者ID
					 * @param content 公告内容(链接形式)
					 * @param type 分享内容的类型（1为文件 2为图片 3为链接）
					 * @return result boolean值标志成功与否
					 * @throws Exception 
					 */
					public abstract boolean postSharing(int pid, int sharerUID, String content, int type) throws Exception;
					
				
			
		

}
