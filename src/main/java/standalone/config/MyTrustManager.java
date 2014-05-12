package standalone.config;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.CertificateException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class MyTrustManager {

	public MyTrustManager() {
		try {
			// Create a trust manager that does not validate certificate chains
			final TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {

				@Override
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				@Override
				public void checkClientTrusted(
						java.security.cert.X509Certificate[] chain,
						String authType) throws CertificateException {
					// TODO Auto-generated method stub

				}

				@Override
				public void checkServerTrusted(
						java.security.cert.X509Certificate[] chain,
						String authType) throws CertificateException {
					// TODO Auto-generated method stub

				}
			} };

			// Install the all-trusting trust manager
			final SSLContext sslContext = SSLContext.getInstance("SSL");
			sslContext.init(null, trustAllCerts,
					new java.security.SecureRandom());
			// Create an ssl socket factory with our all-trusting manager
			final SSLSocketFactory sslSocketFactory = sslContext
					.getSocketFactory();

			// All set up, we can get a resource through https now:
			final URLConnection urlCon = new URL(
					"https://api.wheretheiss.at/v1/satellites/25544")
					.openConnection();
			// Tell the url connection object to use our socket factory which
			// bypasses security checks
			((HttpsURLConnection) urlCon).setSSLSocketFactory(sslSocketFactory);

			final InputStream input = urlCon.getInputStream();
			OutputStream outputStream = new FileOutputStream(new File("/Users/aironman/Documents/ws-spring4-websockets/whereisISS-spring-websockets/response.json"));

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = input.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}

//			System.out.println("Done!");
//			int c;
//			int index = 0;
//			int[] arrayChar = new int[2048];
//			while ((c = input.read()) != -1) {
//				// Do something...
//				arrayChar[index++] = c;
//				System.out.println("int is: " + c + " char is: "
//						+ Character.toChars(c));
//			}
//			System.out.println("alpha :" + alphabets(arrayChar));
			input.close();
			outputStream.close();
		} catch (final Exception e) {
			e.printStackTrace();
		}
		System.out.println("done!");
	}

	private String alphabets(int[] num) {
		char[] s = new char[num.length];
		String str = new String();
		for (int i = 0; i < num.length; i++) {
			s[i] = (char) ('A' + (char) (num[i] - 1));
			str += Character.toString(s[i]);
		}
		return str;
	}

//	public static void main(String[] args) {
//
//		MyTrustManager mytrust = new MyTrustManager();
//
//	}
}
