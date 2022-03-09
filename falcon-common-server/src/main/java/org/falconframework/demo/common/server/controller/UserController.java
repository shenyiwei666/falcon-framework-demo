package org.falconframework.demo.common.server.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能说明
 *
 * @author 申益炜
 * @version 1.0.0
 * @date 2022/3/7
 */
@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {

    @GetMapping("/get/{userid}")
    public JSONObject get(@PathVariable("userid") String userid) {
        log.info("查询用户信息，请求参数：userid={}", userid);
        JSONObject userInfo = new JSONObject();
        userInfo.put("userid", userid);
        userInfo.put("userName", "张三");
        userInfo.put("age", 18);
        log.info("查询用户信息，返回结果：{}", userInfo.toJSONString());
        return userInfo;
    }

}
