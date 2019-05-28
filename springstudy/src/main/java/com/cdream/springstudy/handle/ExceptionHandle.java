package com.cdream.springstudy.handle;

import com.cdream.springstudy.domain.Result;
import com.cdream.springstudy.exception.DogException;
import com.cdream.springstudy.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by cdream_zs
 * 2017-01-21 13:59
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof DogException) {
            DogException dogException = (DogException) e;
            return ResultUtil.error(dogException.getCode(), dogException.getMessage());
        }else {
            logger.error("【系统异常】{}", e);
            return ResultUtil.error(-1, "未知错误");
        }
    }
}
