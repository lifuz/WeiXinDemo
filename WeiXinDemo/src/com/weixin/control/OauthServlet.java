package com.weixin.control;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		

		//用户同意授权后，能获取到 code
		String code = request.getParameter("code");
		
		request.setAttribute("code", code);
		
		
		request.getRequestDispatcher("./Oauth.jsp").forward(request, response);

	}

}
