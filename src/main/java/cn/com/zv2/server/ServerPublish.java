package cn.com.zv2.server;

import javax.xml.ws.Endpoint;

/**
 * @author lb
 * @description
 * @date 2020/5/14
 */
public class ServerPublish {
    public static void main(String[] args) {
        Endpoint.publish("http://127.0.0.1:80/hello", new HelloServer());
    }
}
