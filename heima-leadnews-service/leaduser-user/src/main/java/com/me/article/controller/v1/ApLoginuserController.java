package com.me.article.controller.v1;

import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.user.dtos.LoginDto;
import com.me.article.service.ApUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/login")
public class ApLoginuserController {
@Autowired
    ApUserService apUserService;
@PostMapping("/login_auth")
    public ResponseResult login(@RequestBody @Validated LoginDto loginDto)
    {

return  apUserService.login(loginDto);
    }

}
