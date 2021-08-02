package com.ztwo.fmmall.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Base64UtilTest {

    @Test
    void encode() {
        String str = "usernamepassword";
        String encode = Base64Util.encode(str);
        String decode = Base64Util.decode(encode);
        System.out.println(encode);
        System.out.println(decode);
    }

    @Test
    void decode() {
    }
}