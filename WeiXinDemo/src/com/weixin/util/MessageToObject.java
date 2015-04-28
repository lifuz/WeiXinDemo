package com.weixin.util;

import org.dom4j.Document;
import org.dom4j.Element;

import com.weixin.request.ImageMessageReq;
import com.weixin.request.LinkMessageReq;
import com.weixin.request.LocationMessageReq;
import com.weixin.request.TextMessageReq;
import com.weixin.request.VideoMessageReq;
import com.weixin.request.VoiceMessageReq;

/**
 * 
 * 这个类的主要目的是把xml文件转换成与类型一致的对象
 * 要求把xml的每个节点都解析出来
 * @author 半夏微凉
 *
 */

public class MessageToObject {

	/**
	 * 将消息转换成文本类
	 * 
	 * @param document
	 * @return
	 */
	public static TextMessageReq messageToText(Document document) {
		
		Element root = document.getRootElement();
		TextMessageReq tm = new TextMessageReq();
		tm.setFromUserName(root.elementText("FromUserName"));
		tm.setToUserName(root.elementText("ToUserName"));
		tm.setCreateTime(Long.parseLong(root.elementText("CreateTime")));
		tm.setMsgType(root.elementText("MsgType"));
		tm.setContent(root.elementText("Content"));
		tm.setMsgId(Long.parseLong(root.elementText("MsgId")));

		return tm;
	}

	/**
	 * 将消息转换成图片类
	 * 
	 * @param document
	 * @return
	 */
	public static ImageMessageReq messageToImage(Document document) {

		Element root = document.getRootElement();
		ImageMessageReq im = new ImageMessageReq();
		im.setFromUserName(root.elementText("FromUserName"));
		im.setToUserName(root.elementText("ToUserName"));
		im.setCreateTime(Long.parseLong(root.elementText("CreateTime")));
		im.setMsgType(root.elementText("MsgType"));
		im.setMsgId(Long.parseLong(root.elementText("MsgId")));
		im.setMediaId(root.elementText("MediaId"));
		im.setPicUrl(root.elementText("PicUrl"));
		
		return im;
	}

	/**
	 * 将消息转换成语音类
	 * 
	 * @param document
	 * @return
	 */
	public static VoiceMessageReq messageToVoiec(Document document) {
		
		Element root = document.getRootElement();
		VoiceMessageReq vm= new VoiceMessageReq();
		vm.setFromUserName(root.elementText("FromUserName"));
		vm.setToUserName(root.elementText("ToUserName"));
		vm.setCreateTime(Long.parseLong(root.elementText("CreateTime")));
		vm.setMsgType(root.elementText("MsgType"));
		vm.setMsgId(Long.parseLong(root.elementText("MsgId")));
		vm.setMediaId(root.elementText("MediaId"));
		vm.setFormat(root.elementText("Format"));

		return vm;
	}

	/**
	 * 将消息转换成视频类或小视频类
	 * 
	 * @param document
	 * @return
	 */
	public static VideoMessageReq messageToVideo(Document document) {
		
		Element root = document.getRootElement();
		VideoMessageReq vm = new VideoMessageReq();
		vm.setFromUserName(root.elementText("FromUserName"));
		vm.setToUserName(root.elementText("ToUserName"));
		vm.setCreateTime(Long.parseLong(root.elementText("CreateTime")));
		vm.setMsgType(root.elementText("MsgType"));
		vm.setMsgId(Long.parseLong(root.elementText("MsgId")));
		vm.setMediaId(root.elementText("MediaId"));
		vm.setThumbMediaId(root.elementText("ThumbMediaId"));
		
		return vm;
	}

	/**
	 * 将消息转换成位置类
	 * 
	 * @param document
	 * @return
	 */
	public static LocationMessageReq messageToLocation(Document document) {
		
		Element root = document.getRootElement();
		LocationMessageReq lm = new LocationMessageReq();
		lm.setFromUserName(root.elementText("FromUserName"));
		lm.setToUserName(root.elementText("ToUserName"));
		lm.setCreateTime(Long.parseLong(root.elementText("CreateTime")));
		lm.setMsgType(root.elementText("MsgType"));
		lm.setMsgId(Long.parseLong(root.elementText("MsgId")));
		lm.setLocation_X(root.elementText("Location_X"));
		lm.setLocation_Y(root.elementText("Location_Y"));
		lm.setScale(root.elementText("Scale"));
		lm.setLabel(root.elementText("Label"));

		return lm;
	}

	/**
	 * 将消息转换成链接类
	 * 
	 * @param document
	 * @return
	 */
	public static LinkMessageReq messageToLink(Document document) {
		
		Element root = document.getRootElement();
		LinkMessageReq lm = new LinkMessageReq();
		lm.setFromUserName(root.elementText("FromUserName"));
		lm.setToUserName(root.elementText("ToUserName"));
		lm.setCreateTime(Long.parseLong(root.elementText("CreateTime")));
		lm.setMsgType(root.elementText("MsgType"));
		lm.setMsgId(Long.parseLong(root.elementText("MsgId")));
		lm.setTitle(root.elementText("Title"));
		lm.setDescription(root.elementText("Description"));
		lm.setUrl(root.elementText("Url"));

		return lm;
	}

}
