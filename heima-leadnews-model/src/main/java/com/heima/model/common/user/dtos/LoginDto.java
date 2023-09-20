package com.heima.model.common.user.dtos;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginDto {
    @NotEmpty(message = "电话不能为空")
    private  String phone;
    @NotEmpty(message = "密码不能为空")
    private String password;

}
