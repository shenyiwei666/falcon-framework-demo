package org.falconframework.demo.logging.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.falconframework.demo.common.server.feign.UserFeign;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 功能说明
 *
 * @author 申益炜
 * @version 1.0.0
 * @date 2022/3/7
 */
@Slf4j
@RequestMapping("/logging")
@RestController
public class ServerLoggingController {

    @Autowired
    private UserFeign userFeign;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/test")
    public String test() {
        log.info("feign调用用户查询接口开始");
        JSONObject feignUserInfo = userFeign.get("1");
        log.info("feign调用用户查询接口结束：{}", feignUserInfo.toJSONString());

        log.info("restTemplate调用用户查询接口开始");
        JSONObject restUserInfo = restTemplate.getForObject("http://localhost:9000/user/get/1", JSONObject.class);
        log.info("restTemplate调用用户查询接口结束：{}", restUserInfo.toJSONString());


        String message = "msg-" + System.currentTimeMillis();
        rabbitTemplate.convertAndSend("exchange.direct.faceid", "routing.faceid.lineStatistic_local", message);
        log.info("rabbitMQ发送消息：{}", message);

        return "OK";
    }

}
