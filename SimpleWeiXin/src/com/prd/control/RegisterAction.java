package com.prd.control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prd.connect.MySqlConnection;
import com.weixin.model.Data;
import com.weixin.model.ModelMessage;
import com.weixin.pojo.Token;
import com.weixin.util.CommonUtil;
import com.weixin.util.JsonUtils;


@WebServlet("/RegisterAction")
public class RegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String openid = request.getParameter("openid");
		
		Connection conn = MySqlConnection.getConnection();
		
		String sql = "insert into user_table(username,password,openid) values(?,?,?)";
		PreparedStatement pt;
		try {
			pt = conn.prepareStatement(sql);
			pt.setString(1, user);
			pt.setString(2, pass);
			pt.setString(3, openid);
			boolean flag = pt.execute();
			if(!flag) {
				ModelMessage mm = new ModelMessage();
				mm.setTouser(openid);
				mm.setTemplate_id("7S5O6b79HXQ7ggw3r0lgFYdQP0GbowXp6iyqgVoEbws");
				mm.setUrl("http://www.baidu.com");
				mm.setTopcolor("#FF0000");
				List<Data> list = new ArrayList<Data>();
				Data data = new Data();
				data.setName("first");
				data.setValue("尊敬的会员欢迎您！请保管好您的注册信息");
				data.setColor("#173177");
				list.add(data);
				data = new Data();
				data.setName("keyword1");
				data.setValue(user);
				data.setColor("#173177");
				list.add(data);
				data = new Data();
				data.setName("keyword2");
				data.setValue(pass);
				data.setColor("#173177");
				list.add(data);
				
				data = new Data();
				data.setName("remark");
				Token token = CommonUtil.getToken("wxb3d68c8c052dd522", "29a52ea81a40f40ccbd62a6526f6f7f2");
				
				String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
				
				url = url.replace("ACCESS_TOKEN", token.getAccessToken());
				data.setValue("使用过程中如果遇到什么问题，欢迎致电本公司的免费热线电话：4008888888");
				data.setColor("#173177");
				list.add(data);
				
				mm.setData(list);
				String json = JsonUtils.getJson(mm);
				CommonUtil.httpsRequest(url, "POST", json);
				request.setAttribute("msg", "注册成功");
			} else {
				request.setAttribute("msg", "注册失败" + flag);
			}
			request.getRequestDispatcher("./Login.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
