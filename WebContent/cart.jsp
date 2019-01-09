<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>会员登录</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
		<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="css/style.css" type="text/css" />
		<style>
			body {
				margin-top: 20px;
				margin: 0 auto;
			}
			
			.carousel-inner .item img {
				width: 100%;
				height: 300px;
			}
			
			.container .row div {
				/* position:relative;
	 float:left; */
			}
			
			font {
				color: #3164af;
				font-size: 18px;
				font-weight: normal;
				padding: 0 10px;
			}
		</style>
		<script type="text/javascript">
			function changeNumber(pid,obj,oldNumber) {
				/* alert(pid)
				alert(obj.value) */
				var number = obj.value;
				if(isNaN(number)){
					alert("数量必须为数字");
					//obj.value = oldNumber;
					return;
				}
				if(number < 0){
					alert("数量必须大于或等于0");
					obj.value = oldNumber;
					return;
				}
				if(number == 0){
					var f = confirm("确定删除吗?");
					 if(f == false){
						obj.value = oldNumber;
						 return;
					 }
					window.location.href = "cart?method=deleteCart&pid="+pid;
					return;
				}
				
				
				//向服务器发送请求修改数量
				window.location.href = "cart?method=changeNumber&pid="+pid+"&number="+number;
			}
			
			//删除购物车
			function deleteCart(pid) {
				//弹出一个确认框
				var f = confirm("确定删除？");
				
				if(f == false){
					return;
				}
				window.location.href = "cart?method=deleteCart&pid="+pid;
			}
			//清除购物车
			function clearCart() {
				//弹出一个确认框
				var f = confirm("确定清除购物车吗?")
				 if(f == false){
					 return;
				 }
				window.location.href = "cart?method=clearCart";	
			}
			
		</script>
		
	</head>
	<body>	
			<jsp:include page="header.jsp"></jsp:include>


		<div class="container">
			<div class="row">
				
				<div style="margin:0 auto; margin-top:10px;width:950px;">
					<strong style="font-size:16px;margin:5px 0;">订单详情</strong>
					<table class="table table-bordered">
						<tbody>
							<tr class="warning">
								<th>图片</th>
								<th>商品</th>
								<th>价格</th>
								<th>数量</th>
								<th>小计</th>
								<th>操作</th>
							</tr>

							<c:forEach items="${cart.cart }" var="cart">
								<tr class="active">
									<td width="60" width="40%">
										<input type="hidden" name="id" value="22">
										<img src="${cart.value.product.pimage }" width="70" height="60">
									</td>
									<td width="30%">
										<a target="_blank">${cart.value.product.pname }</a>
									</td>
									<td width="20%">
										${cart.value.product.shopPrice }
									</td>
									<td width="10%">
										<input type="text" name="count" value="${cart.value.number }" maxlength="4" size="10" onchange = "changeNumber(${cart.value.product.pid },this,${cart.value.number })">
									</td>
									<td width="15%">
										<span class="subtotal">${cart.value.price }</span>
									</td>
									<td>
										<a href="javascript:deleteCart(${cart.value.product.pid });" class="delete">删除</a>
									</td>
								</tr>
							</c:forEach>
							
						</tbody>
					</table>
				</div>
			</div>

			<div style="margin-right:130px;">
				<div style="text-align:right;">
					<em style="color:#ff6600;">
				登录后确认是否享有优惠&nbsp;&nbsp;
			</em> 赠送积分: <em style="color:#ff6600;">${cart.price }</em>&nbsp; 商品金额: <strong style="color:#ff6600;">${cart.price }</strong>
				</div>
				<div style="text-align:right;margin-top:10px;margin-bottom:10px;">
					<a href="javascript:clearCart()" id="clear" class="clear">清空购物车</a>
					<a href="order_info.htm">
						<input type="submit" width="100" value="提交订单" name="submit" border="0" style="background: url('./images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
						height:35px;width:100px;color:white;">
					</a>
				</div>
			</div>

		</div>

		<div style="text-align: center;margin-top: 5px;">
			<ul class="list-inline">
				<li><a>关于我们</a></li>
				<li><a>联系我们</a></li>
				<li><a>招贤纳士</a></li>
				<li><a>法律声明</a></li>
				<li><a>友情链接</a></li>
				<li><a target="_blank">支付方式</a></li>
				<li><a target="_blank">配送方式</a></li>
				<li><a>服务声明</a></li>
				<li><a>广告声明</a></li>
			</ul>
		</div>
		<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
			Copyright &copy; 2016-2017 翡翠教育 版权所有
		</div>

	</body>

</html>