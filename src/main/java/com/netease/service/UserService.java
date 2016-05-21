package com.netease.service;

import com.netease.meta.bean.BaseBean;
import com.netease.meta.bean.User;

/**
 * Created by hz-lpf on 16-5-20.
 */
public interface UserService extends Service<User> {
    @Override
    int deleteById(int id);

    @Override
    User findById(int id);

    @Override
    int insert(User user);

    @Override
    int update(User user);
}
