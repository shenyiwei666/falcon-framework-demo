package org.falcon.demo.user.provider.dubbo;

import org.falcon.demo.user.provider.dto.UserBean;

public interface UserProviderService {

//    @IgnoreLogging
    UserBean getUser(Long id);

    UserBean getUser(Long id, String name);

}
