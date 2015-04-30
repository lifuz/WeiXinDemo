<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<td>温度</td>
			<td><%=request.getAttribute("wendu")%>
		</tr>
		
		<tr>
			<td>湿度</td>
			<td><%=request.getAttribute("shidu")%>
		</tr>

	</table>


</body>
</html>