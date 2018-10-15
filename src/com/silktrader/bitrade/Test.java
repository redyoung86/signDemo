package com.silktrader.bitrade;

import com.silktrader.bitrade.util.SignUtil;

public class Test {
    public static void main(String[] args) throws Exception {
        String authKey = "123456678sdfsafsd23423";  //准入授权码
        String serkey = String.valueOf(10001); //加密密钥

        //动态的生成校验码
        String sign = SignUtil.sign(authKey, serkey);
        System.out.println("access-auth-sign=" + sign);

        //固定的签名效果测试
        //test();
    }

    public static void test() throws Exception {
        //固定
        String authKey = "123456678sdfsafsd23423";  //准入授权码
        String serkey = String.valueOf(10001);      //加密密钥
        long time = 1539338627384L;                 //固定时间戳

        String md5Sign = SignUtil.md5Sign(authKey, "|", time);
        System.out.println("md5Sign=" + md5Sign);   //参考结果：md5Sign=1A9F19640F5128D5382BDA7C83212068|1539338627384

        String sign = SignUtil.encryptDes(md5Sign, serkey);
        System.out.println("sign=" + sign); //参考结果：sign=fa6d3505ea87b72b83fef9351a0b68f8badfd7f7602fbfca8334ca36ad6c63cb1531ebbe6b0c20aee6adfa62dd07d663
    }

}
