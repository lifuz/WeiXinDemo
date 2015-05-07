package com.prd.control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.prd.connect.MySqlConnection;


@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		
		response.setCharacterEncoding("utf-8");
		if(null == user || null == pass) {
			response.getWriter().println("账户或密码为空");
		}
		
		Connection conn = MySqlConnection.getConnection();
		
		String sql = "select * from user_table where username = ? and password = ?";
		
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, user);
			pst.setString(2, pass);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				HttpSession session = request.getSession();
				
				session.setAttribute("user", user);
				session.setAttribute("id", rs.getInt(1));
				request.getRequestDispatcher("./show.jsp").forward(request,
						response);

			} else {
				response.getWriter().println("账户或密码错误");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
