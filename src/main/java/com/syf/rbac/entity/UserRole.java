package com.syf.rbac.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author syf
 * @Date 2020/7/26 16:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRole {

    private Long userId;

    private Long roleId;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

}
