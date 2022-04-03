package org.falcon.demo.logging.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.falcon.demo.user.provider.dto.UserBean;
import org.falcon.demo.user.provider.dubbo.UserProviderService;
import org.falcon.demo.user.provider.feign.UserFeign;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

    @DubboReference(url = "dubbo://127.0.0.1:20880")
    private UserProviderService userProviderService;

    @Value("${logging.level.org.falcon}")
    private String level;

    @GetMapping("/test")
    public String test() {
        log.info("restTemplate调用用户查询接口开始");
        JSONObject restUser = restTemplate.getForObject("http://localhost:9000/user/get/1", JSONObject.class);
        log.info("restTemplate调用用户查询接口结束：{}", restUser.toJSONString());

        log.info("feign调用用户查询接口开始");
        UserBean feignUser = userFeign.getUserById(1L);
        log.info("feign调用用户查询接口结束：{}", JSON.toJSONString(feignUser));

        log.info("dubbo调用用户查询接口开始");
        UserBean dubboUser = userProviderService.getUser(1L);
        log.info("dubbo调用用户查询接口结束：{}", JSON.toJSONString(dubboUser));

        String message = "msg-" + System.currentTimeMillis();
        rabbitTemplate.convertAndSend("exchange.direct.faceid", "routing.faceid.lineStatistic_local", message);
        log.info("rabbitMQ发送消息：{}", message);

        log.warn("warn log level={}", level);

        try {
            Integer.parseInt("abc");
        } catch (Exception e) {
            log.error("系统异常", e);
        }

        return "OK";
    }

}
