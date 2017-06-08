import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
public class TestURL {

	static class MyAuthenticator extends Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
            // I haven't checked getRequestingScheme() here, since for NTLM
            // and Negotiate, the usrname and password are all the same.
            System.err.println("Feeding username and password for " + getRequestingScheme());
            return (new PasswordAuthentication("skf\\MediaMaster", "#Wipe2097Out".toCharArray()));
        }
    }
	public static void main(String[] args) {
	
	
	BufferedReader bufferedReader = null;
	HttpURLConnection conn = null;
	try {
		//Authenticator.setDefault(new MyAuthenticator() );
		String urlink="https://ws.webtrends.com/v3/Reporting/profiles/71239/reports/zz6cjkGYs77/?totals=all&start_period=2016m08d10&end_period=2016m09d09&period_type=agg&format=xml2";
		URL url = new URL(urlink);
		HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
		urlConnection.setRequestProperty("Authorization", "Basic " + "c2tmXE1lZGlhTWFzdGVyOiNXaXBlMjA5N091dA==");
		urlConnection.setRequestMethod("GET");
		InputStream is = urlConnection.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);

		int numCharsRead;
		char[] charArray = new char[1024];
		StringBuffer sb = new StringBuffer();
		while ((numCharsRead = isr.read(charArray)) > 0) {
			sb.append(charArray, 0, numCharsRead);
		}
		String result = sb.toString();

		System.out.println("*** BEGIN ***");
		System.out.println(result);
		System.out.println("*** END ***");
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		
	}
}
}
