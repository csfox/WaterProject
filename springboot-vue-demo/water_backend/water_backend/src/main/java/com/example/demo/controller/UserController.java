package com.example.demo.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserMapper userMapper;

    @PostMapping //新增
    public Result<?> save(@RequestBody User user){//将前台JSON数据转换为user对象
        if(user.getPassword()==null){
            user.setPassword("123456");
        }
        userMapper.insert(user);
        return Result.success();
    }

    @PutMapping //更新
    public Result<?> update(@RequestBody User user){//将前台JSON数据转换为user对象
        userMapper.updateById(user);
        return Result.success();
    }
    @DeleteMapping("/{id}") //更新
    public Result<?> update(@PathVariable Long id){//将前台JSON数据转换为user对象
        userMapper.deleteById(id);
        return Result.success();
    }

    @GetMapping //查询
    public Result<?> FindPage(@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "20") Integer pageSize,@RequestParam(defaultValue = "") String search){//将前台JSON数据转换为user对象
        LambdaQueryWrapper<User> wrapper= Wrappers.<User>lambdaQuery();

        if(StrUtil.isNotBlank(search)){
            wrapper.like(User::getNickName,search);
        }

        Page<User> userPage = userMapper.selectPage(new Page<>(pageNum,pageSize), wrapper);
        return Result.success(userPage);
    }

}
