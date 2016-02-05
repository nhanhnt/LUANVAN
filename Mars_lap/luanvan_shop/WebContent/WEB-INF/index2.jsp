<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.shop.services.*"%>
<%@page import="com.shop.services.DmconStub.Getdmcon"%>
<%
DmchaStub dmcha=new DmchaStub();
DmconStub dmcon=new DmconStub();
Getdmcon dmc=new Getdmcon();


%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
 
<body>
	<div class="col-sm-3">
		<div class="left-sidebar">
			<h2>DANH MỤC</h2>
			<div class="panel-group category-products" id="accordian">

				<!--category-productsr-->
				<c:forEach var="p" items="${listdmcha}">

					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordian"
									href="#sportswear" name="iddm" value=${p.id_danhmuc}"> <span
									class="badge pull-right"><i class="fa fa-plus"></i></span>
									${p.tendanhmuc}
								</a>
							</h4>
						</div>
						
						<c:forEach var="pc" items="${listdmcon}">
							<div class="panel-body">
								<ul>
									<li><a href="#">${pc.tendanhmuc} </a></li>
								</ul>
							</div>
						</c:forEach>

					</div>
				</c:forEach>

			</div>
			<!--/category-products-->

			<div class="brands_products">
				<!--brands_products-->
				<h2>Brands</h2>
				<div class="brands-name">
					<ul class="nav nav-pills nav-stacked">
						<li><a href="#"> <span class="pull-right">(50)</span>Acne
						</a></li>
						<li><a href="#"> <span class="pull-right">(56)</span>Grüne
								Erde
						</a></li>
						<li><a href="#"> <span class="pull-right">(27)</span>Albiro
						</a></li>
						<li><a href="#"> <span class="pull-right">(32)</span>Ronhill
						</a></li>
						<li><a href="#"> <span class="pull-right">(5)</span>Oddmolly
						</a></li>
						<li><a href="#"> <span class="pull-right">(9)</span>Boudestijn
						</a></li>
						<li><a href="#"> <span class="pull-right">(4)</span>Rösch
								creative culture
						</a></li>
					</ul>
				</div>
			</div>
			<!--/brands_products-->


			<div class="shipping text-center">
				<!--shipping-->
				<img src="images/home/shipping.jpg" alt="" />
			</div>
			<!--/shipping-->

		</div>
	</div>

</body>
</html>