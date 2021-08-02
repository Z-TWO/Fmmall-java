package com.ztwo.fmmall.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Description Md5加密
 * @Author ZTwo
 * @Date 2021/7/30 20:03
 */
public class Md5Util {
    private Md5Util() {}

    public static String encode(String str) {
        //生成一个md5加密器
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            //计算md5的值
            md5.update(str.getBytes());
            //将8位转16位字符串
            return new BigInteger(1, md5.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
