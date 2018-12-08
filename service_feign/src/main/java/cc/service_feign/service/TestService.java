package cc.service_feign.service;


import cc.service_feign.to_service.To_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @program: spring_cloud
 * @description:
 * @author: C_xf
 * @create: 2018-12-05 21:13
 **/
@Service
public class TestService {

    @Autowired
    private To_Service service;

    public String sayHello(String name)
    {
        return service.sayHiFromClientOne(name);
    }

}
