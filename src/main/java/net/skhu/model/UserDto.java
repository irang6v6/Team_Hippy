package net.skhu.model;

import lombok.Data;

@Data
public class UserDto {
    int id;

    String loginName;
    String name;
    String email;
    String nickName;

    boolean enabled;
    String[] roles;
}

