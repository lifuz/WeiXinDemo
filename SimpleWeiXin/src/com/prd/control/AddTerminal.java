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


@WebServlet("/add")
public class AddTerminal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cardid = request.getParameter("card");
		HttpSession session = request.getSession();
		int id  = (int)session.getAttribute("id");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("utf-8");
		
		if(id == 0) {
			request.getAttribute("session已过期");
			request.getRequestDispatcher("./Login.jsp").forward(request, response);
			
		} else{
			Connection conn = MySqlConnection.getConnection();
			String sql = "insert into terminal(cardId,user) values(?,?)";
			try {
				PreparedStatement pt = conn.prepareStatement(sql);
				pt.setInt(1, Integer.parseInt(cardid));
				
				pt.setInt(2, id);
				boolean flag = pt.execute();
				String url = "";
				
				if(!flag) {
					sql = "select * from user_table where u_id =?";
					pt = conn.prepareStatement(sql);
					
					pt.setInt(1,id);
					ResultSet rs = pt.executeQuery();
					rs.next();
					String openid = rs.getString(4);
					System.out.println(openid);
					Token token = CommonUtil.getToken("wxb3d68c8c052dd522", "29a52ea81a40f40ccbd62a6526f6f7f2");
					
					url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
					
					url = url.replace("ACCESS_TOKEN", token.getAccessToken());
					
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
					String json = JsonUtils.getJson(mm);
					JSONObject jb = CommonUtil.httpsRequest(url, "POST", json);
					System.out.println(jb.getString("errcode"));
					
					url = "./show.jsp";
					out.println("<script type='text/javascript'>alert('添加成功!');location.href='"+ url +"';</script>");
				} else{
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
