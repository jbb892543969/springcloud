package com.jbb.search.controller;

import baseenum.StatusEnum;
import entity.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 *
 * @author jbb
 * @date 2019/3/16
 */
@ControllerAdvice
public class BaseExceptionHandler {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        log.error("服务器内部代码错误:{}", e.getMessage());
        return new Result(false, StatusEnum.ERROR.getCode(), e.getMessage());
    }
}
