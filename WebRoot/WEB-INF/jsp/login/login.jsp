<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script type = "text/javascript" src = "<%=path %>/assets/js/jquery-3.2.1.min.js"></script>
		<link rel="stylesheet" type="text/css" href="<%=path %>/assets/login/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="<%=path %>/assets/login/css/demo.css" />
		<link rel = "stylesheet" type = "text/css" href = "<%=path %>/assets/login/css/component.css" />
	</head>
	<body>
		<div class="container demo-1">
			<div class="content">
				<div id="large-header" class="large-header">
					<canvas id="demo-canvas"></canvas>
					<div class="logo_box">

						<form action="" name="f" method="post" id = "login_form">
							<div class="input_outer">
								<span class="u_user"></span>
								<input name="username" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入账户">
							</div>
							<div class="input_outer">
								<span class="us_uer"></span>
								<input name="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入密码">
							</div>
							<div class="mb2"><a class="act-but submit" href="javascript:;" style="color: #FFFFFF" onclick = "dologin()">登录</a></div>
						</form>
					</div>
				</div>
			</div>
		</div><!-- /container -->
		<script src="<%=path %>/assets/login/js/TweenLite.min.js"></script>
		<script src="<%=path %>/assets/login/js/EasePack.min.js"></script>
		<script src="<%=path %>/assets/login/js/rAF.js"></script>
		<script src="<%=path %>/assets/login/js/demo-1.js"></script>		
	</body>
	<script type = "text/javascript">
		 history.pushState(null, null, document.URL);
	     window.addEventListener('popstate', function () {
	         history.pushState(null, null, document.URL);
	     });
	     function　dologin(){
	    	document.getElementById("login_form").submit();
	     }
	     $(function(){
	    	var error = "${error}"+"";
	    	if(error != ""){
	    		alert(error);
	    	}
	     });
	
	</script>
</html>
