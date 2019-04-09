package com.C2C.Config;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016092500594732";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEuwIBADANBgkqhkiG9w0BAQEFAASCBKUwggShAgEAAoIBAQCdK7U8+RD1DnIrv/PiZWB7q/aif4t7YmtLFMdkB2YH8Enltu69DRnZCZfMfvh3STRYU1wRXvaqoW1JDRB5gfZDEqk6xq6dQS18Azi8i7Ir88z+rx7Q+EXsVx0xcKiqmmS7ts7kmyvJCOjFAABlEpmVye6M7EnSlQdqgShuGUwALTP/vVKrsURmn0KClYwp2g+Q68aOiBmV635bgYlYUM8ChdFGypxFx/urQflBWwPeSO6NRmZJicYsKi1CZdKj5oHwWxW5z591XYDmUCLidfzXmPqkO/bc3VIxKLotRzXH2D9GmaQF5O3npQkiWWsLJqVYHaSEnI7fTd2W7juGKBFTAgMBAAECgf8qXJ180aTAaCRdpl8Vpj1bF/5hzf7KQryof/E+BMB7Y0iHoca3LdDJrsw7Uf2mKRTyuYUXKYFSfC/4gIzwMxcs/Nqf/O0TdX3M7xFbwEtFjXCzNIAZ0tEF4nT73mGXmgWMkrkw5KHojX4vmtCAbYL33HVvhkBfgct96VH8WtUhNqD9RaNFpdzPrTNPll+w1E1JM9uRqzuCBL/ldcdM3jXwbu50D9HS5fo2TmqDwrNie/1l/XjJl4falar+I+Z2W73w72IHySZvefqqkYjXcP2bNU8UjPSx46bVvxelhbcfkxNJWLL2Dsvkj9GYKq5xGWh4maElAkY/KAQy4aM79pkCgYEA4G9g2Nw71cmb0ed8j0YrEz0dN9jgw0zfJeI85YoWsF2qiiDVAsbL/HAwpXIg0lsgAYuQyhWjLxHwe5E6mngLg6GdkEHbykwrUSp3OTLKOh4nJpilxDOwwQ9ou1f6eJW5JHE4tYCfUsPE0l/Z8YBNEIq+aAhF3vwitiJ0v/d36ucCgYEAs0aGq7vZG0lj3D8hk/kw3jf21gy+VaEpEkv37uXMoTbfd8zw4GnFFRTp5StTXX7DXL8AS2ebNPwdyYVb2S6bKbfSlG/oCEhDMuoMHBtawowvXEAMyd2w2KXWhqZ/VqBZuuKnel1cxCKL82XMXVBNJxeLYojPkUIIyWJNkWOlpLUCgYEAk61V6XwItySgrh6GnHPMVi1pc1z2kCudzXyvG06gnU4UsCzoXJpYkPN1XvfY1vF0/u9Jx18zb/564aPvDsMcuHF4jvp22AcEnbS2nGFqJZG/qyrYMGDe1joAbP135y6Fk5AYg31t2HTOpqrBaqJEkzToEuYWq6H2aSgE8GeydVMCgYB0m7cVFUaOXRo7NEUe/sMuh7BiYj+bawxP/mHyXj7PzeVlA0Tac3Hh2Iyap6e99KoWNZZ3dZiayjKF1dx8U7hRVmP+cRu352juQRZHYfOS/6P+mRq4Yx6YjKYRR1MkgYBb8vmEuh2Q5feqBdj8CTNl7gaXvO1mSlF0zCAwJWSk0QKBgB1c56i5q0cw4tyb4NCrjLhXeitj6S6yfr6YwL2vl5ZSuswcWyyLLs4j4yllSvaRLoV1eiZ1o+9/NxowVXcqmUAwUUO3kL73Z6SjVxcV1MXlpmBuvzKtANtLeNJZZSiucJwK8koxQ49AjepXq03Y6FPBivbXMPXFzTq0h8U9bpJ6";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArFbJTSze87lWydBG+43n26hN0qDBbyjAE8SBn//mKP4lgtC85OkMdKKrvYMZVUFErSjZOO66tqvj9zStym099E3LL+F1sWxvC69R2kNdJtETGx6uxnXzio8lkfWYDiEObWuH4W8GNPR5Iw47k+kOSBMdVRmHjYUFszlP/nETjdDYGDOymOKQiYD3G7Bm+purgPzKKQejMpPRdLQG66Ae4PTsFqVZ8GHR+rblOwILleDH+agixJtb9Oy/RHpSUmyQ7A/bnfUuVcJz4+ty1ORhPNeZQWMteoYH8CkPRtJc5LCXDOvIk2ANPV1UZsZfFxYJG0+5hS5kF1QJThMquq9TpwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://li2453671898.yicp.io/C2CTest/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://li2453671898.yicp.io/C2CTest/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

