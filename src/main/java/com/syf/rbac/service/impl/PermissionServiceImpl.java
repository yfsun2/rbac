package com.syf.rbac.service.impl;

import com.syf.rbac.entity.Permission;
import com.syf.rbac.mapper.PermissionMapper;
import com.syf.rbac.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author syf
 * @Date 2020/7/26 21:45
 */

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> getAll() {
        return permissionMapper.selectList(null);
    }

    @Override
    public int add(Permission role) {
        return permissionMapper.insert(role);
    }

    @Override
    public int update(Permission role) {
        return permissionMapper.updateById(role);
    }

    @Override
    public int delete(Long id) {
        return permissionMapper.deleteById(id);
    }
}
