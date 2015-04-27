package com.weixin.request;

/**
 *	收到图片消息
 */
public class ImageMessage extends BaseMessage {
	
	/**
	 * 收到的图片链接
	 */
	private String picUrl;

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
}
