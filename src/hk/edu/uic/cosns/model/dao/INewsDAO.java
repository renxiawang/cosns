/**
 * 
 */
package hk.edu.uic.cosns.model.dao;

import hk.edu.uic.cosns.model.vo.News;

import java.util.List;

/** 
 * @author cofthew7
 */
public interface INewsDAO {

		
		/**
		 * @throws Exception 
		 */
		public abstract List<News> findNewAnnounceByPIDs(int[] pidArray) throws Exception;

			
			/**
			 * @throws Exception 
			 */
			public abstract List<News> findNewDocByPIDs(int[] pidArray) throws Exception;


				
				/**
				 * @throws Exception 
				 */
				public abstract List<News> findNewSharingByPIDs(int[] pidArray) throws Exception;


					
					/**
					 * @throws Exception 
					 */
					public abstract List<News> findNewTaskByPIDs(int[] pidArray) throws Exception;
					
				
			
		

}
