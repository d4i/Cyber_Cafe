<html>
	<head>
		<title>System Users Table</title>
		<link rel="stylesheet" type='text/css' href="css/system_users_table.css">
	</head>

<body background='images/a2.jpg'>
	<%@ include file ="header.jsp" %>
	<div id='services_table_div'>
		<table id='services_table'>
			<tr>
				<th>Name</th>
				<th>Gender</th>
				<th>Address</th>
				<th>Contact</th>
				<th>System No.</th>
				<th>Start time</th>
				<th style="display:none">End time</th>
				<th>Payment</th>
				<td>&nbsp</td>
			</tr>
			<tr id='user_input'>
			  <form action='save_user.do'>
				<td><input type='text' name='name' class='input' /></td>
				<td>
					<select id='gender'name='gender'>
						<option>Select</option>
						<option>Male</option>
						<option>Female</option>
						<!-- <option>Programmer</option> -->
					</select>
				</td>
				<td><textarea name='address' class='input'></textarea></td>
				<td><input type='text' name='contact' class='input'></td>
				<td id='system_no'>
					<select name="system_no" id='i'>
						<%
							for(int i=1;i<=10;i++){
						%>
							<option value="<%= i %>" ><%= i %></option>
						<% } %>
					</select>
				</td>
				<td><input type='datetime-local' name='start_time' id='dateTime' width='190px' class='input'></td>
				<td style="display:none"><input type='datetime-local' name='end_time' class='input'></td>
				<td><input type='number' name='payment' class='input'></td>
				<td><input type='submit' id='save_user' value='save'></td>
			  </form>
			</tr>
		</table>
	</div>
<!-- 

	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/header.js"></script> -->
	</body>
</html>