package com.auxing.vue_server.controller;


import com.alibaba.fastjson.JSONObject;
import com.auxing.vue_server.entity.User;
import com.auxing.vue_server.service.IUserService;
import com.auxing.vue_server.utils.BlogResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author auxing
 * @since 2019-03-08
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService iUserService;

    @GetMapping("/login")
    public String login(String username,String password){
        BlogResult blogResult=BlogResult.getInstance();
        try{
            User user=iUserService.getOne(new QueryWrapper<User>().eq("USERNAME",username).eq("PASSWORD",password));
            if(user != null){
                blogResult.setCode(200);
                blogResult.setData(user);
            }else{
                blogResult.setCode(500);
            }
            return JSONObject.toJSONString(blogResult);
        }catch (Exception e){
            e.printStackTrace();
            blogResult.setCode(500);
            return JSONObject.toJSONString(blogResult);
        }
    }
}
