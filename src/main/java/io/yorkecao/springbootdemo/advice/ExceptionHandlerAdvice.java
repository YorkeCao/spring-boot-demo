package io.yorkecao.springbootdemo.advice;

import io.yorkecao.springbootdemo.domain.model.DemoException;
import io.yorkecao.springbootdemo.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Yorke
 */
@Slf4j
@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception e) {
        log.error(e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultUtil.error(e.getMessage()));
    }

    @ExceptionHandler(DemoException.class)
    public ResponseEntity handleDemoException(DemoException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultUtil.error(e));
    }
}
