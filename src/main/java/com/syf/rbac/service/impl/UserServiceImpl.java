package com.syf.rbac.service.impl;

import com.syf.rbac.entity.User;
import com.syf.rbac.entity.UserRole;
import com.syf.rbac.mapper.UserMapper;
import com.syf.rbac.mapper.UserRoleMapper;
import com.syf.rbac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author syf
 * @Date 2020/7/26 21:44
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<User> getAll() {
        return userMapper.selectList(null);
    }

    @Override
    public int add(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int update(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public int delete(Long id) {
        return userMapper.deleteById(id);
    }

    @Override
    public int setRole(UserRole userrole) {
        return userRoleMapper.insert(userrole);
    }

    @Override
    public List<Map<String, Object>> selectPermission(Long id) {
        return userMapper.selectPermission(id);
    }

}
