<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
					<h2>Login to your account</h2>
					<form action="#">
						<input type="text" placeholder="Name" /> <input type="email"
							placeholder="Email Address" /> <span> <input
							type="checkbox" class="checkbox"> Keep me signed in
						</span>
						<button type="submit" class="btn btn-default">Login</button>
					</form>
				</div>
				<!--/login form-->
			</div>
			<div class="col-sm-1">
				<h2 class="or">OR</h2>
			</div>
			<div class="col-sm-4">
				<div class="signup-form">
					<!--sign up form-->
					<h2>New User Signup!</h2>
					<form action="#">
						<input type="text" placeholder="Name" /> <input type="email"
							placeholder="Email Address" /> <input type="password"
							placeholder="Password" />
						<button type="submit" class="btn btn-default">Signup</button>
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