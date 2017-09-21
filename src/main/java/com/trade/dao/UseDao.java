package com.trade.dao;

import org.springframework.stereotype.Repository;

import com.baseutil.HibernateBaseDao;
import com.trade.entity.User;
/**
 * 用户数据操作层
 * @author admin
 *
 */
@Repository
public class UseDao extends HibernateBaseDao<User> {
     /**
      * 添加用户 
      */
	public void saveUser(User user){
		 save(user);
	}
}
