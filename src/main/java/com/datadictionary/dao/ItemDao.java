package com.datadictionary.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

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
	 * 
	 * @param item
	 */
	public void updateItem(Item item) {
		update(item);
	}

	/**
	 * 获取条目列表,通过名称
	 * 
	 * @param name
	 * @return
	 */
	public List getItemListByName(String name) {
		String sql = "SELECT id,name,code,description from item where 1=1 ";
		List<String> para = new ArrayList<String>();
		if (name != null && "".equals(name) == false) {
			sql += "and name=?";
			para.add(name);
		}
		Query query = createQuery(sql, para.toArray()).addEntity(Item.class);
		
		return query.getResultList();
	}
}
