package io.yorkecao.springbootdemo.utils;

import io.yorkecao.springbootdemo.constants.DemoResponse;
import io.yorkecao.springbootdemo.domain.ResponseVo;

/**
 * @author Yorke
 */
public class ResponseUtils {

    public static ResponseVo success() {
        return new ResponseVo(DemoResponse.SUCCESS.getCode(), DemoResponse.SUCCESS.getMessage());
    }

    public static ResponseVo success(Object object) {
        return new ResponseVo(DemoResponse.SUCCESS.getCode(), DemoResponse.SUCCESS.getMessage(), object);
    }

    public static ResponseVo error() {
        return new ResponseVo(DemoResponse.ERROR.getCode(), DemoResponse.ERROR.getMessage());
    }

    public static ResponseVo error(String errorMessage) {
        return new ResponseVo(DemoResponse.ERROR.getCode(), errorMessage);
    }

    public static ResponseVo error(DemoResponse demoResponse) {
        return new ResponseVo(demoResponse.getCode(), demoResponse.getMessage());
    }
}
