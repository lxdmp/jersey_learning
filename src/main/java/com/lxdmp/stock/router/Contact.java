package com.lxdmp.stock.router;

import java.io.Serializable;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Contact implements Serializable 
{
	private static final long serialVersionUID = -7173815854883493337L;
	
	//@FormParam("id")
	private String id;
	
	//@FormParam("name")
	private String name;
	
	//@FormParam("no")
	private String no;
	
	@Override
	public int hashCode() 
	{
		return (this.id.length()+this.name.length())%128;
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		return this.id==other.id;
	}
	
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
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
}
