package com.syf.rbac.controller;

import com.syf.rbac.entity.Role;
import com.syf.rbac.entity.RolePermission;
import com.syf.rbac.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author syf
 * @Date 2020/7/26 22:21
 */
@RestController
public class RoleController {

    @Autowired
    private RoleServiceImpl roleService;

    @RequestMapping("/addRole")
    public String add(Role role){
        int insert = roleService.add(role);
        if (insert==1){
            return " insert successful";
        }else {
            return " insert defeat";
        }
    }

    @RequestMapping("/getAllRole")
    public List<Role> getAll(){
        return roleService.getAll();
    }

    @RequestMapping("/updateRole")
    public int update(Role role){
        return roleService.update(role);
    }

    @RequestMapping("/deleteRole/{id}")
    public int update(@PathVariable("id") long id){
        return roleService.delete(id);
    }

    @RequestMapping("/setPermission")
    public int set(RolePermission rolePermission){
        return roleService.setPermission(rolePermission);
    }
}
