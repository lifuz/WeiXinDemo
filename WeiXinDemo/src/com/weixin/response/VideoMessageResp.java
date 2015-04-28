package com.weixin.response;
/**
 * 视频消息
 *
 */
public class VideoMessageResp extends BaseMessageResp {
	// 视频
	private Video Video;

	public Video getVideo() {
		return Video;
	}

	public void setVideo(Video video) {
		Video = video;
	}
}

