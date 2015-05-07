package com.prd.control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prd.connect.MySqlConnection;


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
			if(pt.execute()) {
				request.setAttribute("msg", "注册成功");
			} else {
				request.setAttribute("msg", "注册失败");
			}
			request.getRequestDispatcher("./Login.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
