package com.baizhi.test;

import com.baizhi.CmfzAPP;
import com.baizhi.dao.MenuDAO;
import com.baizhi.entity.Menu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by Administrator on 2018/8/29.
 */
@RunWith(value= SpringRunner.class)
@SpringBootTest(classes = CmfzAPP.class)
public class TestCmfz {
    @Autowired
    private MenuDAO menudao;

    @Test
    public void test1(){
        List<Menu> menus = menudao.queryAll();
        System.out.println(menus);
    }
}
