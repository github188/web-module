package com.ehualu.rise.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ehualu.cms.pojo.admin.Role;
import com.ehualu.cms.pojo.admin.RoleType;
import com.ehualu.cms.service.user.RoleService;
import com.ehualu.cms.service.user.UserService;
import com.ehualu.rise.auth.AuthClass;
import com.ehualu.rise.util.EnumUtils;


@Controller
@RequestMapping("/admin/role")
@AuthClass
public class RoleController {
	private RoleService roleService;
	private UserService userService;

	public RoleService getRoleService() {
		return roleService;
	}

	@Inject
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public UserService getUserService() {
		return userService;
	}

	@Inject
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 获取所有的角色列表信息
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/roles")
	public String list(Model model) {
		model.addAttribute("roles", roleService.listRole());
		return "role/list";
	}

	/**
	 * 跳转到添加角色信息(把枚举定义的角色信息带到添加页面)
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute(new Role());
		model.addAttribute("types", EnumUtils.enum2Name(RoleType.class));
		return "role/add";
	}

	/**
	 * 添加角色信息
	 * 
	 * @param role
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(Role role) {
		roleService.add(role);
		return "redirect:/admin/role/roles";
	}

	/**
	 * 跳转到角色编辑页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable int id, Model model) {
		model.addAttribute(roleService.load(id));
		model.addAttribute("types", EnumUtils.enum2Name(RoleType.class));
		return "role/update";
	}

	/**
	 * 更新角色信息
	 * 
	 * @param id
	 * @param role
	 * @return
	 */
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(@PathVariable int id, Role role) {
		// 根据角色id获取角色信息,目的是重新封装基本的参数,如name和roletype,id为更新条件
		Role er = roleService.load(id);
		er.setName(role.getName());
		er.setRoleType(role.getRoleType());
		roleService.update(er);
		return "redirect:/admin/role/roles";
	}

	/**
	 * 删除角色信息(在删除角色之前需要判断此角色中是否含有用户信息)
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		roleService.delete(id);
		return "redirect:/admin/role/roles";
	}

	/**
	 * 清除角色下的用户信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/clearUsers/{id}")
	public String clearUsers(@PathVariable int id) {
		roleService.deleteRoleUsers(id);
		return "redirect:/admin/role/roles";
	}

	@RequestMapping("/{id}")
	public String show(@PathVariable int id, Model model) {
		model.addAttribute(roleService.load(id));
		model.addAttribute("us", userService.listUsersByRid(id));
		return "role/show";
	}
}
