package com.syf.rbac.service.impl;

import com.syf.rbac.entity.Role;
import com.syf.rbac.entity.RolePermission;
import com.syf.rbac.mapper.RoleMapper;
import com.syf.rbac.mapper.RolePermissionMapper;
import com.syf.rbac.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author syf
 * @Date 2020/7/26 21:45
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public List<Role> getAll() {
        return roleMapper.selectList(null);
    }

    @Override
    public int add(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public int update(Role role) {
        return roleMapper.updateById(role);
    }

    @Override
    public int delete(Long id) {
        return roleMapper.deleteById(id);
    }

    @Override
    public int setPermission(RolePermission rolePermission) {
        return rolePermissionMapper.insert(rolePermission);
    }
}
