package org.falconframework.demo.user.service;

import org.falconframework.demo.user.provider.dto.UserBean;

public interface UserService {

    UserBean getUserById(Long id);

}
