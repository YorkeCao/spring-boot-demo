package io.yorkecao.springbootdemo.advice;

import io.yorkecao.springbootdemo.domain.DemoException;
import io.yorkecao.springbootdemo.domain.Result;
import io.yorkecao.springbootdemo.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Yorke
 */
@Slf4j
@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        log.error(e.getMessage(), e);
        return ResultUtil.error(e.getMessage());
    }

    @ExceptionHandler(DemoException.class)
    public Result handleDemoException(DemoException e) {
        log.error(e.toString(), e);
        return ResultUtil.error(e);
    }
}
