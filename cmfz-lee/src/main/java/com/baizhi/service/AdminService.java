package com.baizhi.service;

import com.baizhi.entity.Admin;


/**
 * Created by Administrator on 2018/8/28.
 */
public interface AdminService {
    //管理员登陆
    public Admin queryAdmin(String username, String password);
    //添加管理员
    public  void addAdmin(Admin admin);
    //删除管理员
    public  void delete(Integer id);
}
