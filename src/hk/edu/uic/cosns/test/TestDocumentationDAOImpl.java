package hk.edu.uic.cosns.test;

import java.util.List;

import hk.edu.uic.cosns.model.dao.impl.DocumentationDAOImpl;
import hk.edu.uic.cosns.model.vo.Documentation;

public class TestDocumentationDAOImpl {
	static int[] pidArray = {1,2,3};
	public static final int pid = 1;
	public static final int uid = 3;
	public static final int announcerUID = 1;
	public static final int publisherUID = 3;
	
	public static void main(String []args) throws Exception {
		DocumentationDAOImpl testDocumentationDAOImpl = new DocumentationDAOImpl();
		List<Documentation> result1 = null;
		List<Documentation> result2 = null;
		List<Documentation> result3 = null;
		
		// test findDocByPID
		System.out.println("---test findDocByPID---");
		result1 = testDocumentationDAOImpl.findDocByPID(pid);
		for (int i=0; i<result1.size(); i++) {
			System.out.println("Content:" + result1.get(i).getContent() + 
					"  Date:" + result1.get(i).getDate() +
					"  DocID:" + result1.get(i).getDocID() + 
					"  PID:" + result1.get(i).getPID() + 
					"  PublisherID:" + result1.get(i).getPublisherID() +
					"  Title:" + result1.get(i).getTitle()
			);
		}
		
		//test findDocByPIDs
		System.out.println("---test findDocByPIDs---");
		result2 = testDocumentationDAOImpl.findDocByPIDs(pidArray);
		for (int i=0; i<result2.size(); i++) {
			System.out.println("Content:" + result2.get(i).getContent() + 
					"  Date:" + result2.get(i).getDate() +
					"  DocID:" + result2.get(i).getDocID() + 
					"  PID:" + result2.get(i).getPID() + 
					"  PublisherID:" + result2.get(i).getPublisherID() +
					"  Title:" + result2.get(i).getTitle()
			);
		}
		
		//test findDocByUID
		System.out.println("---test findDocByUID---");
		result3 = testDocumentationDAOImpl.findDocByUID(uid);
		for (int i=0; i<result3.size(); i++) {
			System.out.println("Content:" + result3.get(i).getContent() + 
					"  Date:" + result3.get(i).getDate() +
					"  DocID:" + result3.get(i).getDocID() + 
					"  PID:" + result3.get(i).getPID() + 
					"  PublisherID:" + result3.get(i).getPublisherID() +
					"  Title:" + result3.get(i).getTitle()
			);
		}
		
		//test postDoc
		System.out.println("---test postDoc---");
		System.out.println("Post Successfully? " + testDocumentationDAOImpl.postDoc(pid, publisherUID, "title", "content"));
	}
}
