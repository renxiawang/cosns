package hk.edu.uic.cosns.test;

import java.util.List;
import hk.edu.uic.cosns.model.dao.impl.ReSharingDAOImpl;
import hk.edu.uic.cosns.model.vo.Sharing;

public class TestReSharingDAOImpl {
	
	public final static int uid = 3;
	public final static int pid = 3;
	public final static int sharingID = 3;
	public static void main(String[] args) throws Exception {
		ReSharingDAOImpl testReSharingDAOImpl = new ReSharingDAOImpl();
		
		List<Sharing> result = null;
		
		result = testReSharingDAOImpl.findReSharingByUID(uid);
		for (int i=0; i<result.size(); i++) {
			System.out.println( "Content:" + result.get(i).getContent() + 
					"  Date:" + result.get(i).getDate() + 
					"  PID:" + result.get(i).getPID() + 
					"  ShartUID:" + result.get(i).getSharerUID() +
					"  Sharing Type:" + result.get(i).getSharingType()
 			);
		}
		
		boolean reSharing = testReSharingDAOImpl.postResharing(uid, pid, sharingID);
		if (reSharing) {
			System.out.println("success!!!!!!!");
		}
	}

}
