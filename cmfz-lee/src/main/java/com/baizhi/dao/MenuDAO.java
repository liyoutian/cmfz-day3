package com.baizhi.dao;


import com.baizhi.entity.Menu;

import java.util.List;

/**
 * Created by Administrator on 2018/8/29.
 */
public interface MenuDAO{
    //查询所有的菜单分类
    public List<Menu> queryAll();

}
