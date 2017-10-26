package test;

import org.junit.Test;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.baseutil.BaseJunitUtil;
import com.job.MyJob;

/**
 * 任务调度
 * 
 * @author admin
 *
 */
public class QuartzTest extends BaseJunitUtil {

	@Autowired
	MyJob job;

	@Test
	public void execute() {
		//注解的方式
		job.execute();
		
		
		/**
                     配置文件的方式
		try {
			schedulerFactory.getScheduler().start();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
