package com.baizhi.service;

import com.baizhi.entity.Banner;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Administrator on 2018/8/29.
 */
public interface BannerService {
    //分页查询
    public List<Banner> queryAll(Integer page,Integer rows);
    //查询
    public int queryCount();
    //添加
    public void save(Banner banner);
    //修改
    public void update(Banner banner);
    //删除
    public void delete(Integer id);
}
