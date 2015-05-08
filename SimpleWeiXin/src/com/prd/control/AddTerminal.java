package com.prd.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import com.prd.connect.MySqlConnection;
import com.weixin.model.Data;
import com.weixin.model.ModelMessage;
import com.weixin.pojo.Token;
import com.weixin.util.CommonUtil;
import com.weixin.util.JsonUtils;
/**
 * 处理添加设备
 * @author 半夏微凉
 *
 */

@WebServlet("/add")
public class AddTerminal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取设备的编号
		String cardid = request.getParameter("card");
		HttpSession session = request.getSession();
		//获取用户的id
		int id  = (int)session.getAttribute("id");
		
		//设置响应格式
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("utf-8");
		
		if(id == 0) {
			//判断session是否过期
			request.getAttribute("session已过期");
			request.getRequestDispatcher("./Login.jsp").forward(request, response);
			
		} else{
			//如果session没有过期，向数据库添加设备
			Connection conn = MySqlConnection.getConnection();
			String sql = "insert into terminal(cardId,user) values(?,?)";
			try {
				PreparedStatement pt = conn.prepareStatement(sql);
				pt.setInt(1, Integer.parseInt(cardid));
				
				pt.setInt(2, id);
				boolean flag = pt.execute();
				String url = "";
				//判断设备是否添加成功
				if(!flag) {
					//如果添加成功，将设备绑定情况发送给用户，具体操作如下：
					//获取用户的openid
					sql = "select * from user_table where u_id =?";
					pt = conn.prepareStatement(sql);
					
					pt.setInt(1,id);
					ResultSet rs = pt.executeQuery();
					rs.next();
					String openid = rs.getString(4);
					System.out.println(openid);
					//获取微信访问的Token
					Token token = CommonUtil.getToken("wxb3d68c8c052dd522", "29a52ea81a40f40ccbd62a6526f6f7f2");
					//拼接发送数据的url
					url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
					
					url = url.replace("ACCESS_TOKEN", token.getAccessToken());
					//添加发送的内容
					ModelMessage mm = new ModelMessage();
					mm.setTouser(openid);
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
					data.setValue(new Date().toString());
					data.setColor("#173177");
					list.add(data);
					data = new Data();
					data.setName("keyword3");
					data.setValue("0");
					data.setColor("#173177");
					list.add(data);
					data = new Data();
					data.setName("remark");
					data.setValue("请认真核实绑定用户数量，及时更改绑定密码。");
					data.setColor("#173177");
					list.add(data);
					
					mm.setData(list);
					//将发送的内容，格式化成微信需要的样式
					String json = JsonUtils.getJson(mm);
					//发送设备绑定信息给用户
					JSONObject jb = CommonUtil.httpsRequest(url, "POST", json);
					System.out.println(jb.getString("errcode"));
					//处理设备绑定成功之后的操作，弹出对话框告知用户添加成功，并把页面转向之前的页面
					url = "./show.jsp";
					out.println("<script type='text/javascript'>alert('添加成功!');location.href='"+ url +"';</script>");
				} else{
					//处理设备绑定失败的操作
					url = "./show.jsp";
					out.println("<script type='text/javascript'>alert('添加失败!');location.href='"+ url +"';</script>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
