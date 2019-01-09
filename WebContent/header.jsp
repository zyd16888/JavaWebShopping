<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
    <script>
<!--页面加载时获取商品分类信息-->
	/* $(function () {
		//发送请求
		$.ajax({
			url:"category",
			type:"post"
		});
	}) */

	</script>
    
<!--
            	描述：菜单栏
            -->
			<div class="container-fluid">
				<div class="col-md-4">
					<img src="img/logo3.png" />
				</div>
				<div class="col-md-3" style="padding-top:20px">
					<ol class="list-inline">
						<li>${user.username}</li>
						<li><a href="login.jsp">登录111</a></li>
						<li><a href="register.jsp">注册</a></li>
						<li><a href="cart.htm">购物车</a></li>
					</ol>
					
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
							<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
							<a class="navbar-brand" href="#">首页</a>
						</div>

						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav">
								<c:forEach items="${categoryList}" var="category" varStatus="count">
									<c:choose>
										<c:when test="${count.index == 0 }">
											<li class="active"><a href="product?method=findProductListByCid&cid=${category.cid }">${category.cname}<span class="sr-only">(current)</span></a></li>
										</c:when>
										<c:otherwise>
											<li><a href="product?method=findProductListByCid&cid=${category.cid }">${category.cname}</a></li>
										</c:otherwise>
									</c:choose>
									
								</c:forEach>
							
								<!-- <li class="active"><a href="product_list.htm">手机数码<span class="sr-only">(current)</span></a></li>
								<li><a href="#">电脑办公</a></li>
								<li><a href="#">电脑办公</a></li>
								<li><a href="#">电脑办公</a></li> -->
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