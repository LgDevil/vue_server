package com.auxing.vue_server.service.impl;

import com.auxing.vue_server.entity.User;
import com.auxing.vue_server.mapper.UserMapper;
import com.auxing.vue_server.service.IUserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
