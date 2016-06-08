package com.ehualu.rise.pojo.topic;

import java.sql.Date;
import java.sql.Timestamp;


/**
 * 
 * @author Administrator 广告咨询表
 */
public class Topic {
	/**
	 * ID
	 */
	private int id;
	/**
	 * imgId
	 */
	private String imgId;

	/**
	 * 广告类型
	 */
	private int type;
	/**
	 * 图片资源地址
	 */
	private String imageUri;
	/**
	 * 详细信息网址
	 */
	private String webUrl;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 发布时间
	 */
	private Long publishTime;
	/**
	 * 发布时间 Date型
	 */
	private Timestamp publishTimeDate;

	/**
	 * 请求条数
	 */
	private int count;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getImageUri() {
		return imageUri;
	}

	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Long publishTime) {
		this.publishTime = publishTime;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	public String getImgId() {
		return imgId;
	}

	public void setImgId(String imgId) {
		this.imgId = imgId;
	}

	public Timestamp getPublishTimeDate() {
		return publishTimeDate;
	}

	public void setPublishTimeDate(Timestamp publishTimeDate) {
		this.publishTimeDate = publishTimeDate;
	}
}
