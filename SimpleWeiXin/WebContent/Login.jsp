<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Cache-Control" content="no-cache" />
<meta name="viewport"
	content="width=device-width, minimum-scale=1.0, maximum-scale=2.0" />
<title>欢迎登陆云智造</title>
</head>
<body>

	<%
		String msg = (String) request.getAttribute("msg");

		if (null != msg) {
			out.print(msg + "\n");
		}
	%>


	<form action="login" method="post">
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
				<td colspan="2" align="center"><input type="submit" value="登陆"><a
					href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxb3d68c8c052dd522&redirect_uri=http%3a%2f%2fprd.hhzn.cn%2fWeiXinDemo%2fSimpleWeiXin%2fRegister&response_type=code&scope=snsapi_base&state=123#wechat_redirect">注册</a></td>
			</tr>
		</table>

	</form>

</body>
</html>