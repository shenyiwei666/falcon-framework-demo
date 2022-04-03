package org.falcon.demo.user.service;

import org.falcon.demo.user.provider.dto.UserBean;

public interface UserService {

    UserBean getUserById(Long id);

}
