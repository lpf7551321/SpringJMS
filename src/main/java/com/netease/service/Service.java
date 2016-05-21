package com.netease.service;

import com.netease.meta.bean.BaseBean;

/**
 * Created by hz-lpf on 16-5-20.
 */
public interface Service<T extends BaseBean> {
    T findById(int id);

    int update(T t);

    int deleteById(int id);

    int insert(T t);

}
