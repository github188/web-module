package com.ehualu.rise.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehualu.cms.pojo.admin.Channel;
import com.ehualu.cms.pojo.admin.ChannelType;
import com.ehualu.cms.pojo.topic.IndexTopic;
import com.ehualu.cms.pojo.topic.Topic;
import com.ehualu.cms.service.topic.ChannelService;
import com.ehualu.cms.service.topic.TopicService;
import com.ehualu.rise.page.SystemContext;
import com.ehualu.rise.service.IndexService;
import com.ehualu.rise.util.FreemarkerUtil;
import com.ehualu.rise.util.PropertiesUtil;
import com.ehualu.rise.web.BaseInfoUtil;

@Service("indexService")
public class IndexServiceImpl implements IndexService {

	private String outPath;
	private FreemarkerUtil util;

	@Autowired(required = true)
	public IndexServiceImpl(String ftlPath, String outPath) {
		super();
		if (util == null) {
			this.outPath = outPath;
			util = FreemarkerUtil.getInstance(ftlPath);
		}
	}

	private ChannelService channelService;
	private TopicService topicService;




	@Inject
	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

	public ChannelService getChannelService() {
		return channelService;
	}

	@Inject
	public void setChannelService(ChannelService channelService) {
		this.channelService = channelService;
	}

	/**
	 * 重新生成顶部导航(获取所有的导航栏目，栏目的状态必须为已经启用)
	 */
	@Override
	public void generateTop() {
		System.out.println("=============重新生成了顶部信息====================");
		// 获取所有的"导航"栏目，栏目的状态必须为已经启用
		List<Channel> cs = channelService.listTopNavChannel();
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("navs", cs);
		String outfile = SystemContext.getRealPath() + outPath + "/top.jsp";
		util.fprint(root, "/top.ftl", outfile);
	}

	@Override
	public void generateBottom() {
		System.out.println("=============重新生成了底部信息====================");
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("baseInfo", BaseInfoUtil.getInstacne().read());
		String outfile = SystemContext.getRealPath() + outPath + "/bottom.jsp";
		util.fprint(root, "/bottom.ftl", outfile);
	}

	@Override
	public void generateBody() {
		System.out.println("=========重新生成首页的内容信息==============");
		// 1、获取所有的首页栏目
		List<Channel> cs = channelService
				.listAllIndexChannel(ChannelType.TOPIC_LIST);
		// 2、根据首页栏目创建相应的IndexTopic对象
		// 加载indexChannel.properties
		Properties prop = PropertiesUtil.getInstance().load("indexChannel");
		Map<String, IndexTopic> topics = new HashMap<String, IndexTopic>();
		for (Channel c : cs) {
			int cid = c.getId();
			String value = prop.getProperty(cid + "");
			if (!"".equals(value) && null != value) {
				String[] xs = value.split("_");
				if (null != xs && xs.length >= 2) {
					String order = xs[0];
					int num = Integer.parseInt(xs[1]);
					IndexTopic it = new IndexTopic();
					it.setCid(cid);
					it.setCname(c.getName());
					List<Topic> tops = topicService
							.listTopicByChannelAndNumber(cid, num);
					it.setTopics(tops);
					topics.put(order, it);
				}
			}
		}
		String outfile = SystemContext.getRealPath() + outPath + "/body.jsp";
		// 3、更新首页图片
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("ts", topics);
		root.put("xxgk", topicService.loadLastedTopicByColumn(7));
		util.fprint(root, "/body.ftl", outfile);
	}

}
