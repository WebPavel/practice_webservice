package cn.com.zv2.client;

import cn.com.zv2.stub.mobile.MobileCodeWS;
import cn.com.zv2.stub.mobile.MobileCodeWSSoap;

/**
 * @author lb
 * @description
 * @date 2020/5/13
 */
public class MobileCodeClient {
    /**
     * 创建服务访问点集合后获取绑定的类
     */
    private MobileCodeWSSoap mobileCodeWSSoap = new MobileCodeWS().getMobileCodeWSSoap();

    public String getMobileCodeInfo(String mobile) {
        return mobileCodeWSSoap.getMobileCodeInfo(mobile, null);
    }

    public static void main(String[] args) {
        MobileCodeClient client = new MobileCodeClient();
        final String mobile = "13165987484";
        String mobileCodeInfo = client.getMobileCodeInfo(mobile);
        System.out.println(mobileCodeInfo);
    }
}
