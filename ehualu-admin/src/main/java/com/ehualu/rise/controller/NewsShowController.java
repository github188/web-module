package com.ehualu.rise.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ehualu.cms.service.topic.TopicService;

@Controller
@RequestMapping("/news/show")
public class NewsShowController {

	private TopicService topicService;

	public TopicService getTopicService() {
		return topicService;
	}

	@Inject
	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}
	
	@RequestMapping(value="/{id}")
	public String show(@PathVariable int id, Model model) {
		model.addAttribute(topicService.load(id));
		return "topic/show";
	}
}
