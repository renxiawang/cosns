/**
 * 
 */
package hk.edu.uic.cosns.model.vo;

/**
 * @author cofthew7
 */
public class User {

	/**
	 * 
	 */
	public User() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Getter of the property <tt>Email</tt>
	 * 
	 * @return Returns the email.
	 * @uml.property name="email"
	 */
	public String getEmail() {
		return email1;
	}

	/**
	 * Setter of the property <tt>Email</tt>
	 * 
	 * @param Email
	 *            The email to set.
	 * @uml.property name="email"
	 */
	public void setEmail(String email) {
		email1 = email;
	}

	/**
	 * @uml.property name="passWord"
	 */
	private String passWord;

	/**
	 * Getter of the property <tt>passWord</tt>
	 * 
	 * @return Returns the passWord.
	 * @uml.property name="passWord"
	 */
	public String getPassWord() {
		return passWord;
	}

	/**
	 * Setter of the property <tt>passWord</tt>
	 * 
	 * @param passWord
	 *            The passWord to set.
	 * @uml.property name="passWord"
	 */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	/**
	 * Display name
	 * 
	 * @uml.property name="fullName"
	 */
	private String fullName;

	/**
	 * Getter of the property <tt>fullName</tt>
	 * 
	 * @return Returns the fullName.
	 * @uml.property name="fullName"
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * Setter of the property <tt>fullName</tt>
	 * 
	 * @param fullName
	 *            The fullName to set.
	 * @uml.property name="fullName"
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * Login account
	 * 
	 * @uml.property name="email"
	 */
	private String email1;
	/**
	 * Link to the user avatar
	 * 
	 * @uml.property name="avatarUrl"
	 */
	private String avatarUrl;

	/**
	 * Getter of the property <tt>avatarUrl</tt>
	 * 
	 * @return Returns the avatarUrl.
	 * @uml.property name="avatarUrl"
	 */
	public String getAvatarUrl() {
		return avatarUrl;
	}

	/**
	 * Setter of the property <tt>avatarUrl</tt>
	 * 
	 * @param avatarUrl
	 *            The avatarUrl to set.
	 * @uml.property name="avatarUrl"
	 */
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	/**
	 * User Id
	 * @uml.property  name="UID"
	 */
	private int uid;

	/** 
	 * Getter of the property <tt>UID</tt>
	 * @return Returns the uid.
	 * @uml.property  name="UID"
	 */
	public int getUID() {
		return uid;
	}

	/** 
	 * Setter of the property <tt>UID</tt>
	 * @param UID The uid to set.
	 * @uml.property  name="UID"
	 */
	public void setUID(int uid) {
		this.uid = uid;
	}

	/** 
	 * The id of the user's message board
	 * @uml.property name="MBID"
	 */
	private int mbid1;

	/** 
	 * Getter of the property <tt>mbid</tt>
	 * @return Returns the mbid.
	 * @uml.property  name="MBID"
	 */
	public int getMBID() {
		return mbid1;
	}

	/** 
	 * Setter of the property <tt>mbid</tt>
	 * @param mbid The mbid to set.
	 * @uml.property  name="MBID"
	 */
	public void setMBID(int mbid) {
		mbid1 = mbid;
	}

}
