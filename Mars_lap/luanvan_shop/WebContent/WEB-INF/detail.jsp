<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<spring:url value="../css/bootstrap.min.css" var="bootstrap" />
<spring:url value="../css/font-awesome.min.css" var="fonte" />
<spring:url value="../css/prettyPhoto.css" var="prettyPhoto" />
<spring:url value="../css/price-range.css" var="pricee" />
<spring:url value="../css/animate.css" var="animate" />
<spring:url value="../css/main.css" var="main" />
<spring:url value="../css/responsive.css" var="responsive" />
<spring:url value="images" var="images" />

<link href="${bootstrap}" rel="stylesheet" />
<link href="${fonte}" rel="stylesheet" />
<link href="${prettyPhoto}" rel="stylesheet" />
<link href="${pricee}" rel="stylesheet" />
<link href="${animate}" rel="stylesheet" />
<link href="${main}" rel="stylesheet" />
<link href="${responsive}" rel="stylesheet" />
<script src="../js/jquery.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/jquery.scrollUp.min.js"></script>
<script src="../js/price-range.js"></script>
<script src="../js/jquery.prettyPhoto.js"></script>
<script src="../js/main.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Thời trang - LVShopper</title>
</head>
<body>
	<%
		Date thoigian = new Date();
		SimpleDateFormat giophut = new SimpleDateFormat("HH:mm:ss dd/mm/yyyy");
		SimpleDateFormat ngaythang = new SimpleDateFormat("dd/mm/yyyy");
		String showtime = giophut.format(thoigian.getTime());
	%>
	<jsp:include page="include/header.jsp"></jsp:include>
	<!-- ------------------------------------ -->
	<section id="slider"><!--slider-->
	<div class="container">
		<div class="row">
			<jsp:include page="include/catelogy.jsp"></jsp:include>
			<div class="col-sm-9 padding-right">
				<div class="product-details">
					<!--product-details-->
					<div class="col-sm-5">
						<div class="view-product">
							<img src="../${hinhanh}.jpg" alt="" />

						</div>

					</div>
					<div class="col-sm-7">
						<div class="product-information">
							<!--/product-information-->
							<img src="../images/product-details/new.jpg" class="newarrival"
								alt="" />
							<h2>${tensanpham}</h2>
							<p>Mã sản phẩm: ${idsp}</p>
							<span> <span>${gia} VNĐ</span>
								<p>
									<button type="button" class="btn btn-fefault cart">
										<i class="fa fa-shopping-cart"></i> Thêm vào giỏ hàng
									</button>
								</p>
							</span>
							<p>
								<b>Số lượng:</b> ${soluong} sản phẩm
							</p>
							<p>
								<b>Giảm giá:</b> ${giamgia} %
							</p>
							<a href=""><img src="../images/product-details/share.png"
								class="share img-responsive" alt="" /></a>
						</div>
						<!--/product-information-->
					</div>
				</div>
				<!--/product-details-->

				<div class="category-tab shop-details-tab">
					<!--category-tab-->
					<div class="col-sm-12">
						<ul class="nav nav-tabs">
							<li><a href="#details" data-toggle="tab">Chi tiết</a></li>
							<li class="active"><a href="#reviews" data-toggle="tab">Phản
									hồi</a></li>
						</ul>
					</div>
					<div class="tab-content">
						<div class="tab-pane fade " id="details">
							<div class="col-sm-12">
								<p>${chitiet}</p>
							</div>
						</div>
						<div class="tab-pane fade active in" id="reviews">
							<div class="col-sm-12">
								<ul>
									<li><a href=""><i class="fa fa-user"></i><%=session.getAttribute("username")%></a></li>
									<li><a href=""><i class="fa fa-clock-o"></i><%=showtime%></a></li>
									<!-- <li><a href=""><i class="fa fa-calendar-o"></i>2016</a></li>
									 -->
								</ul>
								<p>Quý khách có thể gửi yêu cầu bất cứ lúc hoặc liên hệ bộ
									phận Chăm sóc khách hàng theo số Hotline XXXXXXXX (1000 VND/
									phút) trong các giờ làm việc sau: Thứ Hai - Thứ Sáu: từ 7h đến
									20h Thứ Bảy: từ 7h đến 18h Chủ Nhật và ngày lễ: từ 8h đến 17h
									rất hân hạnh được hỗ trợ quý khách..</p>
								<p>
									<b>Gửi thông tin phản hồi</b>
								</p>

								<form action="#">
									<span> <input type="text" placeholder="Tên khách hàng" />
										<input type="email" placeholder="Địa chỉ Email" />
									</span>
									<textarea name=""></textarea>
									<b>Rating: </b> <img src="../images/product-details/rating.png"
										alt="" />
									<button type="button" class="btn btn-default pull-right">
										Submit</button>
								</form>
							</div>
						</div>

					</div>
				</div>
				<!--/category-tab-->
			</div>
		</div>
	</div>
	</section>





	<!-- ------------------------------------ -->
	<jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html>