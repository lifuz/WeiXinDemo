package com.weixin.response;

/**
 * 语音消息
 * 
 */
public class VoiceMessageResp extends BaseMessageResp {
	// 语音
	private Voice Voice;

	public Voice getVoice() {
		return Voice;
	}

	public void setVoice(Voice voice) {
		Voice = voice;
	}
}

