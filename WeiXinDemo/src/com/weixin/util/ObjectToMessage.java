package com.weixin.util;

import com.weixin.response.TextMessage;

/**
 * 这个类的作用就是,把要响应的类传入,然后返回成xml样式的字符串
 * 对于传入的参数必须每个属性都要有值,否则发送不成功
 * @author 半夏微凉
 *
 */

public class ObjectToMessage {

	/**
	 * 将文本类转换成相对应的字符串
	 * @param tm
	 * @return
	 */
	public static String TextToMessage(TextMessage tm) {
		String textTpl = "<xml>" + "<ToUserName><![CDATA[%1$s]]></ToUserName>"
				+ "<FromUserName><![CDATA[%2$s]]></FromUserName>"
				+ "<CreateTime>%3$s</CreateTime>"
				+ "<MsgType><![CDATA[%4$s]]></MsgType>"
				+ "<Content><![CDATA[%5$s]]></Content>"
				+ "<FuncFlag>%6$s</FuncFlag>" + "</xml>";

		return String.format(textTpl, tm.getToUserName(), tm.getFromUserName(),
				tm.getCreateTime(), tm.getMsgType(), tm.getContent(),
				tm.getFuncFlag());
	}

}
