<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.scrollUp.min.js"></script>
<script src="js/price-range.js"></script>
<script src="js/jquery.prettyPhoto.js"></script>
<script src="js/main.js"></script>
</head>
<body>
	<jsp:include page="include/header.jsp"></jsp:include>

	<!-- ------------------------------------ -->




	<section id="form"><!--form-->
	<div class="container">
		<div class="row">
			<div class="col-sm-4 col-sm-offset-1">
				<div class="login-form">
					<!--login form-->
					<h2>Đăng nhập hệ thống</h2>
					<form action="/luanvan_shop/account.html" method="post">
					<input type="hidden" value="login" name="action" />
						<input type="text" placeholder="Tài khoản" name="tkdangnhap" /> <input
							type="password" placeholder="Mật khẩu" name="mkdangnhap"/> 
							<!--
							<span> 
							  <input
							type="checkbox" class="checkbox"> Duy trì đăng nhập
							
							</span>
							-->
						<p style="color: red">${errordn}</p>
						<button type="submit" class="btn btn-default">Đăng nhập</button>
					</form>
				</div>
				<!--/login form-->
			</div>
			<div class="col-sm-1">
				<h2 class="or">HOẶC</h2>
			</div>
			<div class="col-sm-4">
				<div class="signup-form">
					<!--sign up form-->
					<h2>Đăng ký thành viên</h2>
					<form action="/luanvan_shop/account.html" method="post">
						<input type="hidden" value="registry" name="action" /> <input
							type="text" placeholder="Tài khoản" name="taikhoan" value="${taikhoan}" /> <input
							type="email" placeholder="Email" name="email" value="${email}"/> <input
							type="password" placeholder="Mật khẩu" name="matkhau" value="${matkhau}"/>
						<p style="color: red">${error}</p>
						<button type="submit1" class="btn btn-default">Đăng ký</button>
					</form>
				</div>
				<!--/sign up form-->
			</div>
		</div>
	</div>
	</section>
	<!--/form-->




	<!-- ------------------------------------ -->
	<jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html>