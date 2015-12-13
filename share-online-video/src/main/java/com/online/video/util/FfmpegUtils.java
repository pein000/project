package com.online.video.util;

import com.online.video.controller.UploadFileController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;

/**
 * Created by pein on 2015/12/13.
 */
public class FfmpegUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(FfmpegUtils.class);


    public static final String FFMPEG_PATH = "D:\\software\\ffmpeg-latest-win64-static\\ffmpeg-20151211-git-df2ce13-win64-static\\bin\\ffmpeg.exe";

    /**
     * 截取视频中的一帧，生成图片
     * 必要条件：
     *      服务器必须安装ffmpeg软件（ffmpeg支持windows、linux以及mac）
     * @param videoPath
     * @param imagePath
     * @return
     */
    public static String processImg(String ffmpeg, String videoPath,String imagePath) {
        LOGGER.info("begin to process video to image. ffmpeg = {}, videoPath={}, imagePath={}. ",ffmpeg,videoPath,imagePath);
        File file = new File(videoPath);
        if (!file.exists()) {
            LOGGER.error("路径[" + videoPath + "]对应的视频文件不存在!");
            return null;
        }
        //imgPath+File.separator+videoPath.substring(videoPath.lastIndexOf(File.separator), videoPath.lastIndexOf(".")) + ".jpg"
        File imagDirectory = new File(imagePath);
        if(!imagDirectory.exists()){
            imagDirectory.mkdirs();
        }
        String imageName = imagePath+File.separator+videoPath.substring(videoPath.lastIndexOf(File.separator), videoPath.lastIndexOf(".")) + ".jpg";
        List<String> commands = new java.util.ArrayList<String>();
        commands.add(ffmpeg);
        commands.add("-i");
        commands.add(videoPath);
        commands.add("-y");
        commands.add("-f");
        commands.add("image2");
        commands.add("-ss");
        commands.add("38");//转换视频中的第38帧为图片
        commands.add("-t");
        commands.add("0.001");
        commands.add("-s");
        commands.add("320x240");
        commands.add(imageName);
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(commands);
            builder.start();
            LOGGER.info("success to process video to image. imageName = {}. ",imageName);
            return imageName;
        } catch (Exception e) {
            LOGGER.error("fail to process video to image. e={}. ",e);
            return null;
        }

    }public static boolean processImg(String videoPath,String imgPath) {
        File file = new File(videoPath);
        if (!file.exists()) {
            System.err.println("路径[" + videoPath + "]对应的视频文件不存在!");
            return false;
        }
        List<String> commands = new java.util.ArrayList<String>();
        commands.add(FFMPEG_PATH);
        commands.add("-i");
        commands.add(videoPath);
        commands.add("-y");
        commands.add("-f");
        commands.add("image2");
        commands.add("-ss");
        commands.add("38");
        commands.add("-t");
        commands.add("0.001");
        commands.add("-s");
        commands.add("320x240");
        commands.add(imgPath+File.separator+videoPath.substring(0, videoPath.indexOf(".")) + ".jpg");
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(commands);
            builder.start();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

}
