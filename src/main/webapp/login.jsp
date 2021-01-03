<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="app.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>登录</title>
		<link rel="stylesheet" href="css/login.css" />
		<link rel="stylesheet" href="css/font-awesome.css"/>
		<link rel="icon" href="">
	</head>
	<body>

		<div class="lg-center">
			<p class="lg-listenner">在线人数：${applicationScope.count}</p>
			<div class="post">
				<div class="lg-zcyh">
					<a href="register.jsp" target="_parent"><label class="lg-zc" style="color: #00eeef">注册新用户>></label></a>
				</div>
				<span class="lg-little" align="center">用户登录</span>
				<form action="${appPath}/CssLoginServlet" method="get" name="login">
					<div class="lg-itemuser">
						<label class="lg-label">邮&nbsp;&nbsp;箱：</label>
						<input type="text" class="user-id" placeholder="邮箱" maxlength="50" name="email"/>
					</div>

					<div class="lg-itempwd">
						<label class="lg-label">密&nbsp;&nbsp;码：</label>
						<input type="password" class="user-pwd" placeholder="密码" maxlength="50"  name="password"/>
					</div>

					<div class="lg-type">
						<label class="lg-label">权&nbsp;&nbsp;限：</label>
						<select name="type">
							<option value="stu" selected="selected">学生</option>
							<option value="teach">教师</option>
							<option value="office">教务处</option>
						</select>
					</div>
					<input type="submit" class="user-sbt" value="登录"></input>
				</form>
			</div>
		</div>
	</body>
</html>
