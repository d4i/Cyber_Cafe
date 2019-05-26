<?
session_start();
error_reporting(E_ALL & ~ E_NOTICE);
include 'textlocal.php';

class controller{
	function __construct(){
		$this->processMobileVerification();
	}

	function processMobileVerification(){
		switch ($_POST["action"]){
			case "send_otp":

				$contact = $_POST['contact'];
				$apikey = urlencode('mP+5Jtkxogc-gO0zOI0aMyV5uCBwmexVKWvDjzmnVW');
				$Textlocal = new Textlocal(false,false,$apikey);

				$numbers = array(
					$contact	
				);
				$sender = 'TXTLCL';
				$otp = rand(100000,999999);
				$_SESSION['session_otp'] = $opt;
				$message = "Your one time password is "+otp;

				try{
					$response = $Textlocal->sendSms($numbers,$message,$sender);
					require_once ("index.jsp");
					exit();
				}catch(Exception $e){
					die('Error: ' .$e->getMessage());
				}
				break;

			case "verify_otp":
				$otp = $_POST['otp'];
				
				if($otp == $_SESSION['session_otp']){
					echo json_encode(array("type"=>"success","message"=>"Your mobile number is verified!"));
				}else{
					echo json_encode(array("type"=>"error","message"=>"Mobile number verification failed"));
				}
				break;
		}
	}
}

$controller = new Controller();
?>