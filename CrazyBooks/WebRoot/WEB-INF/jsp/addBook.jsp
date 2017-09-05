<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Register</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Fashion Mania Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 

















</script>
<!-- start menu -->
<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/memenu.js"></script>
<script>
	$(document).ready(function() {
		$(".memenu").memenu();
	});
</script>
<script src="js/simpleCart.min.js">
	
</script>
<!-- slide -->
<link href="css/popuo-box.css" rel="stylesheet" type="text/css"
	media="all" />
</head>
<body>
	<!--header-->
	<div class="header">
		<div class="header-top">
			<div class="container">
				<div class="col-md-4 world">
					<ul>
						<li><select class="in-drop">
								<option>English</option>
								<option>Japanese</option>
								<option>French</option>
						</select></li>
						<li><select class="in-drop1">
								<option>Dollar</option>
								<option>Euro</option>
								<option>Yen</option>
						</select></li>
					</ul>
				</div>
				<div class="col-md-4 logo">
					<a><img src="images/logo.png" alt=""></a>
				</div>

				<div class="col-md-4 header-left">
					<p class="log">
						<s:if test="#session.adminName!=null">
							<s:property value="#session.adminName" />
							<a href="adminDeleteSession.action">[注销]</a>
						</s:if>
						<s:else>
							<a href="ToUserLoginHtmlAction.action">登录</a>
							<span>or</span>
							<a href="ToUserRegisterHtmlAction.action">注册</a>
						</s:else>
					</p>
					<div class="cart box_1">
						<a href="checkout.html">
							<h3>
								<div class="total">
									<span class="simpleCart_total"></span>
								</div>
								<img src="images/cart.png" alt="" />
							</h3>
						</a>
						<p>
							<a href="javascript:;" class="simpleCart_empty">Empty Cart</a>
						</p>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="container">
			<div class="head-top">
				<div class="col-md-2 number">
					<span><i class="glyphicon glyphicon-phone"></i>085 596 234</span>
				</div>
				<div class="col-md-8 h_menu4">
					<ul class="memenu skyblue">
						<li><a href="#">用户管理</a>
							<div class="mepanel">
								<div class="row">
									<div class="col1">
										<div class="h_nav">
											<ul>
												<li><a href="AdminViewUsersAction?page=1">查看用户</a></li>
												<li><a href="AdminViewFreezeUsersAction?page=1">已封禁用户</a></li>
											</ul>
										</div>
									</div>
								</div>
							</div></li>
						<li><a href="#">图书管理</a>
							<div class="mepanel">
								<div class="row">
									<div class="h_nav">
										<ul>
											<li><a href="book-addBook" id="ADD" onclick="showTable()">添加图书</a></li>
											<li><a href="book-deleteBook?page=1">删除图书</a></li>
										</ul>
									</div>
								</div>
							</div></li>
						<li class="grid"><a href="#">信息统计</a>
							<div class="mepanel">
								<div class="row">
									<div class="h_nav">
										<ul>
											<li><a href="analyzeAction-analyze">新增图书</a></li>
										</ul>
									</div>
								</div>
							</div></li>
						<li><a class="color6" href="contact.html">帮助</a></li>
					</ul>
				</div>

				<div class="clearfix"></div>
				<!---pop-up-box---->
				<script type="text/javascript" src="js/modernizr.custom.min.js"></script>
				<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
				<!---//pop-up-box---->
				<div id="small-dialog" class="mfp-hide">
					<div class="search-top">
						<div class="login">
							<input type="submit" value=""> <input type="text"
								value="Type something..." onfocus="this.value = '';"
								onblur="if (this.value == '') {this.value = '';}">
						</div>
						<p>Shopping</p>
					</div>
				</div>
				<script>
					$(document).ready(function() {
						$('.popup-with-zoom-anim').magnificPopup({
							type : 'inline',
							fixedContentPos : false,
							fixedBgPos : true,
							overflowY : 'auto',
							closeBtnInside : true,
							preloader : false,
							midClick : true,
							removalDelay : 300,
							mainClass : 'my-mfp-zoom-in'
						});

					});
				</script>
				<!---->
			</div>
		</div>
	</div>
	<!--//header-->
	<!--图书信息-->
	<div class="container"
		style="width:1200px;height:300px;margin-top:20px;">
		<div style="border: #EBEBEB solid 2px;height: 100%;">
		<script type="text/javascript">
		function uploatPic()
		{
		$("uploadPic").submit();
		}
		function $(id)
		{
		return document.getElementById(id);
		}
		
		</script>
		<form action="book-saveBook" method="get">
			<table style="display: block;">
				<tr>
					<td style="font-size: x-large;width=:100%;height: 50px%;">图片路径</td>
					<td style="font-size: lager;width=:100%;height: 50px;">:<input type="text" name="price"/></td>
				</tr>
				<tr>
					<td style="font-size: x-large;width=:100%;height: 50px;">图书名称:</td>
					<td style="font-size: lager; width=:100%;height: 50px;"><input type="text" name="name"/>
					</td>
				</tr>
				<tr>
					<td style="font-size: x-large;width=:100%;height: 50px%;">二级分类:</td>
					<td style="font-size: lager;width=:100%;height: 50px;"><input type="text" name="category"/></td>
				</tr>
				<tr>
					<td style="font-size: x-large;width=:100%;height: 50px%;">原出版社</td>
					<td style="font-size: lager;width=:100%;height: 50px;">:<input type="text" name="pubHouse"/></td>
				</tr>
				<tr>
					<td style="font-size: x-large;width=:100%;height: 50px%;">作者</td>
					<td style="font-size: lager;width=:100%;height: 50px;">:<input type="text" name="author"/></td>
				</tr>
				<tr>
					<td style="font-size: x-large;width=:100%;height: 50px%;">价格</td>
					<td style="font-size: lager;width=:100%;height: 50px;">:<input type="text" name="price"/></td>
				</tr>
			</table>
			</form>
		</div>
	</div>
	<div class="container" style="width:1200px;margin-top:30px;">
		<div class="container" style="width:1200px;float:left;">
			<div>
				<a><font style="font-size: xx-large;color: #52D0C4;">详细信息</font></a>
			</div>
			<div style="width:85%;">
				<textarea style="width:400px;height:200px;" name="intro" value="这里写内容">
				</textarea>
			</div>
		</div>
		<div class="container" style="width:1200px;">
		</div>
	</div>

	<!--footer-->
	<div class="footer">
		<div class="footer-bottom">
			<div class="container">
				<div class="clearfix"></div>
				<p class="footer-class">
					Copyright &copy; 2015.Company name All rights reserved.<a
						target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>
				</p>
			</div>
		</div>
	</div>

	<!--//footer-->
</body>
</html>




