package io.yorkecao.springbootdemo.web;

import io.yorkecao.springbootdemo.annotation.DemoAction;
import io.yorkecao.springbootdemo.constants.DemoConstant;
import io.yorkecao.springbootdemo.domain.Result;
import io.yorkecao.springbootdemo.service.DemoService;
import io.yorkecao.springbootdemo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DemoAction(actionType = DemoConstant.ACTION_TYPE_QUERY)
    @RequestMapping(value = "sayHello", method = RequestMethod.GET)
    public Result sayHello(@RequestParam int id) {
        String hello = demoService.sayHello(id);
        return ResultUtil.success(hello);
    }
}
