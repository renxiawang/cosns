package hk.edu.uic.cosns.test;

import hk.edu.uic.cosns.model.dao.impl.MsgBoardDAOImpl;
import hk.edu.uic.cosns.model.vo.MsgBoard;

public class TestMsgBoardDAOImpl {
	public final static int mbid = 100;
	public final static int insertorUid = 67;
	public final static String content = "test";
	
	public static void main(String []args) throws Exception {
		MsgBoardDAOImpl testMsgBoardDAOImpl = new MsgBoardDAOImpl();
		
		//test findMsgBoardByMBID
		System.out.println("---test findMsgBoardByMBID---");
		MsgBoard result = testMsgBoardDAOImpl.findSingleMsgBoardByMBID(mbid);
		if (result != null) {
			System.out.println("Content:" + result.getContent() + 
					"  Date:"  + result.getDate() +
					"  InsertUID:" + result.getInsertUID() + 
					"  MBID:" + result.getMBID() +
					"  MsgID:" + result.getMsgID()
					);	
		}
		//test findMsgBoardByMBID
		System.out.println("---test findMsgBoardByMBID---");
		//test postMsg
		System.out.println("Post Msg Successfully? " + testMsgBoardDAOImpl.postMsg(insertorUid, "test content", mbid));
		
		//test createMsgBoard
		System.out.println("---test createMsgBoard---");
		MsgBoard result2 = testMsgBoardDAOImpl.createMsgBoard();
		if (result2 != null) {
			System.out.println("Content:" + result2.getContent() + 
					"  Date:"  + result2.getDate() +
					"  InsertUID:" + result2.getInsertUID() + 
					"  MBID:" + result2.getMBID() +
					"  MsgID:" + result2.getMsgID()
					);	
		}
	}
}
