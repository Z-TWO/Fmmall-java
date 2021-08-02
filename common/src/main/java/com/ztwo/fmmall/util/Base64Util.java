package com.ztwo.fmmall.util;

import java.util.Base64;

/**
 * @Description Base64加密解密
 * @Author ZTwo
 * @Date 2021/7/30 20:11
 */
public class Base64Util {
    private Base64Util() {}

    /**
     * @Description 加密
     */
    public static String encode(String str) {
        return Base64.getEncoder().encodeToString(str.getBytes());
    }

    /**
     * @Description 解密
     */
    public static String decode(String str) {
        return new String(Base64.getDecoder().decode(str));
    }
}
