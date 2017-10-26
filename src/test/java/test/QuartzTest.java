package test;

import org.junit.Test;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.baseutil.BaseJunitUtil;
/**
 * 任务调度
 * @author admin
 *
 */
public class QuartzTest extends BaseJunitUtil {
     
	  @Autowired
	  SchedulerFactoryBean schedulerFactory;
	  
	  @Test
	  public void execute(){
		   
		   try {
			schedulerFactory.getScheduler().start();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
}
