package hk.edu.uic.cosns.model.dao;

import java.lang.String;
import java.util.List;

import hk.edu.uic.cosns.model.vo.MsgBoard;

public interface IMsgBoardDAO {

	/**
	 * 根据留言板ID,查找并返回留言板对象
	 * 
	 * @param mbid 留言板ID
	 * @return msgBoard msgBoard对象
	 * @throws Exception 
	 */
	public abstract List<MsgBoard> findMsgBoardByMBID(int mbid) throws Exception;

		
			
			/** 
			 * 增加留言到留言板
			 * @param insertorUid 留言者ID
			 * @param content 留言内容
			 * @return boolean
			 * @throws Exception 
			 */
			public abstract boolean postMsg(int insertorUid, String content, int mbid) throws Exception;
			
		

	/**
	 * 创建留言板
	 * 
	 * @return msgBoard 创建的MsgBoard对象
	 */
	public abstract MsgBoard createMsgBoard() throws Exception;



		
		/**
		 * @throws Exception 
		 */
		public abstract MsgBoard findSingleMsgBoardByMBID(int mbid) throws Exception;
		
			
		

}
