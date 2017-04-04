/**
 * @author dbxiao
 */
package test1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;

public class HttpsDemo1 {

        public static void main(String[] args) throws Exception {
                // TODO Auto-generated method stub
                new HttpsDemo1();
        }

        public HttpsDemo1() throws Exception {
                //System.setProperty("javax.NET.ssl.trustStore", "C:\\Program Files\\Java\\jdk1.8.0_111\\jre\\lib\\security\\mystore");
                //System.setProperty("javax.Net.ssl.trustStorePassword", "123456");
        
                /*
                KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
                FileInputStream in = new FileInputStream("C:\\Program Files\\Java\\jdk1.8.0_111\\jre\\lib\\security\\mystore");
                ks.load(in, "123456".toCharArray());

                System.out.println(KeyStore.getDefaultType().toString());
                System.out.println(TrustManagerFactory.getDefaultAlgorithm().toString());

                TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                tmf.init(ks);
                SSLContext ctx = SSLContext.getInstance("TLS");
                ctx.init(null, tmf.getTrustManagers(), null);

                LayeredConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(ctx);
                */
                
        	SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, new TrustManager[] { new TrustAnyTrustManager()},new java.security.SecureRandom());
                URL reqURL = new URL("https://www.baidu.com");
                HttpsURLConnection httpsConn = (HttpsURLConnection) reqURL.openConnection();
            httpsConn.setSSLSocketFactory(sc.getSocketFactory());
            httpsConn.setHostnameVerifier(new TrustAnyHostnameVerifier());    
                //httpsConn.setSSLSocketFactory(ctx.getSocketFactory());
                httpsConn.setRequestMethod("GET");
                httpsConn.setDoOutput(true);
                httpsConn.setDoInput(true);
                httpsConn.setRequestProperty("Accept",
                                "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                //httpsConn.setRequestProperty("Accept-Encoding", "gzip, deflate, sdch, br");
                httpsConn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
                httpsConn.setRequestProperty("Connection", "keep-alive");
                httpsConn.setRequestProperty("User-Agent",
                                "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36");
                System.out.println("1--Conected to " + httpsConn.toString());
                httpsConn.connect();
                System.out.println(httpsConn.getResponseCode());
                String s = readResponseBody(httpsConn.getInputStream());
                
                FileWriter fw = new FileWriter("d:/1.html");
                fw.write(s);
                System.out.println(s);
        }

        private String readResponseBody(InputStream inputStream) throws IOException {

                BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine+"\n");
                }
                in.close();

                return response.toString();
        }

}

class TrustAnyTrustManager implements  X509TrustManager {

	@Override
	public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public X509Certificate[] getAcceptedIssuers() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

class TrustAnyHostnameVerifier implements HostnameVerifier {

	@Override
	public boolean verify(String arg0, SSLSession arg1) {
		// TODO Auto-generated method stub
		return true;
	}
	
}
