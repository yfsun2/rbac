package com.syf.rbac.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author syf
 * @Date 2020/7/26 16:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolePermission {

    private Long roleId;

    private Long permissionId;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

}
