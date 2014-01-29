package com.heiji.fenling;
/**
 * 链接，这里是链接的一些属性
 * @author zu
 *
 */
public class Ling {

	 
	//链接
	public String link;
	//名字，简单说明
	public String name;
	//唯一id
	public String id;
	//级别
	public int level;
	//是否是最终的页面，是：true，是列表页面：false
	public boolean ling;
	
	public boolean isLing() {
		return ling;
	}
	public void setLing(boolean ling) {
		this.ling = ling;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	 
	
	
	
}
