package com.weixin.control;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.weixin.model.Data;
import com.weixin.model.ModelMessage;
import com.weixin.pojo.SNSUserInfo;
import com.weixin.pojo.Token;
import com.weixin.pojo.WinxinOauth2Token;
import com.weixin.util.AdvancedUtil;
import com.weixin.util.CommonUtil;
import com.weixin.util.JsonUtils;

/**
 * 授权后回调请求处理
 * 
 * @author 半夏微凉
 *
 */

@WebServlet("/OauthServlet")
public class OauthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		SNSUserInfo sui = null;

		// 用户同意授权后，能获取到 code
		String code = request.getParameter("code");

		if (code != null) {

			WinxinOauth2Token wat = AdvancedUtil.getOauth2AcessToken(
					"wxb3d68c8c052dd522", "29a52ea81a40f40ccbd62a6526f6f7f2",
					code);
//			sui = AdvancedUtil.getSNSUserInfo(wat.getAccessToken(), wat.getOpenId());
//			request.setAttribute("sui", sui);
			
			Token token = CommonUtil.getToken("wxb3d68c8c052dd522", "29a52ea81a40f40ccbd62a6526f6f7f2");
			
			String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
			
			url = url.replace("ACCESS_TOKEN", token.getAccessToken());
			
			ModelMessage mm = new ModelMessage();
			response.getWriter().print(wat.getOpenId());
			mm.setTouser(wat.getOpenId());
			mm.setTemplate_id("ZTEv4LPt3zCD-OZ1Go88cdGbZwlZ7SzAtJymZPhLcWM");
			mm.setUrl("http://www.baidu.com");
			mm.setTopcolor("#FF0000");
			List<Data> list = new ArrayList<Data>();
			Data data = new Data();
			data.setName("first");
			data.setValue("您好，您的智能设备已被成功绑定");
			data.setColor("#173177");
			list.add(data);
			data = new Data();
			data.setName("keyword1");
			data.setValue("0001");
			data.setColor("#173177");
			list.add(data);
			data = new Data();
			data.setName("keyword2");
			data.setValue("2014年7月21日 18:36");
			data.setColor("#173177");
			list.add(data);
			data = new Data();
			data.setName("keyword3");
			data.setValue("2");
			data.setColor("#173177");
			list.add(data);
			data = new Data();
			data.setName("remark");
			data.setValue("请认真核实绑定用户数量，及时更改绑定密码。");
			data.setColor("#173177");
			list.add(data);
			
			mm.setData(list);
			String json = JsonUtils.getJson(mm);
			CommonUtil.httpsRequest(url, "POST", json);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JSONObject jb = CommonUtil.httpsRequest(url, "POST", json);
			
			response.getWriter().print(jb.getInt("errcode"));
			response.getWriter().print(jb.getString("errmsg"));
			
			response.getWriter().flush();
		}
		
		

//		request.getRequestDispatcher("./Oauth.jsp").forward(request, response);

	}

}
