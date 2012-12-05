package hk.edu.uic.cosns.test;

import java.util.List;

import hk.edu.uic.cosns.model.dao.impl.UserDAOImpl;
import hk.edu.uic.cosns.model.vo.User;

public class TestUserDAOImpl {

	private static final String userName = "admin";
	private static final int uid = 3;
	private static final String email = "admin@admin.com";
	private static final String password = "admin";
	private static final String fullName = "testadmin";
	private static final String avatarUrl = "testadmin";
	
	
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
		UserDAOImpl testUserDAOImpl = new UserDAOImpl();
		User result1 = null;
		User result2 = null;
		User result3 = null;
		User result4 = null;

		System.out.println("---test findByUID---");
		result1 = testUserDAOImpl.findByUID(uid);
		printResult(result1);
		
		System.out.println("---test signin---");
		result2 = testUserDAOImpl.signin(email, password);
		if (result2 != null) {
			printResult(result2);
		}
		System.out.println("---test signup---");
		result3 = testUserDAOImpl.signup(email, password, fullName, avatarUrl);
		if (result3 != null) {
			printResult(result3);
		}
		System.out.println("---test updateProfile---");
		User user = result2;
		user.setPassWord("1234567890");
		result4 = testUserDAOImpl.updateProfile(user);
		if (result4 != null) {
			printResult(result4);
		}
		System.out.println("---test findUserName---");
		List<User> userList = testUserDAOImpl.findByUserName(userName);
		for (int i=0; i<userList.size(); i++) {
			printResult(userList.get(i));
		}
		
		System.out.println("---test isUserExisted---");
		System.out.println("Is User Existed?" + testUserDAOImpl.isUserExisted(email));
		
		System.out.println("---test resetPwd---");
		System.out.println("Reset Pwd:" + testUserDAOImpl.resetPwd(email));
	}

}
