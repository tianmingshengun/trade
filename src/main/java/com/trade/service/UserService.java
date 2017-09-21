package com.trade.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trade.dao.UseDao;
import com.trade.entity.User;

/**
 * 用户数据服务层
 * @author admin
 *
 */
@Service
public class UserService {
   
	@Autowired  
	UseDao userDao;  
	
	/**
	   * 添加用户
	   * @param user
	   */
	  @Transactional
	  public void saveUser(User user){
		    userDao.saveUser(user);
	  }
}
