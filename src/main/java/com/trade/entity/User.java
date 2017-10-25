package com.trade.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 用户实体类
 * 
 * @author admin
 *
 */
@Entity
@Table(name = "user")
public class User {
    
	
	
	private String id;
	private String name;
	
	@Id
	@GenericGenerator(name="MyGenerator",strategy="uuid")
	@GeneratedValue(generator="MyGenerator")	
	@Column(name="id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
    
	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
