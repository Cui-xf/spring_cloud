package cc.config_client.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring_cloud
 * @description:
 * @author: C_xf
 * @create: 2018-12-07 17:08
 **/
@RestController
public class TestController {
    @Value("${server.port}")
    String foo;
    @GetMapping("/read")
    public String read()
    {
        return foo;
    }
}
