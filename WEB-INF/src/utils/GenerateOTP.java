package utils;

public class GenerateOTP{
	public static String generateOtp(){
		int randomPin = (int)(Math.random()*9000)+1000;

		String otp = String.valueOf(randomPin);
		return otp+" is your cafe login code.This is valid only for 10 minutes.";
	}

	/*public static void main(String[] args){
		System.out.println(generateOtp()+" is your cafe login code.This is valid only for 10 minutes.");
	}*/
}