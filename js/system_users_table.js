$(document).ready(function(){
	$('#system_user').click(function(){
			$("#services_table_div").css('display','block');
	});
	
	
	

		$('#save_user').click(function(){
			$('#user_input').clone().appendTo('table');
			//alert('Saved successfully');
		});
});
