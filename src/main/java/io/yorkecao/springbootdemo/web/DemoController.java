package io.yorkecao.springbootdemo.web;

import io.yorkecao.springbootdemo.annotation.DemoAction;
import io.yorkecao.springbootdemo.api.ApiUrls;
import io.yorkecao.springbootdemo.constants.DemoConstant;
import io.yorkecao.springbootdemo.domain.Result;
import io.yorkecao.springbootdemo.service.DemoService;
import io.yorkecao.springbootdemo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yorke
 */
@RestController
@RequestMapping(ApiUrls.HELLO_WORLD_URL)
public class DemoController {

    private final DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @DemoAction(actionType = DemoConstant.ACTION_TYPE_QUERY)
    @GetMapping("sayHello")
    public ResponseEntity<?> sayHello(@RequestParam int id) {
        String hello = demoService.sayHello(id);
        return ResponseEntity.ok(new Result(hello));
    }
}
