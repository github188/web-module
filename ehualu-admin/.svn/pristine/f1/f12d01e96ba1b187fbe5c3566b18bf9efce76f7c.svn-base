package com.ehualu.rise.controller.job;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ehualu.cms.pojo.job.Job;
import com.ehualu.cms.service.job.JobService;
import com.ehualu.rise.auth.AuthClass;
import com.ehualu.rise.page.Pager;


@Controller
@AuthClass
@RequestMapping("/admin/job")
public class JobController {
	private JobService jobService;

	public JobService getJobService() {
		return jobService;
	}
	@Inject
	public void setJobService(JobService jobService) {
		this.jobService = jobService;
	}

	@RequestMapping("/jobs")
	public String listChild(Model model) {
		Pager<Job> jobs = jobService.listJob();
		model.addAttribute("datas",jobs);
		return "job/list";
	}
	
	/**
	 * 跳转到添加界面
	 * @param pid
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute(new Job());
		return "job/add";
	}
	
	/**
	 * 执行添加操作
	 * @param pid
	 * @param job
	 * @param br
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(Job job,Model model) {
		jobService.add(job);
		return "redirect:/admin/job/jobs";
	}
	
	/**
	 * 跳转到任务更新界面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String update(@PathVariable int id,Model model) {
		Job c = jobService.load(id);
		model.addAttribute("job",c);
		return "job/update";
	}
	
	/**
	 * 更新任务
	 * @param id
	 * @param job
	 * @param br
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	public String update(@PathVariable int id,Job job,BindingResult br,Model model) {
		if(br.hasErrors()) {	
			return "job/update";
		}
		jobService.update(job);
		return "redirect:/admin/job/jobs";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Integer id,Model model) {
		jobService.delete(id);
		return "redirect:/admin/job/jobs";
	}
	
	
}
