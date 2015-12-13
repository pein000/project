package com.online.video.controller;

import com.online.video.entity.VideoEntity;
import com.online.video.enums.Classify;
import com.online.video.enums.SuccessCode;
import com.online.video.service.NativeUploadService;
import com.online.video.service.VideoService;
import com.online.video.util.FfmpegUtils;
import com.online.video.vo.VideoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * Created by pein on 2015/12/8.
 */
@Controller
@RequestMapping("/upload")
public class UploadController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadFileController.class);

    @Autowired
    private NativeUploadService nativeUploadService;

    @Autowired
    private VideoService videoService;

    @Value("${video.ffmpeg.path}")
    private String videoFfmpegPath;
    /**
     * 点击进入视频上传编辑页面
     *
     * @return
     */
    @RequestMapping(value = "to_upload", method = RequestMethod.GET)
    public String toVideo() {
        return "/upload/video_upload";
    }

    /**
     * 点击进入视频上传编辑页面
     *
     * @return
     */
    @RequestMapping(value = "to_upload_file", method = RequestMethod.POST)
    public ModelAndView toVideo(MultipartFile file, ModelMap modelMap) throws IOException {
        VideoResponse response = nativeUploadService.upload("/static/video", file);
        LOGGER.info("success to upload video. ");
        String imageName = FfmpegUtils.processImg(videoFfmpegPath,response.getFullName(),"/static/image");
        response.setImageName(imageName);
        modelMap.put("response", response);
        modelMap.put("classifyList", Classify.values());

        return new ModelAndView("/upload/video_edit");
    }

    private VideoResponse buildSuccessVideoResponse(String fullName) {
        VideoResponse response = new VideoResponse();
        response.setFullName(fullName);
        response.setSuccessCode(SuccessCode.SUCCESS.toString());
        response.setSuccessRemark("视频上传已上传到系统");
        return response;
    }

    private VideoResponse buildFailureVideoResponse() {
        VideoResponse response = new VideoResponse();
        response.setSuccessCode(SuccessCode.FAILURE.toString());
        response.setSuccessRemark("视频上传失败");
        return response;
    }

    @RequestMapping(value = "to_upload_video_item", method = RequestMethod.POST)
    public String  toUploadVideoItem(VideoEntity videoEntity, ModelMap modelMap) {
        LOGGER.info("begin to uploadVideoItem. videoEntity={}. ",videoEntity.toString());
        videoService.uploadVideo(videoEntity);
        LOGGER.info("success to uploadVideoItem. ");
        return "/index";
    }
}
