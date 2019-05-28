package com.cdream.springstudy.exception;

import com.cdream.springstudy.enums.ResultEnum;

/**
 * Created by cdream_zs
 * 2017-01-21 14:05
 */
public class DogException extends RuntimeException{

    private Integer code;

    public DogException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
