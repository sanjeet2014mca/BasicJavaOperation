<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>animate demo</title>
  <style>
  </style>
  <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
</head>
<body>
<button id="right">f</button>
<div class="block" style=" position: absolute;
    background-color: #abc;
    left: 50px;
    width: 90px;
    height: 90px;
    margin: 5px;"><img src="http://www.garcard.com/images/garcard_symbol.png" alt="" ></div>
<script>
var countNoOfhit=0;
$( "#right" ).click(function() {
	countNoOfhit++;
	if(countNoOfhit<=1)
  $( ".block" ).animate({ "left": "+=500px" }, "1000px" );
});
</script>
</body>
</html>