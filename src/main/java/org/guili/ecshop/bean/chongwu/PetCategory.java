package org.guili.ecshop.bean.chongwu;

public class PetCategory {
 	private Long id;
 	private String  name;
 	private String refname;
 	private Long  parentType;
 	private int   status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getParentType() {
		return parentType;
	}
	public void setParentType(Long parentType) {
		this.parentType = parentType;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getRefname() {
		return refname;
	}
	public void setRefname(String refname) {
		this.refname = refname;
	}
	
}
