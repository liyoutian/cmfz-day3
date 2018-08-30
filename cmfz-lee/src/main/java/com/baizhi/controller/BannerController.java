package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
    public void save(Banner banner, MultipartFile img,HttpServletRequest request){
        //获得当前项目路径
        String realPath = request.getServletContext().getRealPath("/");
        //在当前项目下添加一个目录
        String uploadFilePath = realPath + "upload";
        //在当前目录添加文件
        File file = new File(uploadFilePath);
        //如果文件不存在  创建文件
        if (!file.exists()) {
            file.mkdir();
        }
        //获得原图片名
        String originalFilename = img.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        //获得文件后缀
        String extension = FilenameUtils.getExtension(originalFilename);
        //拼接新文件名
        String newName = uuid + "." + extension;
        try {
            //用新文件名给新文件赋值
            img.transferTo(new File(uploadFilePath, newName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //把文件入库
        String imgPath="/upload/"+newName;
        banner.setImgPath(imgPath);
        bannerService.save(banner);
    }

    @RequestMapping("/update.do")
    public void update(Banner banner){
        bannerService.update(banner);
    }
    @RequestMapping("/delete.do")
    public void delete(Integer id){
        bannerService.delete(id);
    }
}
