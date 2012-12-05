package hk.edu.uic.cosns.test;

import java.util.List;

import hk.edu.uic.cosns.model.dao.impl.*;
import hk.edu.uic.cosns.model.vo.Announcement;

public class TestAnnouncementDAOImpl {
	public static final int []pidArray = {1,2,3};
	public static final int pid = 1;
	public static final int uid = 1;
	public static final int announcerUID = 1;
	
	public static void main(String args[]) throws Exception {
		AnnouncementDAOImpl testAnnouncement = new AnnouncementDAOImpl();
		List<Announcement> result1 = null;
		List<Announcement> result2 = null;
		List<Announcement> result3 = null;
		
		//test findAnnounceByPID
		System.out.println("---test findAnnounceByPID---");
		result1 = testAnnouncement.findAnnounceByPID(pid);
		for (int i=0; i<result1.size(); i++) {
			System.out.println("AnnouncementID:" + result1.get(i).getAnnouncementID() + 
					"  AnnouncerUID:" + result1.get(i).getAnnouncerUID() +
					"  Content:" +result1.get(i).getContent() +
					"  Date: " + result1.get(i).getDate() + 
					"  PID: " + result1.get(i).getPID() );
		}
		
		//test findAnnounceByPIDs
		System.out.println("---test findAnnounceByPIDs---"); 
		result2 = testAnnouncement.findAnnounceByPIDs(pidArray);
		for (int i=0; i<result2.size(); i++) {
			System.out.println("AnnouncementID:" + result2.get(i).getAnnouncementID() + 
					"  AnnouncerUID:" + result2.get(i).getAnnouncerUID() +
					"  Content:" +result2.get(i).getContent() +
					"  Date: " + result2.get(i).getDate() + 
					"  PID: " + result2.get(i).getPID() );
		}
		
		//test findAnnounceByUID
		System.out.println("---test findAnnounceByUID---"); 
		result3 = testAnnouncement.findAnnounceByUID(uid);
		if (result3 != null) { // cao!!!
			for (int i=0; i<result3.size(); i++) {
				System.out.println("AnnouncementID:" + result3.get(i).getAnnouncementID() + 
						"  AnnouncerUID:" + result3.get(i).getAnnouncerUID() +
						"  Content:" +result3.get(i).getContent() +
						"  Date: " + result3.get(i).getDate() + 
						"  PID: " + result3.get(i).getPID() );
			}
		}
		//test postAnnouncement
		System.out.println("---test postAnnouncement---");
		System.out.println(testAnnouncement.postAnnouncement(announcerUID, pid, "test"));
	}
}
