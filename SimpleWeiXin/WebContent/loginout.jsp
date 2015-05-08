<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
<title>欢迎登陆云智造平台</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Login and Registration Form with HTML5 and CSS3" />
<meta name="keywords"
	content="html5, css3, form, switch, animation, :target, pseudo-class" />
<meta name="author" content="Codrops" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta name="viewport"
	content="width=device-width, minimum-scale=1.0, maximum-scale=2.0" />
<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/animate-custom.css" />
</head>
<body>
	<div class="container">
		<!-- Codrops top bar 
		<div class="codrops-top">
			<a href=""> <strong>&laquo; Previous Demo: </strong>Responsive
				Content Navigator
			</a> <span class="right"> <a
				href=" http://tympanus.net/codrops/2012/03/27/login-and-registration-form-with-html5-and-css3/">
					<strong>Back to the Codrops Article</strong>
			</a>
			</span>
			<div class="clr"></div>
		</div>-->
		<!--/ Codrops top bar -->
		<!--  <header>
                <h1>Login and Registration Form <span>with HTML5 and CSS3</span></h1>
				<nav class="codrops-demos">
					<span>Click <strong>"Join us"</strong> to see the form switch</span>
					<a href="index.html" class="current-demo">Demo 1</a>
					<a href="index2.html">Demo 2</a>
					<a href="index3.html">Demo 3</a>
				</nav>
            </header>-->
		<section>
			<div id="container_demo">
				<!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
				<a class="hiddenanchor" id="toregister"></a> <a class="hiddenanchor"
					id="tologin"></a>
				<div id="wrapper">
					<div id="login" class="animate form">
						<form action="login" autocomplete="on" method="post">
							<h1>登 录</h1>
							<p>
								<label for="username" class="uname" data-icon="u">
									用户名或邮箱</label> <input id="username" name="user" required="required"
									type="text" placeholder=" 用户名邮箱" />
							</p>
							<p>
								<label for="password" class="youpasswd" data-icon="p">
									密码 </label> <input id="password" name="pass" required="required"
									type="password" placeholder="密码" />
							</p>
							<p class="keeplogin">
								<input type="checkbox" name="loginkeeping" id="loginkeeping"
									value="loginkeeping" /> <label for="loginkeeping">记住密码</label>
							</p>
							<p class="login button">
								<input type="submit" value="登录" />
							</p>
							<p class="change_link">
								还没有账号？ <a href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxb3d68c8c052dd522&redirect_uri=http%3a%2f%2fprd.hhzn.cn%2fSimpleWeiXin%2fRegister&response_type=code&scope=snsapi_base&state=123#wechat_redirect" class="to_register">注册</a>
							</p>
						</form>
					</div>

					<div id="register" class="animate form">
						<form action="RegisterAction" autocomplete="on" method="post">
							<h1>注 册</h1>
							<p>
								<label for="usernamesignup" class="uname" data-icon="u">你的用户名</label>
								<input id="usernamesignup" name="user" required="required"
									type="text" placeholder="用户名" />
							</p>
							<p>
								<label for="emailsignup" class="youmail" data-icon="e">
									你的邮箱</label> <input id="emailsignup" name="emailsignup"
									required="required" type="email" placeholder="邮箱地址" />
							</p>
							<p>
								<label for="passwordsignup" class="youpasswd" data-icon="p">你的密码
								</label> <input id="passwordsignup" name="pass" required="required"
									type="password" placeholder="密码" />
							</p>
							<p>
								<label for="passwordsignup_confirm" class="youpasswd"
									data-icon="p">验证密码</label> <input id="passwordsignup_confirm"
									name="passwordsignup_confirm" required="required"
									type="password" placeholder="验证密码" />
							</p>
							<p class="signin button">
								<input type="submit" value="注册" />
							</p>
							<p class="change_link">
								已有账号？ <a href="#tologin" class="to_register"> 前往登录 </a>
							</p>
						</form>
					</div>

				</div>
			</div>
		</section>
	</div>
</body>
</html>