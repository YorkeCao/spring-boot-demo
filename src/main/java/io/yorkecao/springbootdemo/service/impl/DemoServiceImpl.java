package io.yorkecao.springbootdemo.service.impl;

import io.yorkecao.springbootdemo.constants.ExceptionEnum;
import io.yorkecao.springbootdemo.domain.DemoException;
import io.yorkecao.springbootdemo.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * @author Yorke
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello() throws DemoException {
        throw new DemoException(ExceptionEnum.ERROR);
//        return "hello world";
    }
}
