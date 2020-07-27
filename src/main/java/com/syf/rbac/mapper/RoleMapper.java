package com.syf.rbac.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.syf.rbac.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author syf
 * @Date 2020/7/26 17:49
 */
@Repository
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
}
