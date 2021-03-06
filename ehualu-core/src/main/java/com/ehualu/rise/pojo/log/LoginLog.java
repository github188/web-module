package com.ehualu.rise.pojo.log;

import java.sql.Timestamp;

public class LoginLog {
	/**
	 * ID
	 */
    private int id;
    /**
     * 电话
     */
    private String phone;
    /**
     * 设备MAC地址
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
     * 动作
     */
    private String action;
    /**
     * 操作时间
     */
    private Timestamp optTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac == null ? null : mac.trim();
    }

    public String getMfrs() {
        return mfrs;
    }

    public void setMfrs(String mfrs) {
        this.mfrs = mfrs == null ? null : mfrs.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
    }

    public Timestamp getOptTime() {
        return optTime;
    }

    public void setOptTime(Timestamp optTime) {
        this.optTime = optTime;
    }
}