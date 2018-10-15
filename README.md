# signDemo
接口header签名生成示例

## [生成签名关键代码]
```$java
String authKey = "123456678sdfsafsd23423";  //准入授权码（需向接口对接人索取）
String serkey = String.valueOf(10001);      //加密密钥（需向对接口接人索取）

String sign = SignUtil.sign(authKey, serkey);   //生成签名
System.out.println("access-auth-sign=" + sign);
```
## [生成签名示例]
请参考 com.spark.bitrade.Test
