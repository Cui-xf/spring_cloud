package cc.service_ribbon.controller;

import cc.service_ribbon.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @program: spring_cloud
 * @description:
 * @author: C_xf
 * @create: 2018-12-05 19:39
 **/
@RestController
@Slf4j
public class TestController {

    @Value("${server.port}")
    private String port;

    @Autowired
    TestService service;

    @RequestMapping("/hello")
    public String hello(String name)
    {
        log.debug("远程调用："+name);
        return "端口："+port+","+service.hello(name);
    }
}
