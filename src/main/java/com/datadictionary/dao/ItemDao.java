package com.datadictionary.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.baseutil.HibernateBaseDao;
import com.datadictionary.entity.Item;

/**
 * 条目操作类
 * 
 * @author admin
 *
 */
@Repository
public class ItemDao extends HibernateBaseDao<Item> {

	/**
	 * 添加条目
	 * 
	 * @param item
	 */
	public void saveItem(Item item) {
          save(item);
	}
    
	/**
	 * 更新条目
	 * @param item
	 */
	public void updateItem(Item item){
		 update(item);
	}
	/**
	 * 获取条目列表
	 * @param name
	 * @return
	 */
	public List getItemListByName(String name){
		List result=new ArrayList<>();
		String sql="SELECT id,name,code,description from item where 1=1 ";
		if(name !=null && "".equals(name)==false){
			
		}
				
		//createQuery
		return result;
	}
}
