<html>
	<head>
		<title>User Home Page</title>
	</head>
	<body>
		<%@ include file='profile_page.jsp' %>

		<div id='div'>
		<form action='upload_pic.do' method="post" enctype='multipart/form-data'>
			<input type='file' id='photo' style="color:transparent" name="photo"/>
			<input type='submit' value='Upload' id='uploadPic' >
		</form>
	</div>

		
	</body>
</html>