package org.falconframework.demo.common.server.feign;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 功能说明
 *
 * @author 申益炜
 * @version 1.0.0
 * @date 2022/3/7
 */
@FeignClient(name = "falcon-commom-server", url = "http://localhost:9000")
public interface UserFeign {

    @GetMapping("/user/get/{userid}")
    JSONObject get(@PathVariable("userid") String userid);

}
