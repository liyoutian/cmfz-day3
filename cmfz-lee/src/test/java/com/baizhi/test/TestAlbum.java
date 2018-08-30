package com.baizhi.test;

import com.baizhi.dao.AlbumDAO;

import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2018/8/30.
 */
public class TestAlbum extends TestCmfz{
    @Autowired
    private AlbumDAO albumDAO;

    @Test
    public void test1(){
        List<Album> albums = albumDAO.queryAll();
        for (Album album:albums) {
            List<Chapter> children = album.getChildren();
            for (Chapter c:children) {
                System.out.println(c.getTitle());
            }

        }
    }
}
