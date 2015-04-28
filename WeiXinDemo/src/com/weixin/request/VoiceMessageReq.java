package com.weixin.request;

/**
 * 收到的语音消息
 * 
 * @author 半夏微凉
 *
 */
public class VoiceMessageReq extends BaseMessageReq {
	/**
	 * 媒体ID
	 */
	private String MediaId;
	/**
	 * 语音格式
	 */
	private String Format;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}
}
