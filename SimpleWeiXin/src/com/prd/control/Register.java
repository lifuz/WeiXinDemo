package com.prd.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weixin.pojo.SNSUserInfo;
import com.weixin.pojo.WinxinOauth2Token;
import com.weixin.util.AdvancedUtil;

/**
 * 注册控制页面
 * @author 半夏微凉
 *
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		SNSUserInfo sui = null;

		// 用户同意授权后，能获取到 code
		String code = request.getParameter("code");

		if (code != null) {
			WinxinOauth2Token wat = AdvancedUtil.getOauth2AcessToken(
					"wxb3d68c8c052dd522", "29a52ea81a40f40ccbd62a6526f6f7f2",
					code);
			
			//设置响应格式
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			
			request.getSession().setAttribute("newId", wat.getOpenId());
//			out.println("<script type='text/javascript'>alert('添加成功!');location.href='./loginout.jsp#toregister';</script>");
			
			response.sendRedirect("./loginout.jsp#toregister");
		}else{
			response.getWriter().print("错误");
		}

	}

}
