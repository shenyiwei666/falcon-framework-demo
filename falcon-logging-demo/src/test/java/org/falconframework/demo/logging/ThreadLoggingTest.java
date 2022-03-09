package org.falconframework.demo.logging;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.falconframework.logging.constant.LoggingConstant;
import org.falconframework.logging.thread.MdcRunnable;
import org.junit.jupiter.api.Test;
import org.slf4j.MDC;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


@Slf4j
@SpringBootTest
public class ThreadLoggingTest {

    ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
            1,
            1,
            0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(),
            new ThreadFactoryBuilder().setNameFormat("LoggingTestPool-%d").build(),
            new ThreadPoolExecutor.AbortPolicy());

    @Test
    public void test(){
        // 如果这里不设置traceId，控制台打印的日志不会有traceId，但是发送到kafka的日志会自动设置traceId
        MDC.put(LoggingConstant.TRACE_ID, System.currentTimeMillis() + "");

        log.info("主线程日志");

        // 使用MdcRunnable将主线程中的MDC信息传递到子线程，这样子线程输入的日志就会带上主线程的traceId
        threadPool.execute(new MdcRunnable() {
            @Override
            public void call() {
                log.info("子线程第1次日志");
            }
        });

        // 改变traceId
        MDC.put(LoggingConstant.TRACE_ID, "2222222222222");

        threadPool.execute(new MdcRunnable() {
            @Override
            public void call() {
                log.info("子线程第2次日志");
            }
        });

        try {
            Integer.parseInt("a");
        } catch (Exception e) {
            log.error("主线程错误日志", e);
        }

        try {
            // 日志是异步发送到kafka，所以需要等待日志发送完毕才能结束程序
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
