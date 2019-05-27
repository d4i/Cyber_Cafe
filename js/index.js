/*$(document).ready(function(){
	var contact_default = "Enter your contact...";

	$("input[type='contact']").attr('value',contact_default).focus(function(){
		if($(this).val() == contact_default){
			$(this).attr('value','');
		}
	}).blur(function(){
		if($(this).val == ''){
			$(this).attr('value',contact_default);
		}
	})
});*/

$(document).ready(function(){
	/*$('#verification').click(function(){
		//$('#verification').html('sending...');
		this.value = '  sending...  ';
		
		//sendOtp.do
		//$.get('sendOtp.do',{})

	});*/

	
	//when code is sent........
	//this.value = 'sent'
});

function sendOtp(){
	$(".error").html("").hide();
	var number = $('#contact').val();
	if(number.length == 10 && number != null){
		var input = {
						"mobile_number":number,
						"action":"send_otp"
					};
		$.ajax({
			url:'controller.php',
			type:'POST',
			data:input,
			success:function (response){
				//$("#form_div").html(response)
				alert('success');
			}
		});
	}else{
		$('.error').html('Enter a valid number');
		$('.error').show();
	}
}

function verifyOTP(){
	$('.error').html("").hide();
	$('.success').html('').hide();
	var otp = $('#contact').val();

	var input = {
		"otp":otp,
		"action":"verify_otp"
	};
	if(otp.length == 6 && otp!=null){
		$.ajax({
			url: 'controller.php',
			type:"POST",
			dataType:"json",
			data:input,
			success: function(response){
				$("."+response.type).html(response.message)
				$("."+response.type).show();
			},
			error : function(){
				alert('ss')
			}
		});
	}else{
		$("error").html('you have entered wrong otp')
		$('error').show();
	}
}