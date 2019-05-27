<html>
	<head>
		<title>Register Cafe</title>
		<link rel='stylesheet' type='text/css' href='css/index.css'>
		<link rel='stylesheet' type='text/css' href='css/index2.css'>
	</head>
	<body background="images/b1.jpg">
		<h2>Register Your Cafe</h2>
		<div id="form_div" align='center'>
		  <form action="register.do" />
		    
			<label for='name'>Name:</label>
			<input type='text' name='name' id="name" class='input'/>
			
			<br />
			
			<label for='contact'>Contact:</label>
			<input type='contact' name='contact' id='contact' class='input' placeholder='Enter 10 digit number' />
			
			<br />
			
			<label for='password_1'>Password:</label>
			<input type='password' name='password' id='password_1' class='input'/>
			
			<br />
			
			<label for='password_2'>Re-type password:</label>
			<input type='password' name='password_' id='password_2' class='input' />
			
			<br />
			<br />
			
			<input type="button" value="send verification code" id="verification" class='button' onClick='sendOtp();'/>
			
			<br />
			<br />
			
			<label for='enter_code'>Enter code:</label>
			<input type='text' value="" id='enter_code' class='input'>
			
			<br />			
			
			<input type='button' id='verify' class='btnverify' value='verify' onclick='verifyOTP();'>
			
			<input type='submit' value='Register' id="register" class='button'>

		  </form>
		</div>
	
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/index.js"></script>
	<!-- <script src="js/verification.js"></script> -->
		
	</body>
</html>