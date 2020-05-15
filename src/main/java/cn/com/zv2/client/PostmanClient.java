package cn.com.zv2.client;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 * @author lb
 * @description 模拟Postman发送SOAP(http+xml)
 * @date 2020/5/16
 */
public class PostmanClient {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://127.0.0.1:80/hello?wsdl");
            URLConnection urlConnection = url.openConnection();
            if (urlConnection instanceof HttpURLConnection) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Content-Type", "text/xml");
                httpURLConnection.connect();
                String data = "<soapenv:Envelope xmlns:q0='http://server.zv2.com.cn/' xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' xmlns:xsd='http://www.w3.org/2001/XMLSchema' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'><soapenv:Header></soapenv:Header><soapenv:Body><q0:sayHello><arg0>dd</arg0></q0:sayHello></soapenv:Body></soapenv:Envelope>";
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(data.getBytes());
                outputStream.flush();
                outputStream.close();
                if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuffer sb = new StringBuffer();
                    String line = null;
                    while ((line = br.readLine()) != null) {
                        sb.append(line);
                    }
                    SAXReader reader = new SAXReader();
                    Document document = reader.read(new StringReader(sb.toString()));
                    List<Element> elements = document.selectNodes("//return");
                    for (Element element : elements) {
                        String textTrim = element.getTextTrim();
                        System.out.println(textTrim);
                    }
                    br.close();
                    inputStream.close();
                }
                httpURLConnection.disconnect();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
