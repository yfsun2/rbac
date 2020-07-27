package com.syf.rbac.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.syf.rbac.entity.Role;
import com.syf.rbac.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author syf
 * @Date 2020/7/26 17:48
 */
@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT `user`.id 用户ID,`user`.`name` 用户姓名,role.`name` 角色名称,permission.title 拥有的权限 from permission INNER JOIN role_permission INNER JOIN role INNER JOIN user_role INNER JOIN `user` ON permission.id=role_permission.permission_id AND role_permission.role_id=role.id\n" +
            "AND role.id=user_role.role_id and user_role.user_id=`user`.id WHERE `user`.id=${id}")
    List<Map<String, Object>> selectPermission(@Param("id") Long id);

    @Select("SELECT * from `user` where `user`.name='${username}'")
    User loadUserByUsername(String username);

    @Select("select role.name from role where role.id in(select role_id from user_role INNER JOIN `user` ON user_role.user_id=`user`.id where `user`.name='${username}')")
    List<Role> findRoleByUsername(String username);
}
