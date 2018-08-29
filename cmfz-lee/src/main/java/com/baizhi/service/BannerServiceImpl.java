package com.baizhi.service;

import com.baizhi.dao.BannerDAO;
import com.baizhi.entity.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/8/29.
 */
@Service
@Transactional
public class BannerServiceImpl implements BannerService{
    @Autowired
    private BannerDAO bannerDAO;


    @Override
    public List<Banner> queryAll(Integer page, Integer rows) {
        int index=(page-1)*rows;
        List<Banner> banners = bannerDAO.queryAll(index, rows);
        return banners;
    }

    @Override
    public int queryCount() {
        int count = bannerDAO.queryCount();
        return count;
    }

    @Override
    public void save(Banner banner) {
        bannerDAO.save(banner);
    }

    @Override
    public void update(Banner banner) {
        bannerDAO.update(banner);
    }

    @Override
    public void delete(Integer id) {
        bannerDAO.delete(id);
    }

}
