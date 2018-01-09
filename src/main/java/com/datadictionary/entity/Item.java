package com.datadictionary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.baseutil.Identification;

/**
 * 数据字典条目实体类
 * @author admin
 *
 */
@Entity
@Table(name="item")
public class Item extends Identification {
	
	private String name;//名称	
	private String code;//编码
	private String description;//描述
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="code")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Column(name="description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
