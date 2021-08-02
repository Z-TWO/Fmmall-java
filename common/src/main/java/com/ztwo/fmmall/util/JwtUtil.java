package com.ztwo.fmmall.util;

import com.sun.deploy.net.HttpResponse;
import com.ztwo.fmmall.vo.ResultVO;
import io.jsonwebtoken.*;

import java.util.Date;

/**
 * @Description 使用JWT生成token、校验token
 * @Author ZTwo
 * @Date 2021/8/1 10:02
 */
public class JwtUtil {
    private JwtUtil() {
    }

    //生成token，可以指定token有效期（单位：天）
    public static String createToken(String username, String password, Integer lifeDay) {
        JwtBuilder builder = Jwts.builder();
        String token = builder.setSubject(username)
                // 设置token校验密码为user.password
                .signWith(SignatureAlgorithm.HS256, "0123")
                // token有效期默认为1天
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + lifeDay * 24 * 60 * 60 * 1000))
                .compact();
        return token;
    }

    //生成token，默认有效期1天
    public static String createToken(String username, String password) {
        return createToken(username, password, 1);
    }

    //校验token
    public static Boolean checkToken(String token, String password) {
        try {
            JwtParser parser = Jwts.parser();
            //校验密码
            parser.setSigningKey(password);
            Jws<Claims> claimsJws = parser.parseClaimsJws(token);
            //获取token中subject的数据
            Claims body = claimsJws.getBody();
            String subject = body.getSubject();
            System.out.println(subject);
            return true;
        } catch (ExpiredJwtException e) {
            //token过期
            System.out.println("token过期");
        } catch (UnsupportedJwtException e) {
            //token不合法
            System.out.println("token不合法");
        } catch (Exception e) {
            //重新登录
            System.out.println(e.toString());
        }
        return false;
    }
}
