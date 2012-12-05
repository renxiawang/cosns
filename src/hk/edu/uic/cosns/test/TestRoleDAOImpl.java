package hk.edu.uic.cosns.test;

import hk.edu.uic.cosns.model.dao.impl.RoleDAOImpl;

public class TestRoleDAOImpl {
	
	private static final int uid = 23;
	private static final int participateWay = 2;
	private static final boolean isManager = false;
	private static final int pid = 12;

	private static void printResult(int[] result) {
		for (int i=0; i<result.length; i++) {
			System.out.print(result[i] + "   ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws Exception {
		int []result1 =  null;
		int []result2 =  null;
		int []result3 =  null;
		int []result4 =  null;
		
		RoleDAOImpl testRoleDAOImpl = new RoleDAOImpl();
		
		System.out.println("---test findAllProjectsIDS---");
		result1 = testRoleDAOImpl.findAllProjectIDs(uid);
		if (result1 != null) {
			printResult(result1);
		}
		System.out.println("---test findFavProjectIDs---");
		result2 = testRoleDAOImpl.findFavProjectIDs(uid, participateWay);
		if (result2 != null) {
			printResult(result2);
		}
		System.out.println("---test findJoinedProjectIDs---");
		result3 = testRoleDAOImpl.findJoinedProjectIDs(participateWay, uid);
		
		if (result3 != null) {
			printResult(result3);
		}
		System.out.println("---test findMyProjectIDs---");
		result4 = testRoleDAOImpl.findMyProjectIDs(uid, participateWay);
		if (result4 != null) {
			printResult(result4);	
		}
				
		System.out.println("---test insertRole---");
		System.out.println("Insert Role Successfully?" + testRoleDAOImpl.insertRole(uid, pid, participateWay, isManager));
	}



}
