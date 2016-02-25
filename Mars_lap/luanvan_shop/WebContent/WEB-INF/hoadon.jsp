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
						<li class="active">Danh sách các hóa đơn đã mua</li>
					</ol>
				</div>
				<div class="table-responsive cart_info">
					<table class="table table-condensed">
						<thead>
							<tr class="cart_menu">
								<td class="description">Địa chỉ giao hàng</td>
								<td class="description">Thành phố</td>
								<td class="description">Phương thức thanh toán</td>
								<td class="description">Ngày nhận</td>
								<td class="description">Phí ship</td>
								<td class="description">Tổng tiền</td>
								<td class="description">Trạng thái</td>
								<td></td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listhoadon}" var="lst">
								<tr>

									<td class="cart_description">
										<p>${lst.getDiachigiaohang()}</p>
									</td>
									<td class="cart_description">
										<p>${lst.getTpgiaohang()}</p>
									</td>
									<td class="cart_description">
										<p>${lst.getPhuongthucthanhtoan()}</p>
									</td>
									<td class="cart_description">
										<p>${lst.getNgaygiaohang()}</p>
									</td>
									<td class="cart_description">
										<p>${lst.getPhiship()} VNĐ</p>
									</td>
									<td class="cart_description">
										<p>${lst.getTongtien()} VNĐ</p>
									</td>
									<td class="cart_description">
										<p>${lst.getStatus()}</p>
									</td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div style="margin-left: 350px; text-align: right">
					<c:if test="${total>1}">
						<a href="hoadon.html?page=1" class="page dark gradient"><<&#160;</a> 
						<c:forEach begin="${start}" end="${end}" var="page">
							<a href="hoadon.html?page=${page}" class="page dark gradient">${page}&#160;</a>
						</c:forEach>
						<a href="hoadon.html?page=${total}" class="page dark gradient">&#160;>> </a>
					</c:if>
				</div>
			</div>
			</section>
			<!--/#cart_items-->
		</div>
	</div>
	</section>





	<!-- ------------------------------------ -->
	<jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html>