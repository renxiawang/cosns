/**
 * 
 */
package hk.edu.uic.cosns.model.vo;

/** 
 * @author cofthew7
 */
public class Announcement {

	/**
	 * 
	 */
	public Announcement() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * The id of the announcement
	 * @uml.property  name="announcementID"
	 */
	private int announcementID;

	/**
	 * Getter of the property <tt>announcementID</tt>
	 * @return  Returns the announcementID.
	 * @uml.property  name="announcementID"
	 */
	public int getAnnouncementID() {
		return announcementID;
	}

	/**
	 * Setter of the property <tt>announcementID</tt>
	 * @param announcementID  The announcementID to set.
	 * @uml.property  name="announcementID"
	 */
	public void setAnnouncementID(int announcementID) {
		this.announcementID = announcementID;
	}

	/**
	 * The id of the creator of the announcement
	 * @uml.property  name="announcerUID"
	 */
	private int announcerUID;

	/**
	 * Getter of the property <tt>announcerUID</tt>
	 * @return  Returns the announcerUID.
	 * @uml.property  name="announcerUID"
	 */
	public int getAnnouncerUID() {
		return announcerUID;
	}

	/**
	 * Setter of the property <tt>announcerUID</tt>
	 * @param announcerUID  The announcerUID to set.
	 * @uml.property  name="announcerUID"
	 */
	public void setAnnouncerUID(int announcerUID) {
		this.announcerUID = announcerUID;
	}

	/**
	 * The created date of the announcement
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
	 * The content of the announcement
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
