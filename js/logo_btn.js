$(document).ready(function(){

	$('#logo_btn').click(function(){
		$('#profile').toggle(100);
	});

	$('#settings').click(function(){
		window.location.href='profile_page.jsp'
	});

	$('#logout').click(function(){
		$.ajax({
			url:'logout.do',
			success:function(data){
				window.location.href='login.jsp';
			}	
		})
	});

	
});