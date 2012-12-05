/**
 * 
 */
package hk.edu.uic.cosns.model.vo;

/** 
 * @author cofthew7
 */
public class Documentation {

	/**
	 * 
	 */
	public Documentation() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * The id of the documentation
	 * @uml.property  name="docID"
	 */
	private int docID;

	/**
	 * Getter of the property <tt>docID</tt>
	 * @return  Returns the docID.
	 * @uml.property  name="docID"
	 */
	public int getDocID() {
		return docID;
	}

	/**
	 * Setter of the property <tt>docID</tt>
	 * @param docID  The docID to set.
	 * @uml.property  name="docID"
	 */
	public void setDocID(int docID) {
		this.docID = docID;
	}

	/**
	 * The id  of the user who published the doc
	 * @uml.property  name="publisherID"
	 */
	private int publisherID;

	/**
	 * Getter of the property <tt>publisherID</tt>
	 * @return  Returns the publisherID.
	 * @uml.property  name="publisherID"
	 */
	public int getPublisherID() {
		return publisherID;
	}

	/**
	 * Setter of the property <tt>publisherID</tt>
	 * @param publisherID  The publisherID to set.
	 * @uml.property  name="publisherID"
	 */
	public void setPublisherID(int publisherID) {
		this.publisherID = publisherID;
	}

	/**
	 * The content of the doc
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
	 * The published date of the doc
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
	 * The title of the doc
	 * @uml.property  name="title"
	 */
	private String title;

	/**
	 * Getter of the property <tt>title</tt>
	 * @return  Returns the title.
	 * @uml.property  name="title"
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Setter of the property <tt>title</tt>
	 * @param title  The title to set.
	 * @uml.property  name="title"
	 */
	public void setTitle(String title) {
		this.title = title;
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
