package com.baseutil;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试工具类基类
 * @author admin
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:springmvc.xml"})
public abstract class BaseJunitUtil {
	    @Before
		public void start(){
	    	System.out.println("+++++++++++++++++++++++++我要开始了");
	    }
	    @After
	    public void end(){
	    	System.out.println("+++++++++++++++++++++++++一切都结束了");
	    }
}
