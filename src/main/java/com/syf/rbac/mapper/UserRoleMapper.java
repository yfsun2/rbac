package com.syf.rbac.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.syf.rbac.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author syf
 * @Date 2020/7/26 20:24
 */
@Repository
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {
}
