package org.falconframework.demo.user.service;

import org.falconframework.demo.user.provider.dto.UserBean;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserBean getUserById(Long id) {
        UserBean user = new UserBean();
        user.setId(id);
        user.setUsername("张三");
        user.setAge(18);
        return user;
    }

}
