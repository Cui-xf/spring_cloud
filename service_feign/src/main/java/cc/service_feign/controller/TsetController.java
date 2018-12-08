package cc.service_feign.controller;

import cc.service_feign.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring_cloud
 * @description:
 * @author: C_xf
 * @create: 2018-12-05 20:15
 **/
@RestController
@Slf4j
public class TsetController {
    @Value("${server.port}")
    private String port;

    @Autowired
    TestService service;

    @RequestMapping("/hello")
    public String hello(String name)
    {
        log.debug("调用远程服务："+name);
        return "端口："+port+"，"+ service.sayHello(name);
    }
}
