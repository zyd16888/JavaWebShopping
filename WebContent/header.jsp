<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		//页面 加载时 获取商品分类信息
		$(function() {
			//发送一个请求 -> jQuery ajax 通过HTTP请求加载远程数据
			$.ajax({
				url : "category",
				type : "post"
			});

		})
	</script>



	<!--
            	描述：菜单栏
            -->
	<div class="container-fluid">
		<div class="col-md-4">
			<img src="img/logo3.png" />
		</div>
		<div class="col-md-3" style="padding-top: 20px">
			<ol class="list-inline">
				<li>${user.username}</li>
				<li><a href="login.jsp">登录</a></li>
				<li><a href="register.jsp">注册</a></li>
				<li><a href="cart.htm">购物车</a></li>
			</ol>
			<!-- ${categoryList} -->
		</div>
	</div>
	<!--
            	描述：导航条
            -->
	<div class="container-fluid">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">首页</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<!-- 通过将头部独立出来便于修改一个jsp文件来修改所有头部
					通过查询数据库来得到所需要的数据
				 -->
						<c:forEach items="${categoryList }" var="category"
							varStatus="count">
							<c:choose>
								<c:when test="${count.index == 0 }">
								<!-- ? 后 跟执行的代码，通过代入cid来执行cid的查询 -->
									<li class="active"><a href="product?method=findProductListByCid&cid=${category.cid }">${category.cname }<span
											class="sr-only">(current)</span></a></li>
								</c:when>
								<c:otherwise>
									<li><a href="product?method=findProductListByCid&cid=${category.cid }">${category.cname }</a></li>
								</c:otherwise>

							</c:choose>
							<!-- <li><a href="#">${category.cname }</a></li> -->
						</c:forEach>

						<!-- 
					<li class="active"><a href="product_list.htm">手机数码<span
							class="sr-only">(current)</span></a></li>
					<li><a href="#">电脑办公</a></li>
					<li><a href="#">电脑办公</a></li>
					<li><a href="#">电脑办公</a></li>
					 -->
					</ul>
					<form class="navbar-form navbar-right" role="search">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Search">
						</div>
						<button type="submit" class="btn btn-default">Submit</button>
					</form>

				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
	</div>

</body>
</html>