package com.online.video.enums;

/**
 * Created by pein on 2015/12/6.
 */

/**
 *类别
 */
public enum Classify {
    teleplay("电视剧"),
    movie("电影"),
    music("音乐"),
    child("少儿"),
    sport("体育"),
    original("原创"),
    game("游戏"),
    other("其他");

    private String name;

    Classify(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
