$(document).ready(function(){	

	$('#system_users').click(function(){
		$("#search").css('display','none');
		//$(this).css('background-color','#ffecd9');
		$('#system_users_table_div').toggle(100);
		getSystemUsers();
		$("#search").css('display','block');

		$('#search').on("keyup",function(){
			var value = $(this).val().toLowerCase();
			$('#system_users_table_data tr').filter(function(){
				$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
			});
		});
	});	

});


function abc(){
	$("#search").css('display','none');
	//$('#system_users').css('background-color','#ffffff');
	//$('#non_system_users').css('background-color','#ffecd9');
	$('#non_system_users_table_div').toggle(100);
	getNonSystemUsers();		
	$("#search").css('display','block');

	$('#search').on("keyup",function(){
		var value = $(this).val().toLowerCase();
		$('#non_system_users_table_data tr').filter(function(){
			$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		});
		});
}

function getNonSystemUsers(){
	var cafeId = $('#cafeName').attr('value');
	$.ajax({		 
            type: 'GET',
            url: 'getAllUsers2.do',
            data: 'cafe='+cafeId,
            dataType: 'json',
            success: function (data) {
				var rows;
				//$('#system_users_table_div').html('');
				$('#non_system_users_table_data').html('');
                //alert(item)
				$.each(data, function (i, item) {
					rows = '';
					rows = "<tr id='row_record1'>"
					//alert(item)
					//alert(item.activity.attr('value')));

                    + "<td class='each_data'>" + item.userId + "</td>"
                    + "<td class='each_data'>" + item.name + "</td>"
                    + "<td class='each_data'>" + item.gender + "</td>"
                    + "<td class='each_data'>" + item.address + "</td>"
                    + "<td class='each_data'>" + item.contact + "</td>"
                    + "<td class='each_data'>" + item.activity.activityId + "</td>"
                    + "<td class='each_data'>" + item.startTime + "</td>"
                    + "<td class='each_data'>" + item.endTime + "</td>"
                    + "<td class='each_data'>" + item.payment + "</td>"
                    + "</tr>";
                    var rows = $('#non_system_users_table_data').append(rows);
					rows.css({'border-collapse':'collapse','text-align':'center','width':'97%'});
                });
            },
            error: function () {                
				window.location = 'login.jsp';
				alert('Session expire. Please login again');
            }
        });
}

function getSystemUsers(){
	var cafeId = $('#cafeName').attr('value');
	$.ajax({		 
            type: 'GET',
            url: 'getAllUsers.do',
            data: 'cafe='+cafeId,
            dataType: 'json',
            success: function (data) {
				var rows;
				
				$('#system_users_table_data').html('');
                
				$.each(data, function (i, item) {
					rows = '';
					rows = "<tr id='row_record'>"
                    + "<td class='each_data'>" + item.userId + "</td>"
                    + "<td class='each_data'>" + item.name + "</td>"
                    + "<td class='each_data'>" + item.gender + "</td>"
                    + "<td class='each_data'>" + item.address + "</td>"
                    + "<td class='each_data'>" + item.contact + "</td>"
                    + "<td class='each_data'>" + item.systemNo + "</td>"
                    + "<td class='each_data'>" + item.startTime + "</td>"
                    + "<td class='each_data'>" + item.endTime + "</td>"
                    + "<td class='each_data'>" + item.payment + "</td>"
                    + "</tr>";
                    var rows = $('#system_users_table_data').append(rows);
					rows.css({'border-collapse':'collapse','text-align':'center','width':'97%'});
                });
            },
            error: function () {                
				window.location = 'login.jsp';
				alert('Session expire. Please login again');
            }
        });
	
}
/*
function parseDateTime(dt) {
        var date = false;
        if (dt) {
            var c_date = new Date(dt);
            var hrs = c_date.getHours();
            var min = c_date.getMinutes();
            if (isNaN(hrs) || isNaN(min) || c_date === "Invalid Date") {
                return null;
            }
            var type = (hrs <= 12) ? " AM" : " PM";
            date = ((+hrs % 12) || hrs) + ":0" + min + type;
        }
        return date;
    }
*/