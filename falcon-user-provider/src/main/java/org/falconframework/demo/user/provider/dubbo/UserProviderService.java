package org.falconframework.demo.user.provider.dubbo;

import org.falconframework.demo.user.provider.dto.UserBean;

public interface UserProviderService {

    UserBean getUserById(Long id);

}
