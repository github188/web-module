package com.ehualu.rise.pojo.user;

import java.sql.Date;

/**
 * 
 * @author Administrator
 * 用户表
 */
public class User {
	/**
	 * ID
	 */
	private String id;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 昵称
	 */
	private String nick;
	/**
	 * 用户状态
	 */
	private String status;
	/**
	 * 邮件
	 */
	private String email;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 电话号码
	 */
	private String phone;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 新密码
	 */
	private String newPassword;
	/**
	 * 验证码
	 */
	private String authenCode;
	
	/**
	 * mac地址
	 */
	private String mac;
	/**
	 * 设备厂商
	 */
	private String mfrs;
	/**
	 * 设备型号
	 */
	private String model;
	/**
	 * 发送验证码标示
	 */
	private String flag;
	

	/**
	 * 查询验证码
	 */
	private String cc;



	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getMfrs() {
		return mfrs;
	}

	public void setMfrs(String mfrs) {
		this.mfrs = mfrs;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	public String getAuthenCode() {
		return authenCode;
	}

	public void setAuthenCode(String authenCode) {
		this.authenCode = authenCode;
	}

}
