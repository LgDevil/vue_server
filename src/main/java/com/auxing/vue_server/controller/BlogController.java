package com.auxing.vue_server.controller;


import com.alibaba.fastjson.JSONObject;
import com.auxing.vue_server.entity.Blog;
import com.auxing.vue_server.service.IBlogService;
import com.auxing.vue_server.utils.BlogResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author auxing
 * @since 2019-03-08
 */
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    IBlogService iBlogService;

    @PostMapping(value = "/save",consumes = "application/json")
    public String sve(@RequestBody Blog blog){
        BlogResult blogResult=BlogResult.getInstance();
        try{
            blog.setId(UUID.randomUUID().toString().replace("-",""));

            //获得最大index
            Blog maxIndexBlog=iBlogService.getOne(new QueryWrapper<Blog>().orderByAsc("BLOGINDEX"));
            if(maxIndexBlog == null){
                blog.setBlogindex("1");
            }else{
                blog.setBlogindex(String.valueOf(Integer.parseInt(maxIndexBlog.getBlogindex())+1));
            }
            blogResult.setCode(200);
            iBlogService.save(blog);
        }catch (Exception e){
            e.printStackTrace();
            blogResult.setCode(500);
        }
        return JSONObject.toJSONString(blogResult);

    }

    @GetMapping(value = "/getAll")
    public String getAll(){
        List<Blog> blogs=new ArrayList<>();
        try{
            blogs=iBlogService.list(null);
        }catch (Exception e){
            e.printStackTrace();
        }

        return JSONObject.toJSONString(blogs);
    }

}
