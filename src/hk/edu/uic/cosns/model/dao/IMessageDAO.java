/**
 * 
 */
package hk.edu.uic.cosns.model.dao;

import hk.edu.uic.cosns.model.vo.Message;

import java.util.List;

/** 
 * @author cofthew7
 */
public interface IMessageDAO {

		
		/**
		 * @throws Exception 
		 */
		public abstract List<Message> findUserMsgByMBID(int mbid) throws Exception;

			
			/**
			 * @throws Exception 
			 */
			public abstract List<Message> findProjectMsgByMBID(int mbid) throws Exception;
			
		

}
