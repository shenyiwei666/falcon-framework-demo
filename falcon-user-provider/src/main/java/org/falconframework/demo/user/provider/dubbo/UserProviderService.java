package org.falconframework.demo.user.provider.dubbo;

import org.falconframework.demo.user.provider.dto.UserBean;

public interface UserProviderService {

//    @IgnoreLogging
    UserBean getUser(Long id);

    UserBean getUser(Long id, String name);

}
