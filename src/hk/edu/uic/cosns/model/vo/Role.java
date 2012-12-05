/**
 * 
 */
package hk.edu.uic.cosns.model.vo;

/** 
 * @author cofthew7
 */
public class Role {

	/**
	 * 
	 */
	public Role() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @uml.property  name="roleID"
	 */
	private int roleID;

	/**
	 * Getter of the property <tt>roleID</tt>
	 * @return  Returns the roleID.
	 * @uml.property  name="roleID"
	 */
	public int getRoleID() {
		return roleID;
	}

	/**
	 * Setter of the property <tt>roleID</tt>
	 * @param roleID  The roleID to set.
	 * @uml.property  name="roleID"
	 */
	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	/** 
	 * The id of the user who paticipate in the project
	 * @uml.property name="UID"
	 */
	private int uid;

	/** 
	 * Getter of the property <tt>UID</tt>
	 * @return  Returns the uid.
	 * @uml.property  name="UID"
	 */
	public int getUID() {
		return uid;
	}

	/** 
	 * Setter of the property <tt>UID</tt>
	 * @param UID  The uid to set.
	 * @uml.property  name="UID"
	 */
	public void setUID(int uid) {
		this.uid = uid;
	}

	/**
	 * The id of project
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

	/**
	 * To mark wether the user is manager of the project or not
	 * @uml.property  name="isManager"
	 */
	private boolean isManager;

	/**
	 * Getter of the property <tt>isManager</tt>
	 * @return  Returns the isManager.
	 * @uml.property  name="isManager"
	 */
	public boolean isIsManager() {
		return isManager;
	}

	/**
	 * Setter of the property <tt>isManager</tt>
	 * @param isManager  The isManager to set.
	 * @uml.property  name="isManager"
	 */
	public void setIsManager(boolean isManager) {
		this.isManager = isManager;
	}

	/** 
	 * 1: Create 2: Join 3: Favourite
	 * @uml.property name="participateWay"
	 */
	private int participateWay;

	/** 
	 * Getter of the property <tt>participateWay</tt>
	 * @return  Returns the participateWay.
	 * @uml.property  name="participateWay"
	 */
	public int getParticipateWay() {
		return participateWay;
	}

	/** 
	 * Setter of the property <tt>participateWay</tt>
	 * @param participateWay  The participateWay to set.
	 * @uml.property  name="participateWay"
	 */
	public void setParticipateWay(int participateWay) {
		this.participateWay = participateWay;
	}

	/**
	 * The date of the user participate in the project
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

}
