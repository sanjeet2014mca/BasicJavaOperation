
<head>
<title>JavaScript Animation</title>

<script type="text/javascript">
         
            var imgObj = null;
            var animate ;
            
            function init(){
               imgObj = document.getElementById('myImage');
               imgObj.style.position= 'relative'; 
               imgObj.style.left = '0px'; 
            }
            
            function moveRight(){
               imgObj.style.left = parseInt(imgObj.style.left) + 1 + 'px';
               animate = setTimeout(moveRight,20); // call moveRight in 20msec
            }
            
            function stop(){
               clearTimeout(animate);
               imgObj.style.left = '0px'; 
            }
            window.onload =init;
            //window.onload = moveRight;
            window.setInterval(function(){
            	stop(); /// call your function here
            }, 25000);
 

      </script>

</head>

<body>

	<form>
		<img id="myImage"
			src="http://www.garcard.com/images/garcard_symbol.png" alt="" />
		<p></p>
		<input type="button" value="Start Animation" onclick="moveRight();" /> <input
			type="button" value="Stop / AutoStop" onclick="stop();" />
	</form>

</body>
</html>