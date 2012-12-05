package hk.edu.uic.cosns.test;

import hk.edu.uic.cosns.model.dao.impl.TaskDAOImpl;
import hk.edu.uic.cosns.model.vo.Task;

import java.util.List;

public class TestTaskDAOImpl {
	
	private static final int pid = 1;
	private static final int[] pidArray = {1,2,3};
	private static final int uid = 3;
	private static final int creatorUID = 3;
	private static final String executorUIDs = "3,4";
	private static final String content = "test contest";

	public static void main(String[] args) throws Exception {
		TaskDAOImpl testTaskDAOImpl = new TaskDAOImpl();
		List<Task> result1 = null;
		List<Task> result2 = null;
		List<Task> result3 = null;

		
		System.out.println("---test findTaskByPID---");
		result1 = testTaskDAOImpl.findTaskByPID(pid);
		printResult(result1);
		
		System.out.println("---test findTaskByPIDs---");
		result2 = testTaskDAOImpl.findTaskByPIDs(pidArray);
		printResult(result2);
		
		System.out.println("---test findTaskByUID---");
		result3 = testTaskDAOImpl.findTaskByUID(uid);
		printResult(result3);
		
		System.out.println("---test postTask---");
		
		if(testTaskDAOImpl.postTask(creatorUID, pid, executorUIDs, content)) {
			System.out.println("post successfuly!");
		}
	}
	

	private static void printResult(List<Task> result) {
		for (int i=0; i<result.size(); i++) {
			System.out.println("Content:" + result.get(i).getContent() + 
					"  CreatorUID:" + result.get(i).getCreatorUID() +  
					"  Date:" + result.get(i).getDate() + 
					"  ExecutorUID:" + result.get(i).getExecutorUID() + 
					"  PID:" + result.get(i).getPID() + 
					"  TaskID:" + result.get(i).getTaskID()
			);
		}
	}
	
}
