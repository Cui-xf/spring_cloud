package cc.service_ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 * @program: spring_cloud
 * @description:
 * @author: C_xf
 * @create: 2018-12-05 21:22
 **/
@Service
@Slf4j
public class TestService {

    private String servername = "SERVICE1";

    @Autowired
    RestTemplate restTemplate;

    //断路后返回函数（参数签名必须一致）
    @HystrixCommand(fallbackMethod = "sayError")
    public String hello(String name)
    {
        ResponseEntity entity = restTemplate.getForEntity("http://"+servername+"/hello?name="+name,String.class);
        return (String) entity.getBody();
    }

    public String sayError(String name)
    {
        return "Sorry "+name+" error!";
    }
}
