package com.baizhi.dao;

import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;

import java.util.List;

/**
 * Created by Administrator on 2018/8/30.
 */
public interface AlbumDAO {
    //查询所有的专辑
    public List<Album> queryAll();
}
