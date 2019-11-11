<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body>

	<style type="text/css">
li {
	list-style: none;
	position: relative;
	margin-left: 450px;
}

#dl {
	text-align: center;
}

#error {
	list-style: none;
	position: relative;
	margin-left: 490px;
}
</style>
	<img src="images/top.png" alt="CSS3" style="align-content: center">


	<div>
		<div id="error">
			<c:if test="${rMes != null }">
				<span style="color: red;">${rMes }</span>
			</c:if>
		</div>

		<form class="contact_form"
			action="${pageContext.request.contextPath }/regist" method="post"
			name="contact_form" autocomplete="on">
			<ul>
				<li class="usually">
					<h2>用户注册</h2>
				</li>
				<li>帐 号:<input type="text" name="username" required /></li>
				<li>注册邮箱:<input type="email" name="email"
					placeholder="123456@qq.com" required /></li>
				<li>密 码:<input type="password" name="pwd" required /></li>
				<li>性 别:<input type="radio" name="sex" id="male" value="男"
					checked /> <label for="male">男</label> <input type="radio"
					id="female" name="sex" value="female" /> <label for="女">女</label></li>
				<li>身份证号:<input type="number" name="certificatenumber" required /></li>
				<li>用户类型:<input type="radio" name="customertype" id="typevip"
					value="会员用户" checked /> <label for="typevip">会员用户</label> <input
					type="radio" name="customertype" id="typesim" value="普通用户" /> <label
					for="typesim">普通用户</label></li>
				<li>验 &nbsp;证 &nbsp;码：<input type="text" placeholder="请输入验证码"
					required /></li>
				<li class="usually"><canvas id="canvas"></canvas> <a
					href="javascript:;" id="changeImg">再换一张</a><br /></li>
				<li>
					<button class="submit" type="submit">立即注册</button>
				</li> &nbsp;&nbsp;已有账号，
				<a href="${pageContext.request.contextPath }/login.jsp" id="dl">点此登录</a>
			</ul>
		</form>
	</div>
	<script type="text/javascript">
		function randomRgbColor() { //随机生成RGB颜色
			var r = Math.floor(Math.random() * 256); //随机生成256以内r值
			var g = Math.floor(Math.random() * 256); //随机生成256以内g值
			var b = Math.floor(Math.random() * 256); //随机生成256以内b值
			return "rgb(" + r + "," + g + "," + b + ")"; //返回rgb(r,g,b)格式颜色
		}
		window.onload = function() {
			draw();
			document.getElementById("changeImg").onclick = function() {
				draw();
			}
		}

		function draw() {
			var canvas = document.getElementById("canvas");
			var context = canvas.getContext("2d");
			canvas.width = 120;
			canvas.height = 40;
			context.strokeRect(0, 0, 120, 40);
			var aCode = "A,B,C,E,F,G,H,J,K,L,M,N,P,Q,R,S,T,W,X,Y,1,2,3,4,5,6,7,8,9";
			console.log(aCode.split(","));
			var aLength = aCode.split(",").length;
			for (var i = 0; i <= 3; i++) {
				var x = 20 + i * 20;
				var y = 20 + Math.random() * 10;
				var j = Math.floor(Math.random() * aLength);
				var deg = Math.random() * 90 * Math.PI / 180;//随机弧度
				var txt = aCode.split(",")[j];
				context.fillStyle = randomRgbColor();
				context.font = "bold 20px 微软雅黑";
				//修改坐标原点和旋转角度
				context.translate(x, y);
				context.rotate(deg);
				context.fillText(txt, 0, 0);
				//恢复坐标原点和旋转角度
				context.rotate(-deg);
				context.translate(-x, -y);
			}
			//干扰线
			for (var i = 0; i < 8; i++) {
				context.strokeStyle = randomRgbColor();
				context.beginPath();
				context.moveTo(Math.random() * 120, Math.random() * 40);
				context.lineTo(Math.random() * 120, Math.random() * 40);
				context.stroke();
			}
			/**绘制干扰点**/
			for (var i = 0; i < 20; i++) {
				context.fillStyle = randomRgbColor();
				context.beginPath();
				context.arc(Math.random() * 120, Math.random() * 40, 1, 0,
						2 * Math.PI);
				context.fill();
			}
		}
	</script>
</body>