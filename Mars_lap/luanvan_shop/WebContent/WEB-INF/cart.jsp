<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.text.NumberFormat"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Thời trang - LVShopper</title>
<spring:url value="/css/bootstrap.min.css" var="bootstrap" />
<spring:url value="/css/font-awesome.min.css" var="fonte" />
<spring:url value="/css/prettyPhoto.css" var="prettyPhoto" />
<spring:url value="/css/price-range.css" var="pricee" />
<spring:url value="/css/animate.css" var="animate" />
<spring:url value="/css/main.css" var="main" />
<spring:url value="/css/responsive.css" var="responsive" />
<spring:url value="/images" var="images" />

<link href="${bootstrap}" rel="stylesheet" />
<link href="${fonte}" rel="stylesheet" />
<link href="${prettyPhoto}" rel="stylesheet" />
<link href="${pricee}" rel="stylesheet" />
<link href="${animate}" rel="stylesheet" />
<link href="${main}" rel="stylesheet" />
<link href="${responsive}" rel="stylesheet" />
<script src="/luanvan_shop/js/jquery.js"></script>
<script src="/luanvan_shop/js/bootstrap.min.js"></script>
<script src="/luanvan_shop/js/jquery.scrollUp.min.js"></script>
<script src="/luanvan_shop/js/price-range.js"></script>
<script src="/luanvan_shop/js/jquery.prettyPhoto.js"></script>
<script src="/luanvan_shop/js/main.js"></script>
</head>
<body>
	<jsp:include page="include/header.jsp"></jsp:include>

	<!-- ------------------------------------ -->


	<section id="slider"><!--slider-->
	<div class="container">
		<div class="row">
			<section id="cart_items">
			<div class="container">
				<div class="breadcrumbs">
					<ol class="breadcrumb">
						<li><a href="#">Home</a></li>
						<li class="active">Danh sách các mặt hàng</li>
					</ol>
				</div>
				<div class="table-responsive cart_info">
					<table class="table table-condensed">
						<thead>
							<tr class="cart_menu">
								<td class="image">Sản phẩm</td>
								<td class="description"></td>
								<td class="price"> Giá</td>
								<td class="quantity"> Số lượng</td>
								<td class="total"> Tổng tiền</td>
								<td></td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listmuahang}" var="lst">
								<tr>

									<td class="cart_product"><a href=""><img
											src="/luanvan_shop/${lst.getHinhanh()}.jpg" alt=""
											style="height: auto; width: 100%"></a></td>
									<td class="cart_description">
										<h4>
											<a href="">${lst.getTensanpham()}</a>
										</h4>
										<p>Mã sản phẩm: ${lst.getId_sanpham()}</p>
									</td>
									<td class="cart_price">
										<p>${lst.getDongia()} VNĐ</p>
									</td>
									<td class="cart_quantity">
										<div class="cart_quantity_button">
											<!--  
											<a class="cart_quantity_up" href=""> + </a> 
											-->
											<form style="float: left" class="cart_quantity_up" action="/luanvan_shop/cart.html/soluong/${cong}" method="post" >
												<input type="hidden" value="cong" name="action" />
												<button type="submit" class="cart_quantity_up"> 
													 +								
												</button>
											</form>
											
											<input
												class="cart_quantity_input" type="text" name="quantity"
												value="${lst.getSoluong()}" autocomplete="off" size="2">
											
											<form style="float: left" class="cart_quantity_up" action="/luanvan_shop/cart.html/soluong/${tru}" method="post" >
												<input type="hidden" value="tru" name="action" />
												<button type="submit" class="cart_quantity_up"> 
													 -								
												</button>
											</form>
											
											
											<!--  
											<a class="cart_quantity_down" href=""> - </a>
											-->
										</div>
									</td>
									<td class="cart_total">
										<p class="cart_total_price">${lst.getTong()} VNĐ</p>
									</td>
									<td class="cart_delete">
										<!-- 
										<a class="cart_quantity_delete"	href="">
											<i class="fa fa-times"></i>
										</a>
										 -->
										 <form action="/luanvan_shop/cart.html/${lst.getId_chitiethoadon()}" method="post" >
											<input type="hidden" value="xoahang" name="action" />
											<button type="submit" class="btn btn-fefault cart"> 
												<i class="fa fa-shopping-cart"></i> xóa								
											</button>
										</form>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			</section>
			<!--/#cart_items-->

			<section id="do_action">
			<div class="container">
				<div class="heading">
					<h3>Tính toán tổng tiền và phụ phí</h3>
					<p>Vui lòng nhập đầy đủ các thông tin bên dưới, sau đó nhấn
						thành tiền</p>
				</div>
				<div class="row">
					<div class="col-sm-6">
						<div class="chose_area">
							<form action="/luanvan_shop/cart.html" method="post">
								<input type="hidden" value="thanhtien" name="action" />

								<ul class="user_info">
									<li class="single_field"><label style="width: 500px">Tên
											tài khoản </label> <input type="text" placeholder="" name=""
										value="${username}" style="width: 500px" readonly /><br /></li>

								</ul>
								<ul class="user_info">
									<li class="single_field"><label style="width: 500px">Phương
											thức thanh toán</label> <input type="text"
										placeholder="Vui lòng nhập dữ liệu" name="phuongthucthanhtoan"
										value="${phuongthucthanhtoan}" style="width: 500px" /><br /></li>

								</ul>
								<ul class="user_info">
									<li class="single_field"><label style="width: 500px">Địa
											chỉ giao hàng</label> <input type="text"
										placeholder="Vui lòng nhập dữ liệu" name="diachigiaohang"
										value="${diachigiaohang}" style="width: 500px" /><br /></li>
								</ul>

								<!-- <button  type="submit" class="btn btn-default">Đăng ký</button> -->
								<ul class="user_info">
									<li><label>Thành phố giao hàng </label> <select
										name="city" value="${city}">
											<c:forEach items="${listcity}" var="listcity">
												<option value="${listcity.getCity()}"
													<c:if test="${listcity.getCity()==city}">selected</c:if>>${listcity.getCity()}</option>
											</c:forEach>
									</select>
									
									</li>

								</ul>
								<ul>
									<p style="color: red">${error}</p>
								</ul>
								<button type="submit" class="btn btn-default update">Thành
									tiền</button>
							</form>
						</div>
					</div>
					<div class="col-sm-6" style="display: ${tong_display};">
						<div class="total_area">
							<ul>
								<form action="/luanvan_shop/cart.html" method="post">
									<input type="hidden" value="thanhtoan" name="action" />

									<li>${diachigiaohang}<span>${city}</span></li>
									<li>${phuongthucthanhtoan}<span></span></li>
									<li>Ngày nhận hàng <span>${ngaynhan}</span></li>
									<li>Phí ship <span>${phiship} VNĐ</span></li>
									<li>Tổng thành tiền <span>${tongtien} VNĐ</span></li>


									<button type="submit" class="btn btn-default update">Thanh
										toán</button>
								</form>
							</ul>
							<!-- 
							<ul>
								<li>${diachigiaohang}<span>${city}</span></li>
								<li>${phuongthucthanhtoan}<span></span></li>
								<li>Ngày nhận hàng <span>${ngaynhan}</span></li>
								<li>Phí ship <span>${phiship}</span></li>
								<li>Tổng thành tiền <span>${tongtien} VNĐ</span></li>
							</ul>
							<a class="btn btn-default update" href="">Thanh toán</a>
							 -->

						</div>
					</div>
				</div>
			</div>
			</section>
			<!--/#do_action-->

		</div>
	</div>
	</section>





	<!-- ------------------------------------ -->
	<jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html>