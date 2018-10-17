package io.yorkecao.springbootdemo.service.impl;

import io.yorkecao.springbootdemo.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * @author Yorke
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello() {
        return "hello world";
    }
}
