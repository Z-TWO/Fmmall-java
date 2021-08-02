package com.ztwo.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ztwo.fmmall.vo.ResultVO;
import io.jsonwebtoken.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description token校验拦截器
 * @Author ZTwo
 * @Date 2021/8/1 15:10
 */
@Component
public class CheckTokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //放行option试探请求
        String method = request.getMethod();
        if ("OPTIONS".equalsIgnoreCase(method)) {
            return true;
        }
        String token = request.getHeader("token");
        if (token == null) {
            doResponse(response, ResultVO.getErrorVo("请先登录"));
        } else {
            try {
                JwtParser parser = Jwts.parser();
                //校验密码
                parser.setSigningKey("0123");
                Jws<Claims> claimsJws = parser.parseClaimsJws(token);
                //校验成功
                return true;
            } catch (ExpiredJwtException e) {
                //token过期
                doResponse(response, ResultVO.getErrorVo("登录过期，请重新登录"));
            } catch (UnsupportedJwtException e) {
                //token不合法
                doResponse(response, ResultVO.getErrorVo("token不合法"));
            } catch (Exception e) {
                //重新登录
                doResponse(response, ResultVO.getErrorVo("请重新登录"));
            }
        }
        return false;
    }

    private void doResponse(HttpServletResponse response, ResultVO resultVO) throws IOException {
        //设置响应头
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String json = new ObjectMapper().writeValueAsString(resultVO);
        out.println(json);
        out.flush();
        out.close();
    }

}
