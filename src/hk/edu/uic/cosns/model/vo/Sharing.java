/**
 * 
 */
package hk.edu.uic.cosns.model.vo;

/** 
 * @author cofthew7
 */
public class Sharing {

	/**
	 * 
	 */
	public Sharing() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * The id of the sharing
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

	/**
	 * The id of user who share the sharing in the project
	 * @uml.property  name="SharerUID"
	 */
	private int sharerUID;

	/**
	 * Getter of the property <tt>SharerUID</tt>
	 * @return  Returns the sharerUID.
	 * @uml.property  name="SharerUID"
	 */
	public int getSharerUID() {
		return sharerUID;
	}

	/**
	 * Setter of the property <tt>SharerUID</tt>
	 * @param SharerUID  The sharerUID to set.
	 * @uml.property  name="SharerUID"
	 */
	public void setSharerUID(int sharerUID) {
		this.sharerUID = sharerUID;
	}

	/**
	 * The type of the sharing 1: file 2: pic 3: link
	 * @uml.property  name="sharingType"
	 */
	private int sharingType;

	/**
	 * Getter of the property <tt>sharingType</tt>
	 * @return  Returns the sharingType.
	 * @uml.property  name="sharingType"
	 */
	public int getSharingType() {
		return sharingType;
	}

	/**
	 * Setter of the property <tt>sharingType</tt>
	 * @param sharingType  The sharingType to set.
	 * @uml.property  name="sharingType"
	 */
	public void setSharingType(int sharingType) {
		this.sharingType = sharingType;
	}

	/**
	 * The share time of the sharing
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
	 * The content of the sharing
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
