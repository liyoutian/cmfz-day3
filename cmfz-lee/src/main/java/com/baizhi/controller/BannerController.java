package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/8/29.
 */

@Controller
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;


    @ResponseBody
    @RequestMapping("/showBanner.do")
    public Map<String,Object> showAll(Integer page, Integer rows){
        int count = bannerService.queryCount();
        List<Banner> banners = bannerService.queryAll(page, rows);
        Map map=new HashMap<String,Object>();
        map.put("total",count);
        map.put("rows",banners);

        return map;
    }

    @RequestMapping("/save.do")
    public String save(Banner banner){
        bannerService.save(banner);
        return "index";
    }

    @RequestMapping("/update.do")
    public String update(Banner banner){
        bannerService.update(banner);
        return "index";
    }
    @RequestMapping("/delete.do")
    public String delete(Integer id){
        bannerService.delete(id);
        return "index";
    }
}
