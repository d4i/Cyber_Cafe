<%@ page import='java.util.ArrayList,models.Activity'%>

<html>
	<head>
		<title>Non System Users Table</title>
		<link rel="stylesheet" type='text/css' href="css/system_users_table.css">
	</head>

<body background='images/a2.jpg'>
	<%@ include file ="header.jsp" %>

	<%
		ArrayList<Activity> activity = (ArrayList)application.getAttribute("activities");
	%>

	<div id='services_table_div'>
		<table id='services_table'>
			<tr>
				<th>Name</th>
				<th>Gender</th>
				<th>Address</th>
				<th>Contact</th>
				<th>Activity</th>
				<th>Start time</th>
				<th style="display:none">End time</th>
				<th>Payment</th>
				<td>&nbsp</td>
			</tr>
			<tr id='user_input'>
			  <form action='save_user_activity.do'>
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
				<td id='activity'>
					<select name="activity" id='activity'>
						<option value='0'>Select</option>
						<% for(Activity act : activity){%>
						<option value="<%= act.getActivityId() %>">
							<%= act.getActivity() %>
						</option>
						<% } %>
					</select>
				</td>
				<td><input type='datetime-local' name='start_time' id='dateTime'  class='input'></td>
				<td style="display:none"><input type='datetime-local' name='end_time' class='input'></td>
				<td><input type='number' name='payment' class='input'></td>
				<td><input type='submit' id='save_user' value='save'></td>
			  </form>
			</tr>
		</table>
	</div>
<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/header.js"></script>
	</body>
</html>