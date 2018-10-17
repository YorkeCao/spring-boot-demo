package io.yorkecao.springbootdemo.web;

import io.yorkecao.springbootdemo.constants.DemoResponse;
import io.yorkecao.springbootdemo.domain.ResponseVo;
import io.yorkecao.springbootdemo.service.DemoService;
import io.yorkecao.springbootdemo.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yorke
 */
@RestController
public class DemoController {

    private final DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("sayHello")
    public ResponseVo sayHello() {
        String hello = demoService.sayHello();
        return ResponseUtils.success(hello);
    }
}
