package com.baizhi.service;

import com.baizhi.dao.AdminDAO;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/8/28.
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminDAO adminDAO;

    @Override
    public Admin queryAdmin(String username, String password) {
        Admin admin = adminDAO.queryAdmin(username, password);
        if(admin==null){
            throw new RuntimeException("对不起，用户名密码错误！");
        }else {
            return admin;
        }
    }

    @Override
    public void addAdmin(Admin admin) {

    }

    @Override
    public void delete(Integer id) {

    }
}
