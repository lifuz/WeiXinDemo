package com.weixin.request;

/**
 *	收到图片消息
 */
public class ImageMessage extends BaseMessage {
	
	/**
	 * 收到的图片链接
	 */
	private String picUrl;
	
	/**
	 * 收到图片的媒体id
	 * @return
	 */
	private String MediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
}
