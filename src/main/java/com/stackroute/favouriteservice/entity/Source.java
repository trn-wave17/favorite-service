package com.stackroute.favouriteservice.entity;

import java.io.Serializable;

public class Source implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7001215355138358588L;
	
	private String id;
	private String name;
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Source [sourceId=" + id + ", sourceName=" + name + "]";
	}
	
	

	
	
}
