package com.job;

/**
 * quartz定时任务调度器
 * 
 * @author admin
 *
 */
public class MyJob  {
	
	/**
	 * 可引入外部service
	 */
	public void execute() {
		// 要实现的具体的业务逻辑
		System.out.println("haha此时此刻我们的任务终于要开始了。。。。。。。。。");

	}
    
}