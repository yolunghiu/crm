package com.liuhy.crm.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5Utils {

    public static String getMD5Value(String value) {

        try {
            //1 获得jdk提供消息摘要算法工具类
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            //2 加密的结果10进制
            byte[] md5ValueByteArray = messageDigest.digest(value.getBytes());
            //3将10进制 转换16进制
            BigInteger bigInteger = new BigInteger(1, md5ValueByteArray);

            return bigInteger.toString(16);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(MD5Utils.getMD5Value("1234"));
    }
}
