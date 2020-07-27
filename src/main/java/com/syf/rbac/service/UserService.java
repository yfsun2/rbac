package com.syf.rbac.service;

import com.syf.rbac.entity.User;
import com.syf.rbac.entity.UserRole;

import java.util.List;
import java.util.Map;

/**
 * @Author syf
 * @Date 2020/7/26 20:27
 */
public interface UserService {

    /**
     * 查询全部用户
     * @return 用户列表
     */
    List<User> getAll();
    /**
     * 添加用户
     * @param user 用户实例
     * @return 0,1
     */
    int add(User user);
    /**
     * 更新用户
     * @param user 用户实例
     * @return 0,1
     */
    int update(User user);
    /**
     * 根据id删除用户
     * @param id 用户id
     * @return 0,1
     */
    int delete(Long id);

    /**
     * 给用户设置角色
     * @param userRole 用户角色id映射
     * @return 0,1
     */
    int setRole(UserRole userRole);

    /**
     * 根据用户id查权限
     * @param id id
     * @return map
     */
    List<Map<String, Object>> selectPermission(Long id);

}
