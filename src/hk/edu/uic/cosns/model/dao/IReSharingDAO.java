package hk.edu.uic.cosns.model.dao;

import hk.edu.uic.cosns.model.vo.Sharing;

import java.util.List;

public interface IReSharingDAO {

	/**
	 * 根据当前用户ID,查找其转分享的Sharing
	 * 
	 * @param uid 用户ID
	 * @return sharingList 对应sharing List.
	 * @throws Exception 
	 */
	public abstract List<Sharing> findReSharingByUID(int uid) throws Exception;

		
		/**
		 * @throws Exception 
		 */
		public abstract boolean postResharing(int uid, int pid, int sharingID) throws Exception;
		

}
