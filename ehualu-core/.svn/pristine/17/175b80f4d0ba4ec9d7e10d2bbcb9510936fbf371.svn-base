package com.ehualu.rise.service.user;

import com.ehualu.rise.pojo.user.User;
import com.ehualu.rise.pojo.user.UserFeedBack;


/**
 * 
 * @author Administrator
 * 用户接口
 */
public interface UserService {

	/**
	 * 根据用户名查找用户
	 * @param phone
	 * @return
	 */
	public User queryByUserName(String phone);
	/**
	 * 修改密码
	 * @param phone
	 * @return
	 */
	public int updatePasswordByUserName(String phone,String newPassword);
	/**
	 * 用户注册
	 * @param phone
	 * @return
	 */
	public int registerUser(User user);
	/**
	 * 用户反馈
	 * @param phone
	 * @return
	 */
	public int insertUserFeedBack(UserFeedBack feedBack);
	/**
	 * 更新用户状态
	 * @param phone
	 * @return
	 */
	public int updateUserLoginStatus(String phone,String status);
	/**
	 * 重置用户密码
	 * @param phone
	 * @param newPassword
	 * @return
	 */
	public int updateUserPwd(String phone,String newPassword);
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	public int updateUserInfo(User user);
}
