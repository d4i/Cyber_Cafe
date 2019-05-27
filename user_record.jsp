<%@ page import="models.Cafe,models.Activity" %>

<!doctype html>
<html lang="en">
 <head>
  <link rel='stylesheet' type='text/css' href='css/user_record.css' />
  <title>user_record</title>
 </head>
 <body background='images/b4.png'>
	<%@ include file = "header.jsp" %>

	

	<input type='button' id='system_users' value='System users' class='btn' />
	<input type='button' id='non_system_users' value='Non-system users' class='btn' onclick='abc();'/>
	
	<input type='text' id='search' value='' placeholder='search user...'>
	
	<br />
	<br />

	<div id='system_users_table_div' style='display:none;'>
		<table id='system_users_table'> 
		<thead>
		  <tr class='mytr'>
			<th class='table_heading' id='user_id'>User Id</th>
			<th class='table_heading' id='name'>Name</th>
			<th class='table_heading' id='gender'>Gender</th>
			<th class='table_heading' id='address'>Address</th>
			<th class='table_heading' id='contact'>Contact</th>
			<th class='table_heading' id='system_no'>System No.</th>
			<th class='table_heading' id='start_time'>Start time</th>
			<th class='table_heading' id='end_time'>End time</th>
			<th class='table_heading' id='payment'>Payment</th>  
		  </tr>		
		</thead>

		<tbody id='system_users_table_data'>			
		<tbody>
		  
		</table>		
	</div>


	<div id='non_system_users_table_div' style='display:none;'>
		<table id='non_system_users_table'> 
		<thead>
		  <tr class='mytr'>
			<th class='table_heading' id='user_id'>User Id</th>
			<th class='table_heading' id='name'>Name</th>
			<th class='table_heading' id='gender'>Gender</th>
			<th class='table_heading' id='address'>Address</th>
			<th class='table_heading' id='contact'>Contact</th>
			<th class='table_heading' id='activity'>Activity</th>
			<th class='table_heading' id='start_time'>Start time</th>
			<th class='table_heading' id='end_time'>End time</th>
			<th class='table_heading' id='payment'>Payment</th>  
		  </tr>		
		</thead>

		<tbody id='non_system_users_table_data'>			
		<tbody>
		  
		</table>
	</div>

	


	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/user_record.js"></script>
	<!-- <script src='js/logo_btn.js'></script> -->
 </body>
</html>
