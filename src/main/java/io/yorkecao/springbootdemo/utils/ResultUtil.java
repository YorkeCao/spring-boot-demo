package io.yorkecao.springbootdemo.utils;

import io.yorkecao.springbootdemo.constants.ExceptionType;
import io.yorkecao.springbootdemo.model.DemoException;
import io.yorkecao.springbootdemo.domain.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.xml.ws.Response;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yorke
 */
public class ResultUtil {

    public static ResponseEntity<?> ok() {
        Result result = new Result(ExceptionType.SUCCESS);
        return ResponseEntity.ok().body(result);
    }

    public static ResponseEntity<?> success(String message) {
        Result result = new Result();
        result.setCode(ExceptionType.SUCCESS.getCode());
        result.setMessage(message);
        return ResponseEntity.ok().body(result);
    }

    public static ResponseEntity<?> success(Object data) {
        Result result = new Result(ExceptionType.SUCCESS);
        result.setData(data);
        return ResponseEntity.ok().body(result);
    }

    public static ResponseEntity<?> success(String key, Object value) {
        Map<String, Object> data = new HashMap<>();
        data.put(key, value);
        return success(data);
    }

    public static ResponseEntity<?> error() {
        Result result = new Result(ExceptionType.ERROR);
        return ResponseEntity.badRequest().body(result);
    }

    public static ResponseEntity<?> error(String message) {
        Result result = new Result();
        result.setCode(ExceptionType.ERROR.getCode());
        result.setMessage(message);
        return ResponseEntity.badRequest().body(result);
    }

    public static ResponseEntity<?> error(ExceptionType exceptionType) {
        Result result = new Result(exceptionType);
        return ResponseEntity.badRequest().body(result);
    }

    public static ResponseEntity error(ExceptionType exceptionType, Object data) {
        Result result = new Result(exceptionType);
        result.setData(data);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(data);
    }

    public static ResponseEntity<?> error(DemoException demoException) {
        Result result = new Result(demoException);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    public static Result buildResult(Object data) {
        Result result = new Result(ExceptionType.SUCCESS);
        result.setData(data);
        return result;
    }

    public static Result buildResult(String message, Object data) {
        Result result = new Result();
        result.setCode(ExceptionType.SUCCESS.getCode());
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static Result buildResult(ExceptionType exceptionType) {
        return new Result(exceptionType);
    }

    public static Result buildResult(ExceptionType exceptionType, Object data) {
        return new Result(exceptionType, data);
    }

    public static Result buildResult(DemoException demoException) {
        return new Result(demoException);
    }

    public static Result buildResutl(DemoException demoException, Object data) {
        return new Result(demoException, data);
    }
}
