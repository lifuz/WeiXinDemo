package com.weixin.response;

/**
 * 音乐消息
 */
public class MusicMessageResp extends BaseMessageResp {
	/**
	 * 音乐
	 */
	private Music Music;

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}
}
