package io.yorkecao.springbootdemo.annotation;


import lombok.Getter;

import java.lang.annotation.*;

/**
 * 控制层接口元数据，用于记录日志
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface DemoAction {

    String value() default "";
    short actionType();
}
