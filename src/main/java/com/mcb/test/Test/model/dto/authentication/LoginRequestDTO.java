package com.mcb.test.Test.model.dto.authentication;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDTO {
    private String login;
    private String password;
}
