package org.falconframework.demo.user.dubbo;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.falconframework.demo.user.provider.dto.UserBean;
import org.falconframework.demo.user.provider.dubbo.UserProviderService;
import org.falconframework.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@DubboService
public class UserProviderServiceImpl implements UserProviderService {

    @Autowired
    private UserService userService;

    @Override
    public UserBean getUserById(Long id) {
        log.info("dubbo provider getUserById");
        return userService.getUserById(id);
    }

}
