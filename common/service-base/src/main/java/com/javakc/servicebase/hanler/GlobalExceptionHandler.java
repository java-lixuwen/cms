package com.javakc.servicebase.hanler;

import com.javakc.commonutils.api.APICODE;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: javakc-parent
 * @description: 全局统一异常处理类
 * @author: Li xuwen
 * @create: 2021-01-13 11:25
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public APICODE errorHandler(Exception e){
        e.printStackTrace();
        return APICODE.ERROR().message("服务异常");
    }

    @ExceptionHandler(HctfException.class)
    @ResponseBody
    public APICODE errorHandler(HctfException e){
        e.printStackTrace();
        return APICODE.ERROR().code(e.getCode()).message(e.getMsg());
    }

}
