<%@ page import="models.Cafe,models.Activity" %>

<link rel="stylesheet" type='text/css' href="css/dashboard_heading.css">
<link rel="stylesheet" type='text/css' href="css/user_record.css">

<div id='heading'>
			<span id="about" class='head'>About Us</span>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<span class='dropdown'>
				<button class='drop_button' id='drop_button'>Services</button>

				<span id="services" class='dropdown-content'>			
					<span id='system_user' class='incontent'>System Users</span>
					<span id="non_system_users" class='incontent'>
						Non-system users
					</span>			
				</span>
			</span>
			&nbsp;&nbsp;&nbsp;&nbsp;			
			<span id='user_record' class='head'>User Record</span>
			&nbsp;&nbsp;&nbsp;&nbsp;			
			<span id='analysis'class='head'>Analysis</span>
		</div>

		<%
		Cafe cafe = (Cafe)session.getAttribute("cafe"); %>
		
		<%--Activity activity = (Activity)application.getAttribute("activity");	
		
		%>--%>
		
		<% if(cafe!=null){ %>		
		
		<span value='<%= cafe.getCafeId() %>' id='cafeName'>
			<%= cafe.getName() %> 
			<button id='logo_btn'>
				<img src='images/a1.png' width='20px' />
			</button>		
		</span>		
		<br />
		<br />
		<br />		
		<div id='profile'>
			<!-- <button class='p' id='my_profile'>My Profile</button><br /> -->
			<button class='p' id='settings'>Settings</button><br />
			<button class='p' id='logout'>LogOut</button><br />
		</div>
		
		
		<% } %>
		<br /> 


		

<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/header.js"></script>
<script src="js/logo_btn.js"></script>

 