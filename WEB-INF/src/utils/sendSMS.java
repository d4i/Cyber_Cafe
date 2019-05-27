package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import models.Cafe;
import textlocal.class.php;
 
public class sendSMS {
	public String sendSms() {
		Cafe cafe = new Cafe();
		try {
			// Construct data
			String apiKey = "apikey=" + URLEncoder.encode("mP+5Jtkxogc-L9XGr6GAqmgyHsnTPexofmJAqnfKiV", "UTF-8");
			String message = "&message=" + URLEncoder.encode(GenerateOTP.generateOtp(), "UTF-8");
			String sender = "&sender=" + URLEncoder.encode("TXTLCL", "UTF-8");
			String numbers = "&numbers=" + URLEncoder.encode(cafe.getContact(), "UTF-8");
			
			// Send data
			String data = "https://api.textlocal.in/send/?" + apiKey + numbers + message + sender;
			URL url = new URL(data);
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			
			// Get the response
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			String sResult="";
			while ((line = rd.readLine()) != null) {
			// Process line...
				sResult=sResult+line+" ";
			}
			rd.close();
			
			return sResult;
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}
}
