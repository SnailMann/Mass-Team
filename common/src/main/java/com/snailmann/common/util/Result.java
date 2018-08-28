package com.snailmann.common.util;


import org.springframework.http.HttpStatus;

import com.snailmann.common.entity.vo.ResultVO;


public class Result {


    /**
     * 返回成功
     * @return
     */
    public static <T> ResultVO<T> ok(T data){
        return new ResultVO<> (HttpStatus.OK.value(),null,data);
    }

    /**
     * 返回成功
     * @param msg
     * @return
     */
    public static <T> ResultVO<T> ok(String msg,T data){
        return new ResultVO<> (HttpStatus.OK.value(),msg,data);
    }


    /**
     * 失败
     * @param code
     * @param msg
     * @return
     */
    public static ResultVO<Object> error(int code,String msg){
        return  new ResultVO<>(code,msg);

    }

}
