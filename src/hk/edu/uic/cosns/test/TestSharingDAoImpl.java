package hk.edu.uic.cosns.test;

import java.util.List;

import hk.edu.uic.cosns.model.dao.impl.SharingDAOImpl;
import hk.edu.uic.cosns.model.vo.Sharing;

public class TestSharingDAoImpl {

	private static final int pid = 1;
	private static final int[] pidArray = {1, 2, 3};
	private static final int uid = 3;
	private static final int sharerUID = 3;
	private static final String content = "Test Content";
	private static final int type = 0;
	
	private static void printResult(List<Sharing> result) {
		for (int i=0; i<result.size(); i++) {
			System.out.println( "Content:" + result.get(i).getContent() + 
					"  Date:" + result.get(i).getDate() + 
					"  PID:" + result.get(i).getPID() + 
					"  ShartUID:" + result.get(i).getSharerUID() +
					"  Sharing Type:" + result.get(i).getSharingType()
 			);
		}
	}
	public static void main(String[] args) throws Exception {
		SharingDAOImpl testSharingDAoImpl = new SharingDAOImpl();
		List<Sharing> result1 = null;
		List<Sharing> result2 = null;
		List<Sharing> result3 = null;
		//List<Sharing> result4 = null;
		
		System.out.println("---test findSharingByPID---");
		result1 = testSharingDAoImpl.findSharingByPID(pid);
		printResult(result1);
		
		System.out.println("---test findSharingByPIDs---");
		result2 = testSharingDAoImpl.findSharingByPIDs(pidArray);
		printResult(result2);
		
		System.out.println("---test findSharingByUID---");
		result3 = testSharingDAoImpl.findSharingByUID(uid);
		printResult(result3);
		
		System.out.println("---test postSharing---");
		System.out.println("Post Sharing Successfully?" + testSharingDAoImpl.postSharing(pid, sharerUID, content, type));
	}

}
