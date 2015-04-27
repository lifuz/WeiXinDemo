package com.weixin.util;

import org.dom4j.Document;
import org.dom4j.Element;

import com.weixin.request.ImageMessage;
import com.weixin.request.LinkMessage;
import com.weixin.request.LocationMessage;
import com.weixin.request.TextMessage;
import com.weixin.request.VideoMessage;
import com.weixin.request.VoiceMessage;

public class MessageToObject {

	/**
	 * 将消息转换成文本类
	 * 
	 * @param document
	 * @return
	 */
	public static TextMessage messageToText(Document document) {
		
		Element root = document.getRootElement();
		TextMessage tm = new TextMessage();
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
	public static ImageMessage messageToImage(Document document) {

		Element root = document.getRootElement();
		ImageMessage im = new ImageMessage();
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
	public static VoiceMessage messageToVoiec(Document document) {
		
		Element root = document.getRootElement();
		VoiceMessage vm= new VoiceMessage();
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
	public static VideoMessage messageToVideo(Document document) {
		
		Element root = document.getRootElement();
		VideoMessage vm = new VideoMessage();
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
	public static LocationMessage messageToLocation(Document document) {
		
		Element root = document.getRootElement();
		LocationMessage lm = new LocationMessage();
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
	public static LinkMessage messageToLink(Document document) {
		
		Element root = document.getRootElement();
		LinkMessage lm = new LinkMessage();
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
