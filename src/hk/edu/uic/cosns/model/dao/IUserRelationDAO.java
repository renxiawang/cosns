package hk.edu.uic.cosns.model.dao;

import java.util.List;
import hk.edu.uic.cosns.model.vo.User;

public interface IUserRelationDAO {

	/**
	 * 根据用户ID，查找其Followers(粉丝)
	 * 
	 * @param uid 用户ID
	 * @return userList 对应User List
	 * @throws Exception 
	 */
	public abstract List<User> findFollower(int uid) throws Exception;

	/**
	 * 根据用户ID,查找其Following(关注)
	 * 
	 * @param uid 用户ID
	 * @return userList 对应User List
	 * @throws Exception 
	 */
	public abstract List<User> findFollowing(int uid) throws Exception;

	/**
	 * 增加用户1关注用户2的记录
	 * 
	 * @param uid1 关注者
	 * @param uid2 被关注者
	 * @return result boolean标志是否关注成功
	 * @throws Exception 
	 */
	public abstract boolean follow(int uid1, int uid2) throws Exception;

	/**
	 * 删除用户1关注用户2的记录
	 * 
	 * @param uid1 关注者
	 * @param uid2 被关注者
	 * @return result boolean标志是否删除关注成功
	 * @throws Exception 
	 */
	public abstract boolean unFollow(int uid1, int uid2) throws Exception;

}
