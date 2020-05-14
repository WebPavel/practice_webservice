package cn.com.zv2.server;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author lb
 * @description
 * @date 2020/5/14
 */
@WebService
public class HelloServer {
    public String sayHello(String name) {
        return "hello," + name;
    }

    @WebMethod(exclude = true)
    public String sayBye(String name) {
        return "bye," + name;
    }
}
