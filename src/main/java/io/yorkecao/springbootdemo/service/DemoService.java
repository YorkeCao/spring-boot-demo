package io.yorkecao.springbootdemo.service;

import io.yorkecao.springbootdemo.domain.DemoException;

/**
 * @author Yorke
 */
public interface DemoService {

    /**
     * 问候
     * @return 问候语
     * @throws DemoException 异常
     */
    String sayHello() throws DemoException;
}
