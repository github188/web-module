package com.ehualu.rise.service.topic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import com.alibaba.fastjson.JSON;
import com.ehualu.rise.constants.AppConstant;
import com.ehualu.rise.pojo.Head;
import com.ehualu.rise.pojo.topic.Topic;
import com.ehualu.rise.service.ServiceInterface;

public class TopicManager implements ServiceInterface{

	private TopicService topicRiseService;
	


	public TopicService getTopicRiseService() {
		return topicRiseService;
	}
	@Inject
	public void setTopicRiseService(TopicService topicRiseService) {
		this.topicRiseService = topicRiseService;
	}

	@Override
	public Map<String, Object> handle(String head,String body) {
		Head header = JSON.parseObject(head, Head.class);
		if(body == null){
			header.setZtm(AppConstant.ExecuteFlag.BODY_IS_NULL);
			return formatResult(JSON.toJSONString(header), null);
		}
		
		Topic topic = JSON.parseObject(body, Topic.class);
//		
//		topic.setPublishTimeDate(new Timestamp(topic.getPublishTime()));
//
//		
//		List<Topic> topicList= topicRiseService.listTopics(topic);
//		
//		String imgUrl = PropertyConfig.getProperty("IMG_URL");
//		
//		String topicUrl = PropertyConfig.getProperty("TOPIC_URL");
//		
//		for(Topic obj:topicList){
//			obj.setPublishTime(obj.getPublishTimeDate().getTime());
//			obj.setCount(topic.getCount());
//			if(obj.getImgId() != null){
//				obj.setImageUri(imgUrl+obj.getImgId());
//			}
//			
//			obj.setWebUrl(topicUrl+obj.getId());
//		}
		
		List<Topic> topicList= new ArrayList<Topic>();
		if(topic.getType() == 0){
			Topic topictmp = new Topic();
			topictmp.setId(0);
			topictmp.setCount(topic.getCount());
			topictmp.setType(topic.getType());
			topictmp.setPublishTime(topic.getPublishTime());
			topictmp.setTitle("创新者");
			topictmp.setImageUri("http://10.2.111.238:8080/ehualu-appServer/images/chuangxinzhe.png");
			topictmp.setWebUrl("http://10.2.111.238:8082/ehualu-admin/news/show/4");
			topicList.add(topictmp);
			Topic topictmp1 = new Topic();
			topictmp1.setId(1);
			topictmp1.setCount(topic.getCount());
			topictmp1.setType(topic.getType());
			topictmp1.setPublishTime(topic.getPublishTime());
			topictmp1.setTitle("开拓者");
			topictmp1.setImageUri("http://10.2.111.238:8080/ehualu-appServer/images/kaituozhe.png");
			topictmp1.setWebUrl("http://10.2.111.238:8082/ehualu-admin/news/show/5");
			topicList.add(topictmp1);
			Topic topictmp2 = new Topic();
			topictmp2.setId(2);
			topictmp2.setCount(topic.getCount());
			topictmp2.setType(topic.getType());
			topictmp2.setPublishTime(topic.getPublishTime());
			topictmp2.setTitle("引领者");
			topictmp2.setImageUri("http://10.2.111.238:8080/ehualu-appServer/images/yinlingzhe.png");
			topictmp2.setWebUrl("http://10.2.111.238:8082/ehualu-admin/news/show/7");
			topicList.add(topictmp2);
		}else if(topic.getType() == 1){
			Topic topictmp = new Topic();
			topictmp.setId(3);
			topictmp.setCount(topic.getCount());
			topictmp.setType(topic.getType());
			topictmp.setPublishTime(topic.getPublishTime());
			topictmp.setTitle("有效防止车漆氧化阻隔挥发");
			topictmp.setImageUri("");
			topictmp.setWebUrl("http://weizhang.58.com/zixun/loadinfocontent?infoid=881dcca9-0932-4cbd-b105-ac275b9a12e3");
			topicList.add(topictmp);
			
			Topic topictmp1 = new Topic();
			topictmp1.setId(4);
			topictmp1.setCount(topic.getCount());
			topictmp1.setType(topic.getType());
			topictmp1.setPublishTime(topic.getPublishTime());
			topictmp1.setTitle("让爱车驾驶寿命更长久的妙招");
			topictmp1.setImageUri("");
			topictmp1.setWebUrl("http://weizhang.58.com/zixun/loadinfocontent?infoid=638b4236-9926-4553-abba-5fea4bdbd0d2");
			topicList.add(topictmp1);
			
			Topic topictmp2 = new Topic();
			topictmp2.setId(5);
			topictmp2.setCount(topic.getCount());
			topictmp2.setType(topic.getType());
			topictmp2.setPublishTime(topic.getPublishTime());
			topictmp2.setTitle("有效防止车漆氧化阻隔挥发");
			topictmp2.setImageUri("");
			topictmp2.setWebUrl("http://weizhang.58.com/zixun/loadinfocontent?infoid=881dcca9-0932-4cbd-b105-ac275b9a12e3");
			topicList.add(topictmp2);
			
			Topic topictmp3 = new Topic();
			topictmp3.setId(6);
			topictmp3.setCount(topic.getCount());
			topictmp3.setType(topic.getType());
			topictmp3.setPublishTime(topic.getPublishTime());
			topictmp3.setTitle("让爱车驾驶寿命更长久的妙招");
			topictmp3.setImageUri("");
			topictmp3.setWebUrl("http://weizhang.58.com/zixun/loadinfocontent?infoid=638b4236-9926-4553-abba-5fea4bdbd0d2");
			topicList.add(topictmp3);
		}else{
			Topic topictmp = new Topic();
			topictmp.setId(7);
			topictmp.setCount(topic.getCount());
			topictmp.setType(topic.getType());
			topictmp.setPublishTime(topic.getPublishTime());
			topictmp.setTitle("易华录");
			topictmp.setImageUri("http://10.2.111.238:8080/ehualu-appServer/images/logo.png");
			topictmp.setWebUrl("http://www.ehualu.com/");
			topicList.add(topictmp);
		}
		
		return formatResult(header, topicList);
	}
	
	public Map<String, Object> formatResult(Object head,Object object){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(AppConstant.HEAD, head);
		if(object != null){
			map.put(AppConstant.BODY, object);
		}
		return map;
	}

}
