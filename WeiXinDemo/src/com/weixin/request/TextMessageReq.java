package com.weixin.request;

/**
 * 文本消息
 */

public class TextMessageReq extends BaseMessageReq {

	/**
	 * 收到的消息内容
	 */
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

}
