package com.weixin.response;

/**
 * 图片消息
 * 
 */
public class ImageMessageResp extends BaseMessageResp {
	// 图片
	private Image Image;

	public Image getImage() {
		return Image;
	}

	public void setImage(Image image) {
		Image = image;
	}
}
