package com;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.baseutil.BaseJunitUtil;
/**
 * user数据测试
 * @author admin
 *
 */
import com.trade.entity.User;
import com.trade.service.UserService;
public class UserTest extends BaseJunitUtil {
      
	Logger log=Logger.getLogger(UserTest.class);
	
	@Autowired
	UserService service;
	
	@Test
	@Transactional//防止测试数据，污染数据库
	public void save(){
		User user=new User();
		
		//主键生成器声明之后，无需在设置主键，及时设置也没什么影响
		user.setName("ceshi");
		service.saveUser(user);
		log.info("哈哈，this is me");
	}
      
}
