package com.weixin.control;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.weixin.request.TextMessageReq;
import com.weixin.util.MessageToObject;
import com.weixin.util.Utils;

/**
 * 本类是微信开发的控制类，包含网址接入，消息的中转等等
 * 
 * @author 半夏微凉
 *
 */

@WebServlet("/control")
public class Control extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 获取echostr，如果echostr不为空，则本次请求是为了验证消息真实性，
		// 如果echostr为空，则是用户发来的消息
		String echostr = request.getParameter("echostr");

		if (echostr == null) {

			// 判断消息的类型并根据逻辑进行转发
			selectMessage(request, response);

		} else {

			// 验证消息的真实性，如果为真，则把echostr返回给微信服务器，完成网址接入
			if (checkWeiXin(request, response)) {
				response.getWriter().print(echostr);
			}

		}

	}

	/**
	 * 根据消息类型将字符串转成与类型相对应的对象。
	 * 
	 * 根据处理的逻辑返回获得要返回的字符串
	 * 
	 * @param request
	 *            获取输入流
	 * @param response
	 *            将我们要响应的内容发送给微信服务器
	 */
	private void selectMessage(HttpServletRequest request,
			HttpServletResponse response) {

		String inStr = null;
		String outStr = null;
		// 将输入流转换成字符串
		try {
			inStr = Utils.readStreamParameter(request.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 将inStr转换成document对象,这里我使用dom4j解析xml
		Document document = null;
		try {
			document = DocumentHelper.parseText(inStr);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 获取根节点
		Element root = document.getRootElement();

		// 获取消息类型
		String msgType = root.elementText("MsgType");

		// 根据msgType得到应该转换的类，且根据内容，进行逻辑处理

		switch (msgType) {
		// 文本消息
		case "text":
			TextMessageReq tm = MessageToObject.messageToText(document);
			

			break;
		// 图片消息
		case "image":

			break;

		// 语音消息
		case "voice":

			break;

		// 视频消息
		case "video":

			break;

		// 小视频消息
		case "shortvideo":

			break;

		// 地理位置消息
		case "location":

			break;

		// 链接消息
		case "link":

			break;

		case "event":

			// 根据事件类型，选择处理逻辑
			switch (root.elementText("Event")) {
			// 订阅事件，分为不带参数和带参数
			case "subscribe":

				break;
			// 取消订阅事件
			case "unsubscribe":

				break;
			// 扫描带参数二维码事件, 用户已关注时的事件推送
			case "SCAN":

				break;
			// 上报地理位置事件
			case "LOCATION":

				break;
			// 自定义菜单事件
			// 点击菜单拉取消息时的事件推送
			case "CLICK":

				break;
			// 点击菜单跳转链接时的事件推送
			case "VIEW":

				break;

			}

			break;

		default:
			break;
		}

	}

	/**
	 * 这个方法是验证消息的真实性，如果为真返回true，否则返回false
	 */
	private boolean checkWeiXin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// 本地定义一个token，值要与微信公众平台上的一致
		String token = "prdweixin";
		// 详情请参见微信API
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");

		String[] temary = new String[] { token, timestamp, nonce };
		// 按字典顺序排序
		Arrays.sort(temary);
		String str = Utils.ArrayToString(temary);
		// 进行sha1加密
		str = Utils.SHA1Encode(str);

		if (str.equalsIgnoreCase(signature)) {

			return true;
		} else {
			return false;
		}
	}

}
