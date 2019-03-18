package com.jbb.base.controller;

import baseenum.StatusEnum;
import entity.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 *
 * @author jbb
 * @date 2019/3/17
 */
@RestControllerAdvice
public class BaseExceptionHandler {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    public Result error(Exception e) {
        log.error("服务器内部代码错误:{}", e.getMessage());
        return new Result(false, StatusEnum.INNERERROR.getCode(), e.getMessage());
    }
}
