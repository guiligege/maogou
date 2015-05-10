package org.guili.ecshop.bean.chongwu;

/**
 * 用于分页查询的参数
 * @author guili
 */
public class CwPageParam {
	//筛选条件
	private Long adressId;//宠物二级地址id
	private Long pAdressId;//宠物一级地址id
	private Long categoryId;//宠物类别
	private Integer status;//宠物状态
	//分页查询
//	private int start;
//	private int size;
	
	public Long getAdressId() {
		return adressId;
	}
	public void setAdressId(Long adressId) {
		this.adressId = adressId;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getpAdressId() {
		return pAdressId;
	}
	public void setpAdressId(Long pAdressId) {
		this.pAdressId = pAdressId;
	}
	
//	public int getStart() {
//		return start;
//	}
//	public void setStart(int start) {
//		this.start = start;
//	}
//	public int getSize() {
//		return size;
//	}
//	public void setSize(int size) {
//		this.size = size;
//	}
	
}
