<%@ page import="models.Cafe" %>

<!doctype html>
<html lang="en">
 <head>
 <head>
  <title>Profile</title>
  <link rel='stylesheet' type='text/css' href='css/profile_page.css' />

  <link rel='stylesheet' type='text/css' href='jquery_ui/jquery-ui.css' />
  <link rel="stylesheet" type="text/css" href="jquery_ui/jquery-ui.structure.css" />
  <link rel="stylesheet" type="text/css" href="jquery_ui/jquery-ui.theme.css" />
  
	
 </head>
 <body>

	<div id='main'>
	  <span>
		<img src='images/a7.png' id='user_img' />
		<%
		Cafe cafe = (Cafe)session.getAttribute("cafe"); %>
			
		<% if(cafe!=null){ %>		
	  </span>
	  <span value='<%= cafe.getCafeId() %>' id='cafeName'>
		<%= cafe.getName() %> 					
	  </span>		
	<% } %>
	<h3>___________________________________________________________</h3>
	</div>
	
	
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="jquery_ui/jquery-ui.min.js"></script>
	<script src='js/profile_page.js'></script>	
 </body>
</html>
