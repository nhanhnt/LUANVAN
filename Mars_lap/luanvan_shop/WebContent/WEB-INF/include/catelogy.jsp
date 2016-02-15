<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.shop.services.*"%>
<%@page import="com.shop.services.DmconStub.*"%>
<%@page import="com.shop.services.DmchaStub.*"%>
<%
	DmchaStub dmcha = new DmchaStub();
	DmconStub dmconstub = new DmconStub();
	Getdmcon dmcon = new Getdmcon();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>

</head>

<body>
	<div class="col-sm-3">
		<div class="left-sidebar">
			<h2>DANH MỤC</h2>
			<div class="panel-group category-products" id="accordian">

				<!--category-productsr-->
				<%
					for (int i = 0; i < dmcha.getdmcha(new Getdmcha()).get_return().length; i++) {
				%>

				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordian"
								href="#sportswear"> <span class="badge pull-right"><i
									class="fa fa-plus"></i></span> <%=dmcha.getdmcha(new Getdmcha()).get_return()[i].getTendanhmuc()%>
							</a>
						</h4>
					</div>
					<%
						dmcon.setDmcha(Integer.parseInt(dmcha.getdmcha(new Getdmcha()).get_return()[i].getId_danhmuc()));
						GetdmconResponse redmcon = dmconstub.getdmcon(dmcon);
						for (int j = 0; j < redmcon.get_return().length; j++) {
					%>
						<div class="panel-body">
							<ul>
								<li><a href="/luanvan_shop/index.html?iddm=<%=redmcon.get_return()[j].getId_danhmuc()%>"><%=redmcon.get_return()[j].getTendanhmuc() %></a></li>
							</ul>
						</div>
					<%
						}
					%>
				</div>
				<%
					}
				%>

			</div>
			<!--/category-products-->

			<div class="shipping text-center">
				<!--shipping-->
				<img src="/luanvan_shop/images/home/shipping.jpg" alt="" />
			</div>
			<!--/shipping-->
			<div style="clear: both;margin-bottom: 40px"></div>
		</div>
	</div>

</body>
</html>