package com.one.video.enums;

/**
 * Created by pein on 2015/12/6.
 */

/**
 * ����
 */
public enum Classify {
    teleplay("���Ӿ�"),
    movie("��Ӱ"),
    music("����"),
    child("�ٶ�"),
    sport("����"),
    original("ԭ��"),
    game("��Ϸ"),
    other("����");

    private String name;

    Classify(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
