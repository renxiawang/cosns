/**
 * 
 */
package hk.edu.uic.cosns.model.vo;

/** 
 * @author cofthew7
 */
public class ReSharing {

	/**
	 * 
	 */
	public ReSharing() {
		// TODO Auto-generated constructor stub
	}

	/** 
	 * The id of who shared this sharing from a project to his friends
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
	 * Id of the project which the sharing comes from
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
	 * Setter of the property <tt>UID</tt>
	 * @param UID  The uid to set.
	 * @uml.property  name="UID"
	 */
	public void setUID(int uid) {
		this.uid = uid;
	}

	/**
	 * The id of the orginal sharing in a specific project
	 * @uml.property  name="SharingID"
	 */
	private int sharingID;

	/**
	 * Getter of the property <tt>SharingID</tt>
	 * @return  Returns the sharingID.
	 * @uml.property  name="SharingID"
	 */
	public int getSharingID() {
		return sharingID;
	}

	/**
	 * Setter of the property <tt>SharingID</tt>
	 * @param SharingID  The sharingID to set.
	 * @uml.property  name="SharingID"
	 */
	public void setSharingID(int sharingID) {
		this.sharingID = sharingID;
	}

}
