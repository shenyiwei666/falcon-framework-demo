package org.falcon.demo.user;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo(scanBasePackages = {"org.falcon.demo"})
@SpringBootApplication(scanBasePackages = {"org.falcon.demo"})
public class UserApp {

    public static void main(String[] args) {
        SpringApplication.run(UserApp.class, args);
    }

}
