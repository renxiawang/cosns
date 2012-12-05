/**
 * 
 */
package hk.edu.uic.cosns.model.vo;

/** 
 * @author cofthew7
 */
public class Project {

	/**
	 * 
	 */
	public Project() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * The id of the project
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
	 * The name of the project
	 * @uml.property  name="projectName"
	 */
	private String projectName;

	/**
	 * Getter of the property <tt>projectName</tt>
	 * @return  Returns the projectName.
	 * @uml.property  name="projectName"
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * Setter of the property <tt>projectName</tt>
	 * @param projectName  The projectName to set.
	 * @uml.property  name="projectName"
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * A few sentences to desribe the project
	 * @uml.property  name="description"
	 */
	private String description;

	/**
	 * Getter of the property <tt>description</tt>
	 * @return  Returns the description.
	 * @uml.property  name="description"
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Setter of the property <tt>description</tt>
	 * @param description  The description to set.
	 * @uml.property  name="description"
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * The number of users who favourite the project
	 * @uml.property  name="favCount"
	 */
	private int favCount;

	/**
	 * Getter of the property <tt>favCount</tt>
	 * @return  Returns the favCount.
	 * @uml.property  name="favCount"
	 */
	public int getFavCount() {
		return favCount;
	}

	/**
	 * Setter of the property <tt>favCount</tt>
	 * @param favCount  The favCount to set.
	 * @uml.property  name="favCount"
	 */
	public void setFavCount(int favCount) {
		this.favCount = favCount;
	}

	/**
	 * The number of members of the project
	 * @uml.property  name="memberCount"
	 */
	private int memberCount;

	/**
	 * Getter of the property <tt>memberCount</tt>
	 * @return  Returns the memberCount.
	 * @uml.property  name="memberCount"
	 */
	public int getMemberCount() {
		return memberCount;
	}

	/**
	 * Setter of the property <tt>memberCount</tt>
	 * @param memberCount  The memberCount to set.
	 * @uml.property  name="memberCount"
	 */
	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}

	/**
	 * The id of the message board of the project
	 * @uml.property  name="MBID"
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
	 * @uml.property  name="updateTime"
	 */
	private String updateTime;

	/**
	 * Getter of the property <tt>updateTime</tt>
	 * @return  Returns the updateTime.
	 * @uml.property  name="updateTime"
	 */
	public String getUpdateTime() {
		return updateTime;
	}

	/**
	 * Setter of the property <tt>updateTime</tt>
	 * @param updateTime  The updateTime to set.
	 * @uml.property  name="updateTime"
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @uml.property  name="creatorUID"
	 */
	private int creatorUID;

	/**
	 * Getter of the property <tt>creatorUID</tt>
	 * @return  Returns the creatorUID.
	 * @uml.property  name="creatorUID"
	 */
	public int getCreatorUID() {
		return creatorUID;
	}

	/**
	 * Setter of the property <tt>creatorUID</tt>
	 * @param creatorUID  The creatorUID to set.
	 * @uml.property  name="creatorUID"
	 */
	public void setCreatorUID(int creatorUID) {
		this.creatorUID = creatorUID;
	}

	/**
	 * @uml.property  name="PUrl"
	 */
	private String pUrl;

	/**
	 * Getter of the property <tt>PUrl</tt>
	 * @return  Returns the pUrl.
	 * @uml.property  name="PUrl"
	 */
	public String getPUrl() {
		return pUrl;
	}

	/**
	 * Setter of the property <tt>PUrl</tt>
	 * @param PUrl  The pUrl to set.
	 * @uml.property  name="PUrl"
	 */
	public void setPUrl(String pUrl) {
		this.pUrl = pUrl;
	}

}
