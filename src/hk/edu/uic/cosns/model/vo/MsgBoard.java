/**
 * 
 */
package hk.edu.uic.cosns.model.vo;

/** 
 * @author cofthew7
 */
public class MsgBoard {

	/**
	 * 
	 */
	public MsgBoard() {
		// TODO Auto-generated constructor stub
	}

	/** 
	 * The id of the Message Board
	 * @uml.property name="MBID"
	 */
	private int mbid;

	/** 
	 * Getter of the property <tt>MBID</tt>
	 * @return  Returns the mbid.
	 * @uml.property  name="MBID"
	 */
	public int getMBID() {
		return mbid;
	}

	/** 
	 * Setter of the property <tt>MBID</tt>
	 * @param MBID  The mbid to set.
	 * @uml.property  name="MBID"
	 */
	public void setMBID(int mbid) {
		this.mbid = mbid;
	}

	/**
	 * The id of a message which was posted in this board
	 * @uml.property  name="MsgID"
	 */
	private int msgID;

	/**
	 * Getter of the property <tt>MsgID</tt>
	 * @return  Returns the msgID.
	 * @uml.property  name="MsgID"
	 */
	public int getMsgID() {
		return msgID;
	}

	/**
	 * Setter of the property <tt>MsgID</tt>
	 * @param MsgID  The msgID to set.
	 * @uml.property  name="MsgID"
	 */
	public void setMsgID(int msgID) {
		this.msgID = msgID;
	}

	/** 
	 * Getter of the property <tt>InsertUID</tt>
	 * @return  Returns the insertUID.
	 * @uml.property  name="insertUID"
	 */
	public int getInsertUID() {
		return uid;
	}

	/** 
	 * Setter of the property <tt>InsertUID</tt>
	 * @param InsertUID  The insertUID to set.
	 * @uml.property  name="insertUID"
	 */
	public void setInsertUID(int insertUID) {
		uid = insertUID;
	}

	/**
	 * The created data of this message
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
	 * The id of the author of this message
	 * @uml.property  name="insertUID"
	 */
	private int uid;
	/**
	 * The content of this message
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

}
