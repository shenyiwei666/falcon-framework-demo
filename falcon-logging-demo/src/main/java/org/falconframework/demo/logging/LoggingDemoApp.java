package org.falconframework.demo.logging;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDubbo(scanBasePackages = {"org.falconframework"})
@EnableFeignClients(basePackages = "org.falconframework")
@SpringBootApplication(scanBasePackages = {"org.falconframework"})
public class LoggingDemoApp {

    public static void main(String[] args) {
        SpringApplication.run(LoggingDemoApp.class, args);
    }

}
