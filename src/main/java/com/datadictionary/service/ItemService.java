package com.datadictionary.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datadictionary.dao.ItemDao;
import com.datadictionary.entity.Item;

/**
 * 数据字典条目服务类
 * 
 * @author admin
 *
 */
@Service
@Transactional
public class ItemService {

	@Autowired
	ItemDao itemDao;

	public List<Item> getItemList(String name) {
		return itemDao.getItemListByName(name);
	}

}
