package com.spark.bitrade.util;

/***
 * 签名工具类
 */
public class SignUtil {
    private final static String defaultSeparator = "|"; //分隔符

    //md5
    public static String md5Digest(String sourceStr) throws Exception {
        return Md5.md5Digest(sourceStr);
    }

    /**
     *  AES加密
     * @param message
     * @param serkey
     * @return
     * @throws Exception
     */
    public static String encryptDes(String message, String serkey) throws Exception {
        return DesUtil.encode(serkey, message);
    }


    /**
     *  MD5签名
     * @param authKey  准入授权码
     * @param separator 分隔符
     * @param currentTime 系统时间戳
     * @return  MD5签名 = MD5(准入授权码+分隔符+系统时间戳) +分隔符+系统时间戳
     * @throws Exception
     */
    public static String md5Sign(String authKey, String separator, long currentTime) throws Exception {
        StringBuilder source = new StringBuilder();
        source.append(authKey).append(separator).append(currentTime); // 准入授权码+分隔符+系统时间戳

        //MA5(准入授权码+分隔符+系统时间戳) +分隔符+系统时间戳
        return new StringBuilder(md5Digest(source.toString()))
                .append(separator).append(currentTime).toString();
    }

    /**
     * MD5签名
     * @param authKey  准入授权码
     * @return MD5签名信息 = MD5(准入授权码+分隔符+系统时间戳) +分隔符+系统时间戳
     * @throws Exception
     */
    public static String md5Sign(String authKey) throws Exception {
        return md5Sign( authKey, defaultSeparator, System.currentTimeMillis());
    }

    /**
     * 生成校验码
     * @param authKey 准入授权码
     * @param serkey 加密密钥
     * @return 校验码
     * @throws Exception
     */
    public static String sign(String authKey,String serkey) throws Exception {
        //校验码 = AES(MD5签名, 加密密钥)
        String md5Sign = md5Sign(authKey);
        return encryptDes(md5Sign, serkey);
    }

}
