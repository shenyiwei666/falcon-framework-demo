package org.falconframework.demo;

import com.shenyiwei.LoggingPrinter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.MDC;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;


@Slf4j
@SpringBootTest
class FalconFrameworkDemoApplicationTests {

    @Test
    void testLog() {
        MDC.put("X-B3-TraceId", UUID.randomUUID().toString().replace("-", ""));

        log.debug("debug日志, p1={}, p2={}", "aaa", "bbb");
        log.info("info日志, p1={}, p2={}", "aaa", "bbb");
        log.warn("warn日志, p1={}, p2={}", "aaa", "bbb");
        try {
            Integer.parseInt("a");
        } catch (Exception e) {
            log.error("error日志, p1={}, p2={}", "aaa", "bbb", e);
        }
        LoggingPrinter.print();

        try {
            System.out.println("---------- sleep -----------");
            Thread.sleep(1000 * 3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
