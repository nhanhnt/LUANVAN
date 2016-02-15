<%@page import="java.text.NumberFormat"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.Catch"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="com.shop.services.*"%>
<%@page import="com.shop.services.SanphamStub.*"%>
<%@page import="com.shop.services.SanphamStub.Getsp"%>
<%
SanphamStub spstub=new SanphamStub();
Getsp sp=new Getsp();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Thời trang - LVShopper</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/prettyPhoto.css" rel="stylesheet">
<link href="css/price-range.css" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">
<link rel="shortcut icon" href="images/ico/favicon.ico">
</head>
<body>
	<div class="col-sm-9 padding-right">
		<div class="features_items">
			<!--features_items-->
			<h2 class="title text-center">Sản phẩm</h2>
			<%
				int abc=12;
				try {
					abc=Integer.parseInt(request.getParameter("iddm"));
				} catch (Exception e) {
					abc=12;
				}
				NumberFormat nf=NumberFormat.getInstance();
				nf.setMinimumIntegerDigits(0);
				sp.setDm(abc);
				GetspResponse ress = spstub.getsp(sp);
				for (int i = 0; i < ress.get_return().length; i++) {
			%>
			<div class="col-sm-4">
			
			
				<div class="product-image-wrapper">
					<div class="single-products">
						<div class="productinfo text-center">
							<img src="<%=ress.get_return()[i].getHinhanh() %>.jpg" alt="" />
							<h2><%=nf.format(Math.round(ress.get_return()[i].getDongia())) %> VNĐ</h2>
							<p><%=ress.get_return()[i].getTensanpham() %></p>
							<a href="cart.html" class="btn btn-default add-to-cart"><i
								class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</a>
						</div>
						<div class="product-overlay">
							<div class="overlay-content">
								<h2><%=nf.format(Math.round(ress.get_return()[i].getDongia())) %> VNĐ</h2>
								<p><%=ress.get_return()[i].getTensanpham() %></p>
								<a href="cart.html" class="btn btn-default add-to-cart"><i
									class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</a>
							</div>
						</div>
					</div>
					<div class="choose">
						<ul class="nav nav-pills nav-justified">
							<li><a href="detail.html/<%=ress.get_return()[i].getId_sanpham()%>" id="submit"><i class="fa fa-plus-square"></i>Xem chi tiết</a></li>
						</ul>
					</div>
				</div>
			</div>
			
			<%
				}
			%>
			

		</div>
		<!--features_items-->

	</div>
</body>
</html>