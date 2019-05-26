<!doctype html>
<html lang="en">
 <head>
  <title>analysis</title>
  <link rel='stylesheet' type='text/css' href='css/analysis.css'>
   </head> 
 <body>
  <button id='daily'><h3>Daily Income</h3></button>
  <button id='monthly'><h3>Monthly Income</h3></button>
  <button id='yearly'><h3>Yearly Income</h3></button>

   <span id='genderRatioBtn'>See gender ratio</span>
   
	<div id='main'>
	   <div id='genderDiv'>
		<canvas id='genderChart'></canvas>
	   </div>

	   <div class='chartDiv' id='dailyChart'>
		<canvas id='incomeChartDaily' width='1000' height='400'></canvas>
	   </div>

	   <div class='chartDiv' id='monthlyChart'>
		<canvas id='incomeChartMonthly' width='1000' height='400'></canvas>
	   </div>

	   <div class='chartDiv' id='yearlyChart'>
		<canvas id='incomeChartYearly' width='1000' height='400'></canvas>
	   </div>	   
	</div>   
  <script src='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.min.js'> 
  </script>
  <script src='js/jquery-3.3.1.min.js'></script>
  <script src='js/analysis.js'></script>
 </body>
</html>


<!-- <canvas id='genderChart' width='200' height='200'></canvas> -->