package com.baizhi.dao;

import com.baizhi.entity.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/8/29.
 */
public interface BannerDAO {
    //分页查询
    public List<Banner> queryAll(@Param("index") Integer index,@Param("rows") Integer rows);
    //查询总条数
    public int queryCount();
    //添加
    public void save(Banner banner);
    //修改
    public void update(Banner banner);
    //删除
    public void delete(Integer id);
}
