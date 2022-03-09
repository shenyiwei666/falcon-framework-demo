package org.falconframework.demo.common.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.falconframework")
public class CommonServerApp {

    public static void main(String[] args) {
        SpringApplication.run(CommonServerApp.class, args);
    }

}
