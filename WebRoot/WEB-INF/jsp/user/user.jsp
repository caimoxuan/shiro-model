<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>userPage</title>
    

  </head>
  
  <body>
	  	<table>
	  		<tr>
	  			<td id = "test">
	  				
	  			</td>
	  		</tr>
	  	</table>
  </body>
  
  <script type = "text/javascript">
function ajax() {

       //先声明一个异步请求对象
       var xmlHttpReg = null;
       if (window.ActiveXObject) {//如果是IE

           xmlHttpReg = new ActiveXObject("Microsoft.XMLHTTP");

       } else if (window.XMLHttpRequest) {

           xmlHttpReg = new XMLHttpRequest(); //实例化一个xmlHttpReg
       }

       //如果实例化成功,就调用open()方法,就开始准备向服务器发送请求
       if (xmlHttpReg != null) {
           xmlHttpReg.open("get", "<%=path %>/user/user.json", true);
           xmlHttpReg.send(null);
           xmlHttpReg.onreadystatechange = doResult; //设置回调函数

       }

       //回调函数
       //一旦readyState的值改变,将会调用这个函数,readyState=4表示完成相应

       //设定函数doResult()
       function doResult() {
           if (xmlHttpReg.readyState == 4) {//4代表执行完成
               if (xmlHttpReg.status == 200) {//200代表执行成功
                   //将xmlHttpReg.responseText的值赋给ID为resText的元素
                   document.getElementById("test").innerHTML = xmlHttpReg.responseText;
               }
           }
       }
   }
	window.onload = function(){
		ajax();
	}
  </script>
</html>
