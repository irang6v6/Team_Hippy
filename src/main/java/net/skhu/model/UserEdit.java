package net.skhu.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserEdit {
    int id;

    @NotEmpty(message="로그인 아이디를 입력하세요")
    @Size(min=3, max=15)
    String loginName;

    @NotEmpty(message="이름을 입력하세요")
    @Size(min=2, max=30)
    String name;

    @NotEmpty(message="이메일 주소를 입력하세요")
    @Email(message="이메일 주소가 올바르지 않습니다")
    String email;

    boolean enabled;
    String[] roles;
}
