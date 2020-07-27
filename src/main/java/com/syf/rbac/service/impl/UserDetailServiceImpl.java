package com.syf.rbac.service.impl;


import com.syf.rbac.entity.Role;
import com.syf.rbac.entity.User;
import com.syf.rbac.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author syf
 * @Date 2020/7/27 16:25
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService  {

    @Autowired
    private UserMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String username) {
        User myUser=userMapper.loadUserByUsername(username);
        if(myUser==null){
            throw new UsernameNotFoundException("用户不存在");
        }
        List<Role> roles=userMapper.findRoleByUsername(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (int i = 0; i < roles.size(); i++) {
            authorities.add(new SimpleGrantedAuthority(roles.get(i).getName()));
        }
        // 构建 Security 的 User 对象

        return new org.springframework.security.core.userdetails.User(myUser.getName(), myUser.getPassword(), authorities);
    }
}
