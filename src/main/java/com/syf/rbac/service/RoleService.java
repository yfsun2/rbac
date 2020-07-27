package com.syf.rbac.service;

import com.syf.rbac.entity.Role;
import com.syf.rbac.entity.RolePermission;

import java.util.List;

/**
 * @Author syf
 * @Date 2020/7/26 21:42
 */
public interface RoleService {
    /**
     * 查询全部角色
     * @return 角色列表
     */
    List<Role> getAll();

    /**
     * 添加角色
     * @param role 角色实例
     * @return 0,1
     */
    int add(Role role);

    /**
     * 更新角色
     * @param role 角色实例
     * @return 0,1
     */
    int update(Role role);

    /**
     * 根据id删除角色
     * @param id 角色id
     * @return 0,1
     */
    int delete(Long id);

    /**
     * 给角色设置权限
     * @param rolePermission 角色权限id映射
     * @return 0,1
     */
    int setPermission(RolePermission rolePermission);
}
