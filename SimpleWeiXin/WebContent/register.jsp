<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Cache-Control" content="no-cache" />
<meta name="viewport"
	content="width=device-width, minimum-scale=1.0, maximum-scale=2.0" />
<title>欢迎注册云制造平台</title>
</head>
<body>

	<form action="RegisterAction" method="post">
		<table align="center" cellpadding="1" cellspacing="0" border="1">
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="user">
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="pass">
			</tr>
			<tr>
				<td>验证密码：</td>
				<td><input type="password" name="pass1">
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="submit" value="注册"><input type="hidden" name="openid" value="<%= request.getAttribute("wat")%>"></td>
			</tr>
		</table>

	</form>

</body>
</html>