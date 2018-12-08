package cc.service_ribbon.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @program: spring_cloud
 * @description:
 * @author: C_xf
 * @create: 2018-12-05 19:42
 **/
@Configuration
@Slf4j
public class RestTemplateConfig {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate()
    {
        log.debug("注入RestTemplate！");
        return new RestTemplate();
    }
}
