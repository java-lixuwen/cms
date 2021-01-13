package com.javakc.commonutils.api;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: javakc-parent
 * @description:
 * @author: Li xuwen
 * @create: 2021-01-11 22:20
 **/
@Data
public class APICODE {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 成功或失败
     */
    private Boolean state;

    /**
     * 返回数据
     */
    private Map<String, Object> data = new HashMap<String, Object>();

    /**
     * 返回成功信息
     * @return
     */
    public static APICODE OK(){
        APICODE apicode = new APICODE();
        apicode.setCode(ResultCode.SUCCESS);
        apicode.setMessage("调用成功");
        apicode.setState(true);
        return apicode;
    }

    /**
     * 返回错误信息
     * @return
     */
    public static APICODE ERROR(){
        APICODE apicode = new APICODE();
        apicode.setCode(ResultCode.ERROR);
        apicode.setMessage("服务不可用");
        apicode.setState(false);
        return apicode;
    }

    public APICODE success(Boolean success){
        this.setState(success);
        return this;
    }

    public APICODE message(String message){
        this.setMessage(message);
        return this;
    }

    public APICODE code(Integer code){
        this.setCode(code);
        return this;
    }

    public APICODE data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public APICODE data(Map<String, Object> map){
        this.setData(map);
        return this;
    }

}
