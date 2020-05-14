package cn.com.zv2.client;

import cn.com.zv2.stub.hello.HelloServer;
import cn.com.zv2.stub.hello.HelloServerService;

/**
 * @author lb
 * @description
 * @date 2020/5/14
 */
public class HelloClient {
    private HelloServer helloServer = new HelloServerService().getHelloServerPort();

    public String sayHello(String name) {
        return helloServer.sayHello(name);
    }

    public static void main(String[] args) {
        HelloClient client = new HelloClient();
        String result = client.sayHello("张珊");
        System.out.println(result);
    }
}
