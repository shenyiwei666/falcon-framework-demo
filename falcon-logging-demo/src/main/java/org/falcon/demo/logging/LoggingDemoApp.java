package org.falcon.demo.logging;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDubbo(scanBasePackages = {"org.falcon.demo"})
@EnableFeignClients(basePackages = "org.falcon.demo")
@SpringBootApplication(scanBasePackages = {"org.falcon.demo"})
public class LoggingDemoApp {

    public static void main(String[] args) {
        SpringApplication.run(LoggingDemoApp.class, args);
    }

}
