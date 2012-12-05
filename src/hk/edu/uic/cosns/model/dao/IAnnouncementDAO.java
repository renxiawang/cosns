package hk.edu.uic.cosns.model.dao;

import java.util.List;
import hk.edu.uic.cosns.model.vo.Announcement;

public interface IAnnouncementDAO {

	/**
	 * 根据当前用户相关的project id数组，查找各个project里的announcement
	 * 
	 * @param pidArray 相关Project ID数组
	 * @return announceList 对应announce List
	 * @throws Exception 
	 */
	public abstract List<Announcement> findAnnounceByPIDs(int[] pidArray) throws Exception;

	/**
	 * 根据当前用户ID,查找相关projects里的announce
	 * 
	 * @param uid 用户ID
	 * @return docList 对应announce List
	 * @throws Exception 
	 */
	public abstract List<Announcement> findAnnounceByUID(int uid) throws Exception;

		
			
				
				/** 
				 * 根据Project ID查找并返回其Announcement对象List
				 * @param pid 项目ID
				 * @return announceList Announcement List
				 * @throws Exception 
				 */
				public abstract List<Announcement> findAnnounceByPID(int pid) throws Exception;

					
					/**
					 * 新建Announcement
					 * @param pid 项目ID
					 * @param announcerUID 创建者ID
					 * @param content 公告内容
					 * @return result boolean值标志成功与否
					 * @throws Exception 
					 */
					public abstract boolean postAnnouncement(int announcerUID, int pid, String content) throws Exception;
					
				
			
		

}
