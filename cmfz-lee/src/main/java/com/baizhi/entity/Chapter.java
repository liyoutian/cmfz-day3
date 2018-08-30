package com.baizhi.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/8/30.
 */
public class Chapter implements Serializable {
    private Integer id;
    private String title;//章节名
    private String duration;//时长
    private Double size;//文件大小
    private String audloPath;//音频路径

    public Chapter() {
    }

    public Chapter(Integer id, String title, String duration, Double size, String audloPath) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.size = size;
        this.audloPath = audloPath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getAudloPath() {
        return audloPath;
    }

    public void setAudloPath(String audloPath) {
        this.audloPath = audloPath;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration='" + duration + '\'' +
                ", size=" + size +
                ", audloPath='" + audloPath + '\'' +
                '}';
    }
}
