package com.baizhi.test;

import com.baizhi.dao.BannerDAO;
import com.baizhi.entity.Banner;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/8/29.
 */
public class TestBanner extends TestCmfz{
    @Autowired
    private BannerDAO bannerDAO;
    @Test
    public void  test1(){
        List<Banner> banners = bannerDAO.queryAll(0,3);
        System.out.println(banners);

    }
    @Test
    public void test2(){

        Banner banner=new Banner();

        banner.setTitle("逼王图片");
        banner.setImgPath("/img/captcha.jpg");
        banner.setDesc("逼王逼王，天下无双");
        banner.setStatus("y");
        banner.setCreateDate(new Date());
        bannerDAO.save(banner);
    }
    @Test
    public void Test3(){
        Banner banner=new Banner(10,"我同桌是傻逼","/img/captcha.jpg","124煞笔一个","n",new Date());
        bannerDAO.update(banner);
    }
    @Test
    public void Test4(){
        bannerDAO.delete(10);
    }
}