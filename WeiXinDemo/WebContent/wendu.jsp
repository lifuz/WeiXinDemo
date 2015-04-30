<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta name="viewport"
	content="width=device-width, minimum-scale=1.0, maximum-scale=2.0" />
<title>云智造监控</title>
</head>
<body>

	<table>
		<tr>
			<td>大棚温度</td>
			<td><%=request.getAttribute("wendu")%>
		</tr>

		<tr>
			<td>大棚湿度</td>
			<td><%=request.getAttribute("shidu")%>
		</tr>

	</table>


</body>
</html>