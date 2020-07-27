package com.syf.rbac.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @Author syf
 * @Date 2020/7/27 17:05
 */
@Component
@Slf4j
public class MyAuthenticationProvider implements AuthenticationProvider {

//    @Autowired
    private UserDetailServiceImpl userDetailServiceImpl=new UserDetailServiceImpl();

    @Override
    public Authentication authenticate(Authentication authentication)  {
        String username=authentication.getName();
        String password=authentication.getCredentials().toString();
        log.info("用户名"+username);
        log.info("密码"+password);
        UserDetails userDetails = userDetailServiceImpl.loadUserByUsername(username);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        boolean flag = bCryptPasswordEncoder.matches(password, userDetails.getPassword());
        // 校验通过
        if (flag){
            // 将权限信息也封装进去
            return new UsernamePasswordAuthenticationToken(userDetails,password,userDetails.getAuthorities());
        }
        // 验证失败返回 null
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
