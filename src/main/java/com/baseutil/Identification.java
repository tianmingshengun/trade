package com.baseutil;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * id标识
 * @author admin
 *
 */
@MappedSuperclass
public class Identification {
	
	private String id;
	
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

	
}
