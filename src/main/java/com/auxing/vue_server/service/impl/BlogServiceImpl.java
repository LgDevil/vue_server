package com.auxing.vue_server.service.impl;

import com.auxing.vue_server.entity.Blog;
import com.auxing.vue_server.mapper.BlogMapper;
import com.auxing.vue_server.service.IBlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author auxing
 * @since 2019-03-08
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IBlogService {

}
