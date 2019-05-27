$(document).ready(function(){

	//$('#dateTime').val(new Date().toJSON().slice(0,19));
	
	$('#about').click(function(){
		window.location.href="about.jsp";
	});

	$('#user_record').click(function(){
		window.location.href='user_record.jsp'
	});

	$("#analysis").click(function(){
		window.location.href="analysis.jsp";
	});
});



$(document).ready(function(){
	$('#system_user').click(function(){
			window.location.href="system_users_table.jsp";
	});
	
	/*$('#save_user').click(function(){
		$('#user_input').clone().appendTo('table');
	});*/
});


$(document).ready(function(){
	$('#non_system_users').click(function(){
			window.location.href="non_system_users_table.jsp";
	});
	
	/*$('#save_user').click(function(){
		$('#user_input').clone().appendTo('table');
	});*/
});
