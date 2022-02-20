/*
 * 深圳市灵智数科有限公司版权所有.
 */
package com.shenyiwei;

import lombok.extern.slf4j.Slf4j;

/**
 * 功能说明
 *
 * @author 申益炜
 * @version 1.0.0
 * @date 2022/1/11
 */
@Slf4j
public class LoggingPrinter {

    public static void print() {
        System.out.println("\n\n\n");
        log.debug("com.shenyiwei print LoggingTest debug");
        log.info("com.shenyiwei print LoggingTest info");
        log.warn("com.shenyiwei print LoggingTest warn");
        log.error("com.shenyiwei print LoggingTest error");
    }


}
