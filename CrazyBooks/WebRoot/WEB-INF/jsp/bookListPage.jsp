<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<link href="css/popuo-box.css" rel="stylesheet" type="text/css">
<title>Home</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Fashion Mania Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- start menu -->
<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/zy_mainPage.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/memenu.js"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>
<script src="js/simpleCart.min.js"> </script>
<!-- slide -->
<script src="js/responsiveslides.min.js"></script>
   <script>
    $(function () {
      $("#slider").responsiveSlides({
      	auto: true,
      	speed: 500,
        namespace: "callbacks",
        pager: true,
      });
    });
  </script>
</head>
<body>
<!--header-->
<div class="header">
	<div class="header-top">
		<div class="container">
				<div class="col-sm-4 logo">
					<a href="index-mainPage"><img src="images/logo.png" alt=""></a>	
				</div>
				<div style="float:right;margin-right: 70px;margin-top: 20px;"><form method="post" action="book-findBooksBySomething.action">
				<input type="hidden" name="page" value="1"/>
				<input type="text" name="search" style="border:1px solid #52D0C4;width:200px;height: 40px;border-color: #52D0C4;"/><input type="submit" value="搜索" style="width:70px;height: 40px;background-color: #52D0C4;bor "/></form></div>
			<div class="col-sm-4 header-left">	
			<s:if test="#session.userName!=null">
			<p class="log">
						<a href="ToUserInfoHtmlAction.action"><s:property value="#session.userName"/></a><a
								href="UserdeleteUserSessionAction.action" style="cursor:hand">[注销]</a></p>
			</s:if>	
			<s:else>
					<p class="log"><a href="ToUserLoginHtmlAction.action"  >登陆</a>
						<span>or</span><a  href="ToUserRegisterHtmlAction.action"  >注册</a></p>
						</s:else>
					<div class="cart box_1">
						<a href="checkout.html">
						<h3> <div class="total">
							<span class="simpleCart_total"></span></div>
							<img src="images/cart.png" alt=""/></h3>
						</a>
						<p><a href="javascript:;" class="simpleCart_empty">Empty Cart</a></p>

					</div>
					<div class="clearfix"> </div>
			</div>
				<div class="clearfix"> </div>
		</div>
		</div>
		<div class="container">
			<div class="head-top">
				<div class="col-sm-2 number">
					<span><i class="glyphicon glyphicon-phone"></i>085 596 234</span>
				</div>
		 <div class="col-sm-8 h_menu4">
				<ul class="memenu skyblue">
				      <s:iterator var="clist" value="#session.cList">
				      <li class="grid"><a  href="book-findBooksByCid?page=1&&cid=<s:property value='#clist.id'/>"><s:property value="#clist.name"/></a>
				      <div class="mepanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<ul>
										<s:iterator var="ct" value="#clist.categorytwos">
										<li><a href="book-findboosByCoid?coid=<s:property value='#ct.id'/>&&page=1"><s:property value="#ct.name"/></a></li>
										</s:iterator>
									</ul>	
								</div>							
							</div>
						  </div>
						</div>
				      </s:iterator>
			  </ul> 
			</div>
				<div class="col-sm-2 search">		
		</div>
				</div>
				 <script>
						$(document).ready(function() {
						$('.popup-with-zoom-anim').magnificPopup({
							type: 'inline',
							fixedContentPos: false,
							fixedBgPos: true,
							overflowY: 'auto',
							closeBtnInside: true,
							preloader: false,
							midClick: true,
							removalDelay: 300,
							mainClass: 'my-mfp-zoom-in'
						});
																						
						});
				</script>			
	<!---->		
		</div>
	</div>
<!--content-->
<div class="products">
	<div class="container">
		<h1>Books</h1>
		<div class="col-md-9">
			<div class="content-top1">
			<s:iterator var="books" value="pageBean.list">
				<div class="col-md-4 col-md3">
					<div class="col-md1 simpleCart_shelfItem">
						<a href="book-findBookDetail.action?id=<s:property value='#books.id'/>">
							<img class="img-responsive" src="<s:property value='#books.picture'/>" alt="" />
						</a>
						<h3><a><s:property value='#books.name'/></a></h3>
						<div class="price">
								<h5 class="item_price">￥<s:property value='#books.price'/></h5>
								<a href="bookCart-addToCart.action?bid=<s:property value='#books.id'/>" class="item_add">Add To Cart</a>
								<div class="clearfix"> </div>
						</div>
					</div>
				</div>	
			</s:iterator>
			<div class="clearfix"> </div>
			</div>
			<div class="divPage">
			<s:if test="pageBean.page<pageBean.pageSize">
			<span class="spanPage"><a href="book-findBooksByCid?page=<s:property value='pageBean.page+1'/>&&cid=<s:property value='cid'/>" class="a1"><font style="font-size:20px;">下一页</font></a>
			</span>
			</s:if>
			<s:if test="pageBean.page>1">
			<span class="spanPage"><a href="book-findBooksByCid?page=<s:property value='pageBean.page-1'/>&&cid=<s:property value='cid'/>" class="a1"><font style="font-size:20px;">上一页</font></a>
			</span>
			</s:if>
			<span class="spanPage"><font style="font-size:20px;">第<s:property value="pageBean.page"/>/<s:property value="pageBean.pageSize"/></font></span></div>	
		</div>
		<div class="col-md-3 product-bottom">
			<!--categories-->
				<div class=" rsidebar span_1_of_left">
						<h3 class="cate">Categories</h3>
							 <ul class="menu-drop">
							<s:iterator var="c" value="#session.cList">
							<li class="item1"><big><s:property value="#c.name" /></big>
								<ul class="cute">
								<s:iterator var="ct" value="#c.Categorytwos">
									<li class="subitem1"><a href="book-findboosByCoid?coid=<s:property value='#ct.id'/>&&page=1"><s:property value="#ct.name" /> </a></li>
									</s:iterator>
								</ul>
								</s:iterator>
						</ul>
					</div>
				<!--initiate accordion-->
						<script type="text/javascript">
							$(function() {
							    var menu_ul = $('.menu-drop > li > ul'),
							           menu_a  = $('.menu-drop > li > a');
							    menu_ul.hide();
							    menu_a.click(function(e) {
							        e.preventDefault();
							        if(!$(this).hasClass('active')) {
							            menu_a.removeClass('active');
							            menu_ul.filter(':visible').slideUp('normal');
							            $(this).addClass('active').next().stop(true,true).slideDown('normal');
							        } else {
							            $(this).removeClass('active');
							            $(this).next().stop(true,true).slideUp('normal');
							        }
							    });
							
							});
						</script>
<!--//menu-->
<!--seller-->
				<div class="product-bottom">
						<h3 class="cate">Hot Book</h3>
						<s:iterator var="bn" value="#session.bnList">
					<div class="product-go">
						<div class=" fashion-grid">
							<a href="book-findBookDetail.action?id=<s:property value='#bn.id'/>"><img class="img-responsive " src="<s:property value="#bn.picture"/>" alt=""></a>	
						</div>
						<div class=" fashion-grid1">
							<h6 class="best2"><a href="single.html" ><s:property value="#bn.name"/></a></h6>
							<span class=" price-in1">￥<s:property value="#bn.price"/></span>
						</div>	
						<div class="clearfix"> </div>
					</div>
					</s:iterator>
				</div>

<!--//seller-->
<!--tag-->
				<div class="tag">	
						<h3 class="cate">Tags</h3>
					<div class="tags">
						<ul>
							<li><a href="#">design</a></li>
							<li><a href="#">fashion</a></li>
							<li><a href="#">lorem</a></li>
							<li><a href="#">dress</a></li>
							<li><a href="#">fashion</a></li>
							<li><a href="#">dress</a></li>
							<li><a href="#">design</a></li>
							<li><a href="#">dress</a></li>
							<li><a href="#">design</a></li>
							<li><a href="#">fashion</a></li>
							<li><a href="#">lorem</a></li>
							<li><a href="#">dress</a></li>
						<div class="clearfix"> </div>
						</ul>
				</div>					
			</div>
		</div>
		<div class="clearfix"> </div>
	</div>
</div>
<!--//content-->
<!--footer-->
<div class="footer">
	<div class="container">
		<div class="footer-top">
			<div class="col-md-4 top-footer1">
				<h2>Newsletter</h2>
					<form>
						<input type="text" value="" onfocus="this.value='';" onblur="if (this.value == '') {this.value ='';}">
						<input type="submit" value="SUBSCRIBE">
					</form>
			</div>
			<div class="clearfix"> </div>	
		</div>	
	</div>
	<div class="footer-bottom">
		<div class="container">
				<div class="clearfix"> </div>
				<p class="footer-class">Copyright &copy; 2015.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">crazybooks</a></p>
			</div>
	</div>
</div>

<!--//footer-->
</body>
</html>