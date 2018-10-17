package io.yorkecao.springbootdemo.web;

import io.yorkecao.springbootdemo.domain.Result;
import io.yorkecao.springbootdemo.service.DemoService;
import io.yorkecao.springbootdemo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public Result sayHello(@RequestParam int id) {
        String hello = demoService.sayHello(id);
        return ResultUtil.success(hello);
    }
}
