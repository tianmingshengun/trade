package com;
/**
 * 我的任务
 * @author admin
 *
 */
public class Myrunnable implements Runnable {

	public void run() {
	   
		 System.out.println("子线程id"+Thread.currentThread().getId());

	}

}
