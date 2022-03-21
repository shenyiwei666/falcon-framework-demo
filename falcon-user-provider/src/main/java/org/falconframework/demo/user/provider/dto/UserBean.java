package org.falconframework.demo.user.provider.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserBean implements Serializable {

    private Long id;

    private String username;

    private Integer age;

}
