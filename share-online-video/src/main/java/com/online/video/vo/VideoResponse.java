package com.online.video.vo;

import java.io.Serializable;

/**
 * Created by pein on 2015/12/10.
 */
public class VideoResponse extends RestResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String fileName;//视频文件名称

    private String fullName;//视频全路径名称

    private String imageName;//图片全路径名称

    public VideoResponse() {
    }

    public VideoResponse(String fileName, String fullName) {
        this.fileName = fileName;
        this.fullName = fullName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
