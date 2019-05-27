$(document).ready(function(){

	collectDailyIncome();
	collectDayOfWeek();



	$('#daily').click(function(){
		$('#dailyChart').css('display','block');
		$('#yearlyChart').css('display','none');
		$('#monthlyChart').css('display','none');
		
	});	
	
	showPayment();
	showDay();
	
	$('#monthly').click(function(){
		$('#dailyChart').css('display','none');
		$('#yearlyChart').css('display','none');
		$('#monthlyChart').css('display','block');
		var income2 = $('#incomeChartMonthly');

		var lineChart = new Chart(income2,{
			type:'line',
			data:{
				labels:['Jan','Feb','Mar','Apr','May','June','Jul'],
				datasets:[{
					label:'Monthly income',
					fill:false,
					lineTension:0.2,
					backgroundColor: 'rgb(255, 99, 132)',
					borderColor: 'rgb(255, 99, 132)',
					borderCapStyle: 'butt',
					borderDash:[],
					borderDashOffset:0.0,
					pointHoverRadius:5,
					borderJoinStyle:'miter',
					data:[12000,25000,33200,39200,39000,48900,50000]
				}]
			},

			options:{
				responsive:true,
				maintainAspectRatio: false,
				scales: {
					yAxes:[{
						ticks:{
							beginAtZero:true
						}
					}]
				}
			}
		});
	});

	$('#yearly').click(function(){
		$('#dailyChart').css('display','none');
		$('#monthlyChart').css('display','none');
		$('#yearlyChart').css('display','block');

		var income3 = $('#incomeChartYearly');

		var lineChart = new Chart(income3,{
			type:'line',
			data:{
				labels:['2018','2019'],
				datasets:[{
					label:'Yearly income',
					fill:false,
					lineTension:0.2,
					backgroundColor: 'rgb(255, 99, 132)',
					borderColor: 'rgb(255, 99, 132)',
					borderCapStyle: 'butt',
					borderDash:[],
					borderDashOffset:0.0,
					pointHoverRadius:5,
					borderJoinStyle:'miter',
					data:[350000,400000]
				}]
			},

			options:{
				responsive:true,
				maintainAspectRatio: false,
				scales: {
					yAxes:[{
						ticks:{
							beginAtZero:true
						}
					}]
				}
			}
		});
	});
	


function prepareDailyChart(){
	var income1 = $('#incomeChartDaily');
	var lineChart = new Chart(income1,{
		type:'line',
		data:{
			//labels:['Monday','Tuesday','Wednesday','Thursday','Friday','Saturday','Sunday'],
			labels:array,
			datasets:[{
				label:'Daily income',
				fill:false,
				lineTension:0.2,
				backgroundColor: 'rgb(255, 99, 132)',
				borderColor: 'rgb(255, 99, 132)',
				borderCapStyle: 'butt',
				borderDash:[],
				borderDashOffset:0.0,
				pointHoverRadius:5,
				borderJoinStyle:'miter',			
				data:ar
			}]
		},

		options:{
			responsive:true,
			maintainAspectRatio: false,
			scales: {
				yAxes:[{
					ticks:{
						beginAtZero:true
					}
				}]
			}
		}
	});
}

var request;
function collectDailyIncome(){
	request = new XMLHttpRequest();
	request.open('get','collect_income.do',true);
	request.onreadystatechange = showPayment;
	request.send(null);
}

var ar = new Array();
function showPayment(){
	//alert(request.readyState)
	
	if(request.readyState==4&&request.status==200){
		var arr = eval(request.responseText);
		
		//var arr = JSON.parse(request.responseText);
		//alert(arr);

		var pmt = null;		
		for(i=0;i<arr.length;i++){			
			
			//alert(arr[i].values)
			
			pmt = arr[i].payment;
			
			//alert(pmt)
			
			ar[i]=pmt
			
			//alert(pmt)
		}
		//alert(typeof ar)
		//alert(str)
		prepareDailyChart();
	}
}
var rq;
function collectDayOfWeek(){
	rq = new XMLHttpRequest();
	rq.open('get','collect_day_of_week.do',true);
	rq.onreadystatechange = showDay;
	rq.send(null);
}

var array = new Array();
function showDay(){		
	
	if(rq.readyState==4&&rq.status==200){
		
		var arr = eval(rq.responseText);
		//alert(arr)
		for(i=0;i<arr.length;i++){
			day = arr[i].day;
			array[i]=day;

			//alert(day);
		}

		
	}
}

function prepareGenderChart(){
	
		var genderChart = $('#genderChart');

		var pieChart = new Chart(genderChart,{
			type:'pie',
			data:{
				labels:['Males','Females'],
				datasets:[{
					label:'Gender ratio',
					backgroundColor: ['#ff9933','#0066ff'],
					borderColor: 'rgb(255, 99, 132)',
					data:[male[12],female[12]]
				}]
			},

			options:{
				responsive:true,
				maintainAspectRatio: false
			}
		});
}

var req;

var male;
var female;

$('#genderRatioBtn').click(function(){
	req = new XMLHttpRequest();
	req.open('get','collect_gender.do',true);
	req.onreadystatechange = showGender;
	req.send(null);
		
	prepareGenderChart();
});


	function showGender(){
		if(req.readyState==4 && req.status==200){
			var array = eval(req.responseText);
			
			//alert(JSON.stringify(array[0]));
			//alert(JSON.stringify(array[1]));
			//alert(array.length)
			
			male=JSON.stringify(array[0]);
			female=JSON.stringify(array[1]);

			//alert(male);
			//alert(female);

			//for (i=0;i<array.length ;i++){
				//alert(array[i]);
			//}

			//alert(male[12]);
		}	
	}
	
});