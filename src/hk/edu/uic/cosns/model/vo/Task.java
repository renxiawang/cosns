/**
 * 
 */
package hk.edu.uic.cosns.model.vo;

/** 
 * @author cofthew7
 */
public class Task {

	/**
	 * 
	 */
	public Task() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * The id of the task
	 * @uml.property  name="TaskID"
	 */
	private int taskID;

	/**
	 * Getter of the property <tt>TaskID</tt>
	 * @return  Returns the taskID.
	 * @uml.property  name="TaskID"
	 */
	public int getTaskID() {
		return taskID;
	}

	/**
	 * Setter of the property <tt>TaskID</tt>
	 * @param TaskID  The taskID to set.
	 * @uml.property  name="TaskID"
	 */
	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}

	/**
	 * The id of the user who created the task
	 * @uml.property  name="CreatorUID"
	 */
	private int creatorUID;

	/**
	 * Getter of the property <tt>CreatorUID</tt>
	 * @return  Returns the creatorUID.
	 * @uml.property  name="CreatorUID"
	 */
	public int getCreatorUID() {
		return creatorUID;
	}

	/**
	 * Setter of the property <tt>CreatorUID</tt>
	 * @param CreatorUID  The creatorUID to set.
	 * @uml.property  name="CreatorUID"
	 */
	public void setCreatorUID(int creatorUID) {
		this.creatorUID = creatorUID;
	}

	/**
	 * The id of users who to execute the task, each id seperate by ','
	 * @uml.property  name="executorUID"
	 */
	private String executorUID;

	/**
	 * Getter of the property <tt>executorUID</tt>
	 * @return  Returns the executorUID.
	 * @uml.property  name="executorUID"
	 */
	public String getExecutorUID() {
		return executorUID;
	}

	/**
	 * Setter of the property <tt>executorUID</tt>
	 * @param executorUID  The executorUID to set.
	 * @uml.property  name="executorUID"
	 */
	public void setExecutorUID(String executorUID) {
		this.executorUID = executorUID;
	}

	/**
	 * The created date of the task
	 * @uml.property  name="date"
	 */
	private String date;

	/**
	 * Getter of the property <tt>date</tt>
	 * @return  Returns the date.
	 * @uml.property  name="date"
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Setter of the property <tt>date</tt>
	 * @param date  The date to set.
	 * @uml.property  name="date"
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * The content of the task
	 * @uml.property  name="content"
	 */
	private String content;

	/**
	 * Getter of the property <tt>content</tt>
	 * @return  Returns the content.
	 * @uml.property  name="content"
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Setter of the property <tt>content</tt>
	 * @param content  The content to set.
	 * @uml.property  name="content"
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @uml.property  name="PID"
	 */
	private int pid;

	/**
	 * Getter of the property <tt>PID</tt>
	 * @return  Returns the pid.
	 * @uml.property  name="PID"
	 */
	public int getPID() {
		return pid;
	}

	/**
	 * Setter of the property <tt>PID</tt>
	 * @param PID  The pid to set.
	 * @uml.property  name="PID"
	 */
	public void setPID(int pid) {
		this.pid = pid;
	}

}
