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
    public UserBean getUser(Long id) {
        log.info("invoke getUser(Long id)");
        return userService.getUserById(id);
    }

    @Override
    public UserBean getUser(Long id, String name) {
        log.info("invoke getUser(Long id, String name)");
        return userService.getUserById(id);
    }
}
