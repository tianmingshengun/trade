package test;

/**
 * 我的线程
 * 
 * @author admin
 *
 */
public class Mythread extends Thread {
	private int i = 10;
	private Object object = new Object();

	@Override
	public void run() {
		synchronized (object) {
           i++;
           System.out.println("i:"+i);
           try {
			System.out.println("线程"+Thread.currentThread().getName()+"进入睡眠状态");
		    Thread.currentThread().sleep(10000);
		    
           } catch (Exception e) {
			// TODO: handle exception
		}
           System.out.println("线程"+Thread.currentThread().getName()+"睡眠结束");
           i++;
           System.out.println("i:"+i);
           
		}

	}

}
