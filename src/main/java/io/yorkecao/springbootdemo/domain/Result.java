package io.yorkecao.springbootdemo.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Yorke
 */
@Getter
@Setter
public class Result {
    /**
     * 响应码
     */
    private String code;
    /**
     * 响应信息
     */
    private String message;
    /**
     * 响应对象
     */
    private Object object;

    public Result(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(String code, String message, Object object) {
        this.code = code;
        this.message = message;
        this.object = object;
    }
}