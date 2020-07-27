package com.syf.rbac.service;

import com.syf.rbac.entity.Permission;

import java.util.List;

/**
 * @Author syf
 * @Date 2020/7/26 21:43
 */
public interface PermissionService {
    /**
     * 获取全部权限
     * @return 权限列表
     */
    List<Permission> getAll();

    /**
     * 增加一个权限
     * @param permission 权限实例
     * @return 0,1
     */
    int add(Permission permission);

    /**
     * 更新权限
     * @param permission 权限实例
     * @return 0,1
     */
    int update(Permission permission);

    /**
     * 删除权限
     * @param id 权限id
     * @return 0,1
     */
    int delete(Long id);
}
