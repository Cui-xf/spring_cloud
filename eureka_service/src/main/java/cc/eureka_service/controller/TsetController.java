package cc.eureka_service.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring_cloud
 * @description:
 * @author: C_xf
 * @create: 2018-12-05 22:52
 **/
@RestController
@Slf4j
public class TsetController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/hello")
    public String hello(String name)
    {
        log.debug("本地调用："+name);
        return "端口："+port+" Hello "+name;
    }
}
