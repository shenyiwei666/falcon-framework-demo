package org.falconframework.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.falconframework.demo")
public class FalconFrameworkDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FalconFrameworkDemoApplication.class, args);
    }

}
