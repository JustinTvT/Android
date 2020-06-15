package com.example.shortvideo;

import java.io.Serializable;

public class RcvVideoBean implements Serializable {
    //定义网络所返回的视频信息的具体内容
    private String feedurl;
    private String nickname;
    private String description;
    private String avatar;
    private int likecount;

    public RcvVideoBean(String feedurl, String nickname, String description, String avatar, int likecount) {
        //定义构造方法，实现视频信息的赋值
        this.feedurl = feedurl;
        this.nickname = nickname;
        this.description = description;
        this.avatar = avatar;
        this.likecount = likecount;
    }
    //定义各信息的get与set方法
    public String getFeedurl() {
        return feedurl;
    }

    public void setFeedurl(String feedurl) {
        this.feedurl = feedurl;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getLikecount() {
        return likecount;
    }

    public void setLikecount(int likecount) {
        this.likecount = likecount;
    }
}
