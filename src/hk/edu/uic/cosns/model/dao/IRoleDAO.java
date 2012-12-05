/**
 * 
 */
package hk.edu.uic.cosns.model.dao;

import hk.edu.uic.cosns.model.vo.Project;
import hk.edu.uic.cosns.model.vo.Role;

public interface IRoleDAO {

	/**
	 * 查找当前用户加入的Projects
	 * 
	 * @param uid 用户ID
	 * @param participateWay 参与类型（1为创建，2为加入，3为喜欢）
	 * @return pidArray 加入的Project ID数组
	 * @throws Exception 
	 */
	public abstract int[] findJoinedProjectIDs(int participateWay, int uid) throws Exception;

	/**
	 * 查找当前用户喜欢的Projects
	 * 
	 * @param uid 用户ID
	 * @param participateWay 参与类型（1为创建，2为加入，3为喜欢）
	 * @return pidArray 喜欢的Project ID数组
	 * @throws Exception 
	 */
	public abstract int[] findFavProjectIDs(int uid, int participateWay) throws Exception;

	/**
	 * 查找当前用户创建的Projects
	 * 
	 * @param uid 用户ID
	 * @param participateWay 参与类型（1为创建，2为加入，3为喜欢）
	 * @return pidArray 创建的Project ID数组
	 * @throws Exception 
	 */
	public abstract int[] findMyProjectIDs(int uid, int participateWay) throws Exception;

	/**
	 * 查找所有与当前User有关的Projects
	 * 
	 * @param uid 当前用户ID
	 * @return pidArray 相关Project ID数组
	 * @throws Exception 
	 */
	public abstract int[] findAllProjectIDs(int uid) throws Exception;

	/**
	 * 添加一个User与Project的联系
	 * 
	 * @param uid 用户ID
	 * @param pid 项目ID
	 * @param participateWay 参与类型（1为创建，2为加入，3为喜欢）
	 * @param isManager 是否为创建者（管理者）
	 * @return result boolean值标志是否创建成功
	 * @throws Exception 
	 */
	public abstract boolean insertRole(int uid, int pid, int participateWay,
			boolean isManager) throws Exception;

}
