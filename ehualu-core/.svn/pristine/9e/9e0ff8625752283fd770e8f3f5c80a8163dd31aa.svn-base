package com.ehualu.rise.service.topic.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ehualu.rise.dao.topic.TopicRiseDao;
import com.ehualu.rise.pojo.topic.Topic;
import com.ehualu.rise.service.topic.TopicService;

@Service("topicRiseService")
public class TopicServiceImpl implements TopicService {
	private TopicRiseDao topicRiseDao;

	
	
	public TopicRiseDao getTopicDao() {
		return topicRiseDao;
	}

	@Inject
	public void setTopicDao(TopicRiseDao topicRiseDao) {
		this.topicRiseDao = topicRiseDao;
	}



	@Override
	public List<Topic> listTopics(Topic topic) {
		return topicRiseDao.listTopics(topic);
	}


}
