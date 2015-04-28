package com.weixin.response;

/**
 * 回复文本消息
 * 
 * @author 半夏微凉
 *
 */
public class TextMessageResp extends BaseMessageResp {
	/**
	 * 回复的消息内容
	 */
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}
