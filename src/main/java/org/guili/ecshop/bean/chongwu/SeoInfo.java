package org.guili.ecshop.bean.chongwu;

/**
 * seo 信息
 * @author Administrator
 *
 */
public class SeoInfo {
	
	private String title;
	private String keywords;
	private String description;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public SeoInfo(String title,String keywords, String description){
		this.title=title;
		this.keywords=keywords;
		this.description=description;
	}
}
