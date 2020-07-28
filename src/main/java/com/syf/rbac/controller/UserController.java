package com.syf.rbac.controller;

import com.syf.rbac.entity.User;
import com.syf.rbac.entity.UserRole;
import com.syf.rbac.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author syf
 * @Date 2020/7/26 18:42
 */
@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/addUser")
    public String addUser(User user){
        int insert = userService.add(user);
        if (insert==1){
            return " insert successful";
        }else {
            return " insert defeat";
        }
    }

    @RequestMapping("/getAllUser")
    public List<User> getAll(){
        return userService.getAll();
    }

    @RequestMapping("/updateUser")
    public int update(User user){
        return userService.update(user);
    }

    @RequestMapping("/deleteUser/{id}")
    public int update(@PathVariable("id") long id){
        return userService.delete(id);
    }

    @RequestMapping("/setRole")
    public int set(UserRole userRole){
        return userService.setRole(userRole);
    }

    @RequestMapping("/selectPermission/{name}")
    public List<Map<String, Object>> select(@PathVariable("name") String name){
        return userService.selectPermission(name);
    }
}
