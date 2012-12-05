/**
 * 
 */
package hk.edu.uic.cosns.model.vo;

/** 
 * @author cofthew7
 */
public class Message {

	/**
	 * 
	 */
	public Message() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @uml.property  name="UID"
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
	 * @uml.property  name="userName"
	 */
	private String userName;

	/**
	 * Getter of the property <tt>userName</tt>
	 * @return  Returns the userName.
	 * @uml.property  name="userName"
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Setter of the property <tt>userName</tt>
	 * @param userName  The userName to set.
	 * @uml.property  name="userName"
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
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
	 * @uml.property  name="Date"
	 */
	private String date;

	/**
	 * Getter of the property <tt>Date</tt>
	 * @return  Returns the date.
	 * @uml.property  name="Date"
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Setter of the property <tt>Date</tt>
	 * @param Date  The date to set.
	 * @uml.property  name="Date"
	 */
	public void setDate(String date) {
		this.date = date;
	}

}
