package com.entity;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	
	public Customer(){
		super();
	}
	public Customer(int id,String name){
		super();
		this.id=id;
		this.name=name;
		
	}
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	
	@Override
	  public String toString() {
		return  "ID : " +id+ "\tName : " +name;}
}

