package com.example.demo.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.socket.WebSocketUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/user")
@ServerEndpoint("/user/{username}")
public class UserController {

    @Resource
    UserMapper userMapper;

    @PostMapping //新增
    public Result<?> save(@RequestBody User user){//将前台JSON数据转换为user对象
        if(user.getPassword()==null){
            user.setPassword("123456");
        }
        userMapper.insert(user);

        forDingShi();

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

//    @GetMapping //查询
//    public Result<?> FindPage(@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "20") Integer pageSize,@RequestParam(defaultValue = "") String search){//将前台JSON数据转换为user对象
//        LambdaQueryWrapper<User> wrapper= Wrappers.<User>lambdaQuery();
//
//        if(StrUtil.isNotBlank(search)){
//            wrapper.like(User::getNickName,search);
//        }
//
//        Page<User> userPage = userMapper.selectPage(new Page<>(pageNum,pageSize), wrapper);
//        System.out.println(userPage);
//        return Result.success(userPage);
//    }

    @GetMapping //查询全部数据，不带分页
    public Result<?> List(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("id","age");
        List<User> users = userMapper.selectList(wrapper);
        return Result.success(users.get(users.size()-1));

    }

    @OnOpen
    public void openSession(@PathParam("username") String username, Session session){
        //存储用户
        WebSocketUtil.USERS_ONLINE.put(username, session);
        System.out.print(username);
    }

    @OnClose
    public void closeSession(@PathParam("username") String username, Session session){
        //删除用户
        WebSocketUtil.USERS_ONLINE.remove(username);
        //下线后关闭session
        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnMessage
    public void onMessage(@PathParam("username") String username, String message){
        forDingShi();
    }

    //@Scheduled(fixedRate=2000)
    public void forDingShi(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("id","age");
        List<User> users = userMapper.selectList(wrapper);
        //System.out.println(message);
        WebSocketUtil.sendMessageToAllOnlineUser(JSONUtil.toJsonStr(users.get(users.size()-1)));
        System.out.println(JSONUtil.toJsonStr(users.get(users.size()-1)));
    }

    @OnError
    public void sessionError(Session session, Throwable throwable){
        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("WebSocket连接发生异常，message:"+throwable.getMessage());
    }


}
