package com.weixin.model;

import java.util.List;

public class ModelMessage {
	
	//接收方的openid
	private String touser;
	//模板的id
	private String template_id;
	//转向的url
	private String url;
	//顶端的颜色
	private String topcolor;
	//data的集合
	private List<Data> data;
	
	
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTopcolor() {
		return topcolor;
	}
	public void setTopcolor(String topcolor) {
		this.topcolor = topcolor;
	}
	public List<Data> getData() {
		return data;
	}
	public void setData(List<Data> data) {
		this.data = data;
	}
	

}
