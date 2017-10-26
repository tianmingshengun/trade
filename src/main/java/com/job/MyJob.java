package com.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * quartz定时任务调度器
 * 
 * @author admin
 *
 */
@Component
public class MyJob  {
	
	/**
	 * 可引入外部service
	 */
	@Scheduled(cron="0/5 * * * * ? ")
	public void execute() {
		// 要实现的具体的业务逻辑
		System.out.println("haha此时此刻我们的任务终于要开始了。。。。。。。。。");

	}
	@Scheduled(cron="0/6 * * * * ? ")
	public void execute2() {
		// 要实现的具体的业务逻辑
		System.out.println("haha此时此刻我们的任务终于要开始了。。。。。。。。。");

	}
}