package com.me.article.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.enums.AppHttpCodeEnum;
import com.heima.model.common.user.dtos.LoginDto;
import com.heima.model.common.user.pojos.ApUser;
import com.heima.utils.common.AppJwtUtil;
import com.me.article.mapper.ApuserMapper;
import com.me.article.service.ApUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class ApUserServiceImpl extends ServiceImpl<ApuserMapper, ApUser> implements ApUserService {

    @Override
    public ResponseResult login(LoginDto loginDto) {

log.warn(loginDto.toString());
        ApUser user = getOne(Wrappers.<ApUser>lambdaQuery().eq(ApUser::getPhone, loginDto.getPhone()));
if (user==null)
{
    return   ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST,"信息不存在");
}

        String salt = user.getSalt();
        String password = user.getPassword();
        String s = DigestUtils.md5DigestAsHex((password + salt).getBytes());
        if (!s.equals(password))
        {
            return   ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_PASSWORD_ERROR);
        }
        String token = AppJwtUtil.getToken(user.getId().longValue());
        Map <String ,Object> map=new HashMap<>();
        map.put("token",token);
        user.setSalt(null);
        user.setPassword(null);

        map.put("user",user);
      return   ResponseResult.okResult(map);


    }
}
