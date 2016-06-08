package com.ehualu.cms.service.user;

import java.util.List;

import com.ehualu.cms.pojo.admin.Group;
import com.ehualu.cms.pojo.admin.Role;
import com.ehualu.cms.pojo.admin.User;
import com.ehualu.cms.pojo.admin.UserGroup;
import com.ehualu.cms.pojo.admin.UserRole;
import com.ehualu.rise.page.Pager;


public interface UserService {
	/**
	 * 添加用户，需要判断用户名是否存在，如果存在抛出异常
	 * @param user 用户对象
	 * @param rids 用户的所有角色信息
	 * @param gids 用户的所有组信息
	 */
	public void add(User user,Integer[]rids,Integer[]gids);
	
	/**
	 * 根据用户id获取用户信息
	 * @param id 用户id
	 * @return 用户信息
	 */
	public User load(int id);
	
	/**
	 * 根据用户id获取此用户所对应所有的角色id集合
	 * @param id 用户id
	 * @return 获取此用户所对应所有的角色id集合
	 */
	public List<Integer> listUserRoleIds(int id);
	
	/**
	 * 根据用户id获取此用户所对应所有的群组id集合
	 * @param id 用户id
	 * @return 获取此用户所对应所有的群组id集合
	 */
	public List<Integer> listUserGroupIds(int id);
	
	/**
	 * 删除用户，注意需要把用户和角色和组的对应关系删除
	 * 如果用户存在相应的文章不能删除
	 * @param id
	 */
	public void delete(int id);
	/**
	 * 用户的更新，如果rids中的角色在用户中已经存在，就不做操作
	 * 如果rids中的角色在用户中不存在就要添加，如果用户中的角色不存在于rids中需要进行删除
	 * 对于group而已同样要做这个操作
	 * @param user
	 * @param rids
	 * @param gids
	 */
	public void update(User user,Integer[] rids,Integer[] gids);
	
	/**
	 * 更新用户基本信息
	 * @param user 用户对象
	 */
	public void update(User user);
	
	
	/**
	 * 更新密码方法
	 * @param uid
	 * @param oldPwd
	 * @param newPwd
	 */
	public void updatePwd(int uid,String oldPwd,String newPwd);
	/**
	 * 更新用户的状态
	 * @param id
	 */
	public void updateStatus(int id);
	/**
	 * 获取用户分页列表集合信息
	 * @return 获取用户分页列表集合信息
	 */
	public Pager<User> findUser();
	
	/**
	 * 获取用户的所有角色信息
	 * @param id
	 * @return
	 */
	public List<Role> listRolesByUid(int id);
	
	public List<UserRole> listUserRoles(int id);
	/**
	 * 获取用户的所有组信息
	 * @param id
	 * @return
	 */
	public List<Group> listGroupsByUid(int id);
	
	
	/**
	 * 根据群组id获取群组下用户的信息
	 * @param gid
	 * @return
	 */
	public List<UserGroup> listGroupUsers(int gid);
	
	/**
	 * 根据角色id获取用户列表
	 * @param rid
	 * @return
	 */
	public List<UserRole> listRoleUsers(int rid);
	
	/**
	 * 用户登陆
	 * @param username
	 * @param password
	 * @return
	 */
	public User login(String username,String password);

	/**
	 * 根据角色ID获取用户集合
	 * @param id
	 * @return
	 */
	public List<User> listUsersByRid(int id);

	/**
	 * 根据组ID获取用户集合
	 * @param id
	 * @return
	 */
	public List<User> listUsersByGid(int id);
}
