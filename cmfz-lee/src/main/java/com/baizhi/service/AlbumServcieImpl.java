package com.baizhi.service;

import com.baizhi.dao.AlbumDAO;
import com.baizhi.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/8/30.
 */
@Service
@Transactional
public class AlbumServcieImpl implements AlbumService {
    @Autowired
    private AlbumDAO albumDAO;

    @Override
    public List<Album> queryAll() {
        List<Album> albums = albumDAO.queryAll();
        return albums;
    }
}
