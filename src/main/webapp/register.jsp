<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="app.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>注册</title>
		<link rel="stylesheet" href="css/register.css" />
		<link rel="stylesheet" href="css/font-awesome.css" />
		<%--<link rel="icon" href="">--%>
	</head>
	<body>
		<div class="lg-center">
			<div class="post">
				<span class="lg-little" align="center">用户注册</span>
				<form action="${appPath}/CssRegisterServlet" method="get" name="login">
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
						<div class="lg-sbt">
							<input type="submit" class="user-sbt" value="注册"></input>
						</div>
					</form>
			</div>
		</div>
		
	</body>
</html>
