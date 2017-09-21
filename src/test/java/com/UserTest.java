package com;

import javax.transaction.Transactional;

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
      
	
	
	@Autowired
	UserService service;
	
	@Test
	@Transactional//防止测试数据，污染数据库
	public void save(){
		User user=new User();
		//user.setId("110");
		user.setName("ceshi");
		service.saveUser(user);
	}
      
}
