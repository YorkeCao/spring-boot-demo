package io.yorkecao.springbootdemo.service.impl;

import io.yorkecao.springbootdemo.constants.ExceptionEnum;
import io.yorkecao.springbootdemo.domain.DemoException;
import io.yorkecao.springbootdemo.domain.User;
import io.yorkecao.springbootdemo.mapper.UserMapper;
import io.yorkecao.springbootdemo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


/**
 * @author Yorke
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String sayHello(int id) throws DemoException {
        String name = Optional.ofNullable(userMapper.selectUserById(id))
                .map(User::getName)
                .orElseThrow(() -> new DemoException(ExceptionEnum.SELECT_ERROR_CAN_NOT_FIND_USER));

        return "hello, " + name;
    }
}
