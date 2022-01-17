package com.example.demo.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.common.Result;
import com.example.demo.entity.Admin;
import com.example.demo.entity.User;
import com.example.demo.mapper.AdminMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    AdminMapper adminMapper;
    @PostMapping("/login")
    public Result<?> login(@RequestBody Admin admin)
    {
        Admin res= adminMapper.selectOne(Wrappers.<Admin>lambdaQuery().eq(Admin::getUsername,admin.getUsername()).eq(Admin::getPassword,admin.getPassword()));
        if(res==null)
        {
            return Result.error("-1","用户名或密码错误");
        }
        return Result.success();
    }
    @PostMapping("/register")
    public Result<?> register(@RequestBody Admin admin)
    {
        Admin res= adminMapper.selectOne(Wrappers.<Admin>lambdaQuery().eq(Admin::getUsername,admin.getUsername()));
        if(res!=null)
        {
            return Result.error("-1","用户名重复");
        }
        adminMapper.insert(admin);
        return Result.success();
    }

}
