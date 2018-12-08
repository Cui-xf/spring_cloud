package cc.service_ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
//允许向注册中心注册
@EnableEurekaClient
//允许发现客户端
@EnableDiscoveryClient
//开启断路器
@EnableHystrix
public class ServiceRibbonApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServiceRibbonApplication.class, args);
	}
}
