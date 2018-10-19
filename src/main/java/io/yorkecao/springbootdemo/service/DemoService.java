package io.yorkecao.springbootdemo.service;

import io.yorkecao.springbootdemo.domain.model.DemoException;

/**
 * @author Yorke
 */
public interface DemoService {

    /**
     * 问候
     * @param id 用户ID
     * @return 问候语
     * @throws DemoException 异常
     */
    String sayHello(int id) throws DemoException;
}
