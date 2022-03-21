package org.falconframework.demo.user.provider.feign;

import org.falconframework.demo.user.provider.dto.UserBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "falcon-commom-server", url = "http://localhost:9000")
public interface UserFeign {

    @GetMapping("/user/get/{userid}")
    UserBean getUserById(@PathVariable("userid") Long userid);

}
