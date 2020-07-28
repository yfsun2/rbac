package com.syf.rbac.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author syf
 * @Date 2020/7/26 16:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class User {

    private Long id;

    private String name;

    private String password;

    @TableLogic
    private Integer deleted;

    @Version
    private Integer version;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
}
