package com.baizhi.dao;

import com.baizhi.entity.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2018/8/28.
 */
public interface AdminDAO {
    //管理员登陆
    public Admin queryAdmin(@Param("username") String username, @Param("password") String password);
    //添加管理员
    public  void addAdmin(Admin admin);
    /* 删除管理员 */
    public  void delete(Integer id);
}
