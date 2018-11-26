package io.yorkecao.springbootdemo.service.impl;

import io.yorkecao.springbootdemo.constants.ExceptionType;
import io.yorkecao.springbootdemo.model.DemoException;
import io.yorkecao.springbootdemo.model.User;
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

    private final UserMapper userMapper;

    @Autowired
    public DemoServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public String sayHello(int id) throws DemoException {
        String name = Optional.ofNullable(userMapper.selectUserById(id))
                .map(User::getName)
                .orElseThrow(() -> new DemoException(ExceptionType.SELECT_ERROR_CAN_NOT_FIND_USER));

        return "hello, " + name;
    }
}
