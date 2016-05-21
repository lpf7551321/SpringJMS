package com.netease.meta.dao;

import com.netease.meta.bean.BaseBean;

/**
 * Created by hz-lpf on 16-5-19.
 */
public interface BaseDao<T extends BaseBean> {
    T findById(int id);

    int update(T t);

    int deleteById(int id);

    int insert(T t);
}
