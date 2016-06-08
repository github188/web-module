package com.ehualu.cms.service.job.task;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class Index extends QuartzJobBean {
	private static final Logger log = LoggerFactory.getLogger(Index.class);
	
	public void acquStart() {
		log.info("-----------Index 执行调度任务-----------" + System.currentTimeMillis());
	}

//	@Override
//	public void execute(JobExecutionContext arg0) throws JobExecutionException {
//		acquStart();
//	}

	@Override
	protected void executeInternal(JobExecutionContext context)throws JobExecutionException {
		acquStart();
	}
	

	

}
