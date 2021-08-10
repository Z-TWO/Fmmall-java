package com.ztwo.fmmall.vo;

import java.io.Serializable;

/**
 * @Description
 * @Author ZTwo
 * @Date 2021/7/27 10:03
 */
public class ResultVO implements Serializable {
    private Integer code;
    private Object data;
    private String msg;

    private ResultVO() {

    }

    public Integer getCode() {
        return code;
    }

    public Object getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

    public static ResultVO getSuccessVo(String msg, Object data) {
        ResultVO resultVO = new ResultVO();
        resultVO.code = 0;
        resultVO.msg = msg;
        resultVO.data = data;
        return resultVO;
    }

    public static ResultVO getSuccessVo(String msg) {
        return getSuccessVo(msg, null);
    }

    public static ResultVO getErrorVo(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.code = code;
        resultVO.msg = msg;
        return resultVO;
    }

    public static ResultVO getErrorVo(String msg, Object data) {
        ResultVO resultVO = new ResultVO();
        resultVO.code = 1;
        resultVO.msg = msg;
        resultVO.data = data;
        return resultVO;
    }

    public static ResultVO getErrorVo(String msg) {
        return getErrorVo(msg, null);
    }
}
