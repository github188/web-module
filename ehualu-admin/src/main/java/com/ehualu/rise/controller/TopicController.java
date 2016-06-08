package com.ehualu.rise.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ehualu.cms.pojo.admin.Attachment;
import com.ehualu.cms.pojo.admin.ChannelTree;
import com.ehualu.cms.pojo.admin.User;
import com.ehualu.cms.pojo.topic.Topic;
import com.ehualu.cms.service.topic.AttachmentService;
import com.ehualu.cms.service.topic.ChannelService;
import com.ehualu.cms.service.topic.KeywordService;
import com.ehualu.cms.service.topic.TopicService;
import com.ehualu.cms.service.user.GroupService;
import com.ehualu.rise.auth.AuthClass;
import com.ehualu.rise.auth.AuthMethod;
import com.ehualu.rise.dto.AjaxObj;
import com.ehualu.rise.dto.TopicDto;
import com.ehualu.rise.page.SystemContext;
import com.ehualu.rise.service.IndexService;
import com.ehualu.rise.util.JsonUtil;

@Controller
@AuthClass("login")
@RequestMapping("/admin/topic")
public class TopicController {
	private TopicService topicService;
	private ChannelService channelService;
	private GroupService groupService;
	private KeywordService keywordService;
	private IndexService indexService;
	private AttachmentService attachmentService;
	public GroupService getGroupService() {
		return groupService;
	}

	@Inject
	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}
	
	public IndexService getIndexService() {
		return indexService;
	}

	public void setIndexService(IndexService indexService) {
		this.indexService = indexService;
	}

	public ChannelService getChannelService() {
		return channelService;
	}

	@Inject
	public void setChannelService(ChannelService channelService) {
		this.channelService = channelService;
	}

	public TopicService getTopicService() {
		return topicService;
	}

	@Inject
	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

	public AttachmentService getAttachmentService() {
		return attachmentService;
	}
	
	@Inject
	public void setAttachmentService(AttachmentService attachmentService) {
		this.attachmentService = attachmentService;
	}

	
	public KeywordService getKeywordService() {
		return keywordService;
	}

	@Inject
	public void setKeywordService(KeywordService keywordService) {
		this.keywordService = keywordService;
	}


	private final static List<String> imgTypes = Arrays.asList("jpg", "jpeg",
			"gif", "png");
	/**
	 * 初始化文章列表
	 * 
	 * @param con
	 * @param cid
	 * @param model
	 * @param session
	 * @param status
	 */
	private void initList(String con, Integer cid, Model model,
			HttpSession session, Integer status) {
		SystemContext.setSort("t.publishDate");
		SystemContext.setOrder("desc");
		boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
		if (isAdmin) {
			model.addAttribute("datas", topicService.find(cid, con, status));
		} else {
			User loginUser = (User) session.getAttribute("loginUser");
			// 根据用户，栏目和标题和状态进行检索
			model.addAttribute("datas",
					topicService.find(loginUser.getId(), cid, con, status));
		}
		if (con == null)
			con = "";
		SystemContext.removeOrder();
		SystemContext.removeSort();
		model.addAttribute("con", con);
		model.addAttribute("cid", cid);
		// 获取所有的可以发布文章的栏目，栏目的状态必须为启用状态
		model.addAttribute("cs", channelService.listPublishChannel());
	}

	/**
	 * 文章列表
	 * 
	 * @param con
	 * @param cid
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/audits")
	@AuthMethod(role = "ROLE_PUBLISH,ROLE_AUDIT")
	public String auditList(@RequestParam(required = false) String con,
			@RequestParam(required = false) Integer cid, Model model,
			HttpSession session) {
		initList(con, cid, model, session, 1);
		return "topic/list";
	}

	@RequestMapping("/unaudits")
	@AuthMethod(role = "ROLE_PUBLISH,ROLE_AUDIT")
	public String unauditList(@RequestParam(required = false) String con,
			@RequestParam(required = false) Integer cid, Model model,
			HttpSession session) {
		initList(con, cid, model, session, 0);
		return "topic/list";
	}

	/**
	 * 修改状态
	 * 
	 * @param id
	 *            文档id
	 * @param status
	 *            状态
	 * @return
	 */
	@RequestMapping("/changeStatus/{id}")
	@AuthMethod(role = "ROLE_AUDIT")
	public String changeStatus(@PathVariable int id, Integer status) {
		topicService.updateStatus(id);
		if (status == 0) {
			return "redirect:/admin/topic/unaudits";
		} else {
			return "redirect:/admin/topic/audits";
		}
	}

	@RequestMapping("/delete/{id}")
	@AuthMethod(role = "ROLE_PUBLISH")
	public String delete(@PathVariable int id, Integer status) {
		Topic t = topicService.load(id);
		topicService.delete(id);
		if (topicService.isUpdateIndex(t.getId())) {
			indexService.generateBody();
		}
		if (status == 0) {
			return "redirect:/admin/topic/unaudits";
		} else {
			return "redirect:/admin/topic/audits";
		}
	}

	/**
	 * 跳转到创建文章页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@AuthMethod(role = "ROLE_PUBLISH")
	public String add(Model model) {
		Topic t = new Topic();
		t.setPublishDate(new Date());
		TopicDto td = new TopicDto(t);
		model.addAttribute("topicDto", td);
		return "topic/add";
	}

	/**
	 * 创建文章
	 * 
	 * @param topicDto
	 * @param br
	 * @param aks
	 * @param aids
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Validated TopicDto topicDto, BindingResult br,
			String[] aks, Integer[] aids,HttpSession session,MultipartFile attach, HttpServletResponse resp) {
		if (br.hasErrors()) {
			return "topic/add";
		}
		try {
			if(attach.getSize() != 0){
				resp.setContentType("text/plain;charset=utf-8");
				Attachment att = new Attachment();
				String ext = FilenameUtils.getExtension(attach
						.getOriginalFilename());
				att.setIsAttach(0);
				att.setIsImg(1);
				att.setIsIndexPic(0);
				att.setNewName(String.valueOf(new Date().getTime()) + "." + ext);
				att.setOldName(FilenameUtils.getBaseName(attach.getOriginalFilename()));
				att.setSuffix(ext);
				att.setType(attach.getContentType());
				att.setSize(attach.getSize());
				// 添加附件信息
				attachmentService.add(att, attach.getInputStream());
				aids = new Integer[]{att.getId()};
			}
			Topic t = topicDto.getTopic();
			User loginUser = (User) session.getAttribute("loginUser");
			StringBuffer keys = new StringBuffer();
			if (aks != null) {
				for (String k : aks) {
					keys.append(k).append("|");
					keywordService.addOrUpdate(k);
				}
			}
			t.setKeyword(keys.toString());
			topicService.add(t, topicDto.getCid(), loginUser.getId(),aids);
			
			if (topicDto.getStatus() == 1 && topicService.isUpdateIndex(topicDto.getCid())) {
				indexService.generateBody();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "redirect:/admin/topic/audits";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	@AuthMethod(role = "ROLE_PUBLISH")
	public String update(@PathVariable int id, Model model) {
		Topic t = topicService.load(id);
		String keyword = t.getKeyword();
		if (keyword != null && !"".equals(keyword.trim()))
			model.addAttribute("keywords", keyword.split("\\|"));
		model.addAttribute("atts", attachmentService.listByTopic(id));
		TopicDto td = new TopicDto(t, t.getCid());
		model.addAttribute("topicDto", td);
		model.addAttribute("cname", t.getCname());
		return "topic/update";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(@PathVariable int id, @Validated TopicDto topicDto,
			BindingResult br,String[] aks, int isAttach,Integer[] aids,HttpSession session,MultipartFile attach, HttpServletResponse resp) {
		if (br.hasErrors()) {
			return "topic/update";
		}
		resp.setContentType("text/plain;charset=utf-8");
		try {
			if(attach.getSize() != 0){
				Attachment att = new Attachment();
				String ext = FilenameUtils.getExtension(attach
						.getOriginalFilename());
				att.setIsAttach(0);
				att.setIsImg(1);
				att.setIsIndexPic(0);
				att.setNewName(String.valueOf(new Date().getTime()) + "." + ext);
				att.setOldName(FilenameUtils.getBaseName(attach.getOriginalFilename()));
				att.setSuffix(ext);
				att.setType(attach.getContentType());
				att.setSize(attach.getSize());
				System.out.println("attach:"+attach);
				// 添加附件信息
				attachmentService.add(att, attach.getInputStream());
				aids = new Integer[]{att.getId()};
				attachmentService.delete(isAttach);
			}
			Topic tt = topicService.load(id);
			Topic t = topicDto.getTopic();
			StringBuffer keys = new StringBuffer();
			tt.setKeyword(keys.toString());
			tt.setChannelPicId(t.getChannelPicId());
			tt.setContent(t.getContent());
			tt.setPublishDate(t.getPublishDate());
			tt.setRecommend(t.getRecommend());
			tt.setStatus(t.getStatus());
			tt.setSummary(t.getSummary());
			tt.setTitle(t.getTitle());
			// 修改文章信息
			topicService.update(tt, topicDto.getCid(),aids);
			if (topicService.isUpdateIndex(topicDto.getCid())) {
				indexService.generateBody();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "redirect:/admin/topic/audits";
	}

	@RequestMapping("/{id}")
	public String show(@PathVariable int id, Model model) {
		model.addAttribute(topicService.load(id));
		return "topic/show";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	// 返回的是json类型的值，而uploadify只能接受字符串
	@AuthMethod(role = "ROLE_PUBLISH")
	public void upload(MultipartFile attach, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain;charset=utf-8");
		AjaxObj ao = null;
		try {
			Attachment att = new Attachment();
			String ext = FilenameUtils.getExtension(attach
					.getOriginalFilename());
			att.setIsAttach(0);
			if (imgTypes.contains(ext.toLowerCase())) {
				att.setIsImg(1);
			} else {
				att.setIsImg(0);
			}
			att.setIsIndexPic(0);
			att.setNewName(String.valueOf(new Date().getTime()) + "." + ext);
			att.setOldName(FilenameUtils.getBaseName(attach
					.getOriginalFilename()));
			att.setSuffix(ext);
			att.setType(attach.getContentType());
			att.setSize(attach.getSize());
			// 添加附件信息
			attachmentService.add(att, attach.getInputStream());
			ao = new AjaxObj(1, null, att);
		} catch (IOException e) {
			ao = new AjaxObj(0, e.getMessage());
		}
		resp.getWriter().write(JsonUtil.getInstance().obj2json(ao));
	}


	@RequestMapping("/treeAll")
	@AuthMethod(role = "ROLE_PUBLISH")
	public @ResponseBody
	List<ChannelTree> tree(HttpSession session) {
		boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
		User loginUser = (User) session.getAttribute("loginUser");
		if (isAdmin)
			return channelService.generateTree();
		else
			return groupService.generateUserChannelTree(loginUser.getId());
	}
}