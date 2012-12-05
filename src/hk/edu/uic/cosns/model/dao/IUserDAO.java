package hk.edu.uic.cosns.model.dao;

import java.lang.String;
import hk.edu.uic.cosns.model.vo.User;
import java.util.List;

public interface IUserDAO {

	/**
	 * 登陆并取得该用户信息返回User对象
	 * 
	 * @param eamil 用户email
	 * @param password 用户密码
	 * @return user 该用户对象
	 * @throws Exception 
	 */
	public abstract User signin(String email, String password) throws Exception;

	/**
	 * 根据用户email随机生成新密码并更新相应记录
	 * 
	 * @param email 用户email
	 * @return password 新密码
	 */
	public abstract java.lang.String resetPwd(String email);

		
		/** 
		 * 注册并取得该用户信息返回User对象
		 * @param eamil 用户email
		 * @param password 用户密码
		 * @param fullName 用户昵称
		 * @param avatarUrl 用户头像URL
		 * @return user 该用户对象
		 * @throws Exception 
		 */
		public abstract User signup(String email, String password, String fullName, String avatarUrl) throws Exception;
		

	/**
	 * 根据email判断用户是否存在
	 * 
	 * @param email 用户email
	 * @return result boolean标志用户是否存在
	 * @throws Exception 
	 */
	public abstract boolean isUserExisted(String email) throws Exception;

		
		/** 
		 * 根据User Name查找User
		 * @param userName 用户名
		 * @return users 相关的用户List
		 * @throws Exception 
		 */
		public abstract List<User> findByUserName(String userName) throws Exception;
		

	/**
	 * 修改用户Profile并返回更新后的User对象
	 * 
	 * @param user 用户对象
	 * @return user 该用户对象
	 * @throws Exception 
	 */
	public abstract User updateProfile(User user) throws Exception;

		
		/**
		 * 查找其他用户
		 * @param uid 被查询用户ID
		 * @return user 该用户对象
		 * @throws Exception 
		 */
		public abstract User findByUID(int uid) throws Exception;

			
			/**
			 * 通过UIDs查找用户User
			 * @param uidArray 
			 * @return userList 
			 * @throws Exception 
			 */
			public abstract List<User> findByUIDs(int[] uidArray) throws Exception;
			
		

}
