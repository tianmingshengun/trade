package test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.baseutil.BaseJunitUtil;
import com.baseutil.PropertiesUtil;

/**
 * propeties工具类测试
 * @author admin
 *
 */
public class Properties extends BaseJunitUtil{
    @Autowired
	private static PropertiesUtil util;
	@Test
	public void test(){
		System.out.println(util.getPropsMap().toString());
	}

	
}
