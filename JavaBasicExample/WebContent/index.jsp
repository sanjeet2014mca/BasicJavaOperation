<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<title>animate demo</title>
<style>
div {
	position: absolute;
	background-color: #abc;
	left: 55px;
	width: 100px;
	height: 90px;
	margin-left: 15px;
	margin-right: 15px;
}

.container {
	width: 500px;
	height: 1px;
	background-color: blue;
	position: 0px;
	margin-top: 75px;
	border: 1px solid black;
}

.circle1 {
	display: inline-block;
	width: 10px;
	height: 10px;
	position: 10px;
	background: blue;
	left: 0;
	right: 0;
	margin: 0 auto;
	border-radius: 100%;
	top: -8px;
}

.circle2 {
	display: inline-block;
	width: 10px;
	height: 10px;
	position: 100px;
	background: blue;
	left: 0;
	right: 0;
	margin: 0 auto;
	border-radius: 100%;
	top: -8px;
}

.circle3 {
	display: inline-block;
	width: 10px;
	height: 10px;
	position: 200px;
	background: blue;
	left: 0;
	right: 0;
	margin: 0 auto;
	border-radius: 100%;
	top: -8px;
}

.circle4 {
	display: inline-block;
	width: 10px;
	height: 10px;
	position: 400px;
	background: blue;
	left: 0;
	right: 0;
	margin: 0 auto;
	border-radius: 100%;
	top: -8px;
}

.circle5 {
	display: inline-block;
	width: 10px;
	height: 10px;
	position: 400px;
	background: blue;
	left: 0;
	right: 0;
	margin: 0 auto;
	border-radius: 100%;
	top: -8px;
}
</style>
<script type="text/javascript">
	function codeAddress() {
		document.getElementById('right3').disabled = true;
		document.getElementById('right4').disabled = true;
		document.getElementById('right5').disabled = true;
	}
	window.onload = codeAddress;
</script>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
</head>
<body style="margin: 100px">
	<div class="block" style="border: 1px solid black;">
		<img src="http://www.garcard.com/images/garcard_symbol.png" alt="" />
		<p>@Dist: 2${dataNumValue}km</p>
	</div>
	<br>
	<div class="container">
		<div class="circle1" style="margin-left: 45px">
			<br> <br>
			<button id="right1">&raquo;</button>
		</div>
		<div class="circle2" style="margin-left: 150px">
			<br> <br>
			<button id="right2">&raquo;</button>
		</div>
		<div class="circle3">
			<br> <br>
			<button id="right3">&raquo;</button>
		</div>
		<div class="circle4" style="margin-left: 350px">
			<br> <br>
			<button id="right4">&raquo;</button>
		</div>
		<div class="circle5" style="margin-right: 45px">
			<br> <br>
			<button id="right5">&raquo;</button>
		</div>
	</div>
	<script>
		var identifyBYName = null;
		var countClicks1 = 0;
		$("#right1").click(function() {
		});
	</script>
	<script>
		var countClicks2 = 0;
		$("#right2").click(function() {
			identifyBYName = 'right2';
			countClicks2++;
			if (countClicks2 <= 1) {
				$(".block").animate({
					"left" : "+=100px"
				}, "100px");
			}
			document.getElementById('right3').disabled = false;
			document.getElementById('right4').disabled = true;
			document.getElementById('right5').disabled = true;
		});
	</script>
	<script>
		var countClicks3 = 1;
		$("#right3").click(function() {
			identifyBYName = 'right3';
			countClicks3++;
			if (countClicks3 <= 2) {
				$(".block").animate({
					"left" : "+=100px"
				}, "slow");
			}
			document.getElementById('right4').disabled = false;
			document.getElementById('right5').disabled = true;
		});
	</script>
	<script>
		var countClicks4 = 2;
		$("#right4").click(function() {
			countClicks4++;
			if (countClicks4 <= 3) {
				$(".block").animate({
					"left" : "+=100px"
				}, "slow");
			}
			document.getElementById('right5').disabled = false;
		});
	</script>
	<script>
		var countClicks5 = 3;
		$("#right5").click(function() {
			countClicks5++;
			if ((countClicks5 <= 4)) {
				$(".block").animate({
					"left" : "+=100px"
				}, "slow");
			}

		});
	</script>

</body>
</html>