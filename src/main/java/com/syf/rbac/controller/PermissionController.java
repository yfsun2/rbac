package com.syf.rbac.controller;

import com.syf.rbac.entity.Permission;
import com.syf.rbac.service.impl.PermissionServiceImpl;
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
public class PermissionController {

    @Autowired
    private PermissionServiceImpl permissionService;

    @RequestMapping("/addPermission")
    public String add(Permission permission){
        int insert = permissionService.add(permission);
        if (insert==1){
            return " insert successful";
        }else {
            return " insert defeat";
        }

    }

    @RequestMapping("/getAllPermission")
    public List<Permission> getAll(){
        return permissionService.getAll();
    }

    @RequestMapping("/updatePermission")
    public int update(Permission permission){
        return permissionService.update(permission);
    }

    @RequestMapping("/deletePermission/{id}")
    public int update(@PathVariable("id") long id){
        return permissionService.delete(id);
    }
}
