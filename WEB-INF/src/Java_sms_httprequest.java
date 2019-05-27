import java.net.*;

public class Java_sms_httprequest {

	public static void main(String[] args) {
        try {
                String recipient = "+917869074322";
                String message = " this is my first sms from sms gateway";
                String username = "admin";
                String password = "abdulkalam2";
                String originator = "+916260527632";

                String requestUrl  = "http://127.0.0.1:9501/api?action=sendmessage&" +
                					 "username=" + URLEncoder.encode(username, "UTF-8") +
                					 "&password=" + URLEncoder.encode(password, "UTF-8") +
                					 "&recipient=" + URLEncoder.encode(recipient, "UTF-8") +
                					 "&messagetype=SMS:TEXT" +
                					 "&messagedata=" + URLEncoder.encode(message, "UTF-8") +
                					 "&originator=" + URLEncoder.encode(originator, "UTF-8") +
                					 "&serviceprovider=GSMModem1" +
                					 "&responseformat=html";



                URL url = new URL(requestUrl);
                HttpURLConnection uc = (HttpURLConnection)url.openConnection();

                System.out.println(uc.getResponseMessage());

                uc.disconnect();

        } catch(Exception ex) {
                System.out.println(ex.getMessage());

        }
        
	}

}