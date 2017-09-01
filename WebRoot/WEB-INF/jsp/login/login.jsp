<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'login.jsp' starting page</title>
  </head>
  
  <body>
  		<form action = "" method = "post">
  			<table style = "border:1px solid black;margin:100px auto;">
  				<tr>
  					<td>
  						用户名：
  					</td>
  					<td>
			  			<input type = "text" name = "username" />
  					</td>
  				</tr>
  				<tr>
  					<td>
						密码：  					
  					</td>
  					<td>
			  			<input type = "password" name = "password" />
  					</td>
  				</tr>
  				<tr>
  					<td>
  						<input type = "submit" value = "登入" />
  						<input type = "reset" value = "重置" />
  					</td>
  				</tr>
  			</table>
  		</form>
  </body>
</html>
