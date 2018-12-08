package cc.service_feign.to_service;

import org.springframework.stereotype.Component;

/**
 * @program: spring_cloud
 * @description:
 * @author: C_xf
 * @create: 2018-12-05 21:43
 **/

@Component
public class To_Service_Def implements To_Service {
    public String sayHiFromClientOne(String name) {
        return "Sorry " +name+" error!";
    }
}
