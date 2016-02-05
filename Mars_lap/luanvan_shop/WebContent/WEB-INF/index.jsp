<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<spring:url value="css/bootstrap.min.css" var="bootstrap" />
<spring:url value="css/font-awesome.min.css" var="fonte" />
<spring:url value="css/prettyPhoto.css" var="prettyPhoto" />
<spring:url value="css/price-range.css" var="pricee" />
<spring:url value="css/animate.css" var="animate" />
<spring:url value="css/main.css" var="main" />
<spring:url value="css/responsive.css" var="responsive" />
<spring:url value="images" var="images" />

<link href="${bootstrap}" rel="stylesheet" />
<link href="${fonte}" rel="stylesheet" />
<link href="${prettyPhoto}" rel="stylesheet" />
<link href="${pricee}" rel="stylesheet" />
<link href="${animate}" rel="stylesheet" />
<link href="${main}" rel="stylesheet" />
<link href="${responsive}" rel="stylesheet" />
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.scrollUp.min.js"></script>
<script src="js/price-range.js"></script>
<script src="js/jquery.prettyPhoto.js"></script>
<script src="js/main.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>



<!-- 
<link href="css/bootstrap.min.css" rel="stylesheet"/>
<link href="/css/font-awesome.min.css" rel="stylesheet"/>
<link href="/css/prettyPhoto.css" rel="stylesheet"/>
<link href="/css/price-range.css" rel="stylesheet"/>
<link href="css/animate.css" rel="stylesheet"/>
<link href="css/main.css" rel="stylesheet"/>
<link href="css/responsive.css" rel="stylesheet"/>
<link rel="shortcut icon" href="images/ico/favicon.ico"/>
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.scrollUp.min.js"></script>
<script src="js/price-range.js"></script>
<script src="js/jquery.prettyPhoto.js"></script>
<script src="js/main.js"></script>
 -->
</head>
<body>
	<!-- 
	<h1>${msg}</h1>
	<h1>${msgservices}</h1>
	
	<table cellpadding="2" cellspacing="2" border="1">
		<tr>
			<th>id_danhmuc</th>
			<th>tendanhmuc</th>
			<th>danhmuccha</th>
			<th>created</th>
			<c:forEach var="p" items="${listdmcha}">
				<tr>
					<td>${p.id_danhmuc}</td>
					<td>${p.tendanhmuc}</td>
					<td>${p.danhmuccha}</td>
					<td>${p.created}</td>
				</tr>
			</c:forEach>			
		</tr>
	</table>
	 -->
	<!-- 
	 <table cellpadding="2" cellspacing="2" border="1">
		<tr>
			<th>id_danhmuc</th>
			<th>tendanhmuc</th>
			<th>danhmuccha</th>
			<th>created</th>
			<c:forEach var="p" items="${listdmcon}">
				<tr>
					<td>${p.id_danhmuc}</td>
					<td>${p.tendanhmuc}</td>
					<td>${p.danhmuccha}</td>
					<td>${p.created}</td>
				</tr>
			</c:forEach>			
		</tr>
	</table>
	 -->
	<jsp:include page="include/header.jsp"></jsp:include>
	<jsp:include page="include/slide.jsp"></jsp:include>
	<!-- ------------------------------------ -->




	<section id="slider"><!--slider-->
	<div class="container">
		<div class="row">
			<jsp:include page="include/catelogy.jsp"></jsp:include>
			<jsp:include page="product.jsp"></jsp:include>
		</div>
	</div>
	</section>





	<!-- ------------------------------------ -->
	<jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html>