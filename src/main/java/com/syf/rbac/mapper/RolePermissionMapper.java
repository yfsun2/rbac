package com.syf.rbac.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.syf.rbac.entity.RolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author syf
 * @Date 2020/7/26 20:22
 */
@Repository
@Mapper
public interface RolePermissionMapper extends BaseMapper<RolePermission> {
}
