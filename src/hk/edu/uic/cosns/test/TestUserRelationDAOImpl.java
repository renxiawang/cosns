package hk.edu.uic.cosns.test;

import java.util.List;

import hk.edu.uic.cosns.model.dao.impl.UserRelationDAOImpl;
import hk.edu.uic.cosns.model.vo.User;

public class TestUserRelationDAOImpl {
	
	private static final int uid = 3;
	private static final int uid1 = 5;
	private static final int uid2 = 4;
	
	private static void printResult(User result) {
		System.out.println("AvatarUrl:" + result.getAvatarUrl() + 
				" Email:" + result.getEmail() + 
				" FullName:" + result.getFullName() + 
				" MBID:" + result.getMBID() +
				" PassWord:" + result.getPassWord() + 
				" UID:" + result.getUID() 
			);
	}
	
	public static void main(String[] args) throws Exception {
		UserRelationDAOImpl testUserRelationDAOImpl = new UserRelationDAOImpl();
		List<User> result1 = null;
		List<User> result2 = null;

		
		System.out.println("---test findFollower---");
		result1 = testUserRelationDAOImpl.findFollower(uid);
		if (result1 != null) {
			for (int i=0; i<result1.size(); i++) {
				printResult(result1.get(i));
			}
		}
		
		System.out.println("---test findFollowing---");
		result2 = testUserRelationDAOImpl.findFollowing(uid);
		if (result2 != null) {
			for (int i=0; i<result2.size(); i++) {
				printResult(result2.get(i));
			}
		}
		System.out.println("---test follow---");
		System.out.println("Follow Successfully? " + testUserRelationDAOImpl.follow(uid1, uid2));
		
		System.out.println("---test unFollow---");
		System.out.println("UnFollow Successfully? " + testUserRelationDAOImpl.unFollow(uid1, uid2));
	} 
}
