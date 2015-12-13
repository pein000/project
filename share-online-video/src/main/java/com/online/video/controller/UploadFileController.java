package com.online.video.controller;

import com.online.video.enums.SuccessCode;
import com.online.video.service.NativeUploadService;
import com.online.video.vo.VideoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by pein on 2015/12/8.
 */
@RestController
@RequestMapping("/upload")
public class UploadFileController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadFileController.class);

    @Autowired
    private NativeUploadService nativeUploadService;

    /**
     * 点击进入视频上传编辑页面
     * @return
     */
    @RequestMapping(value = "to_upload_file_ajax")
//    @MultipartConfig(location="/tmp", fileSizeThreshold=1024*1024, maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
    public VideoResponse toVideo(MultipartFile file) {
        VideoResponse response;
        try {
            LOGGER.info("success to upload video. ");
            response = nativeUploadService.upload("/static/video", file);
        } catch (Exception e) {
            LOGGER.error("failure to upload video. e = {}", e);
            response = buildFailureVideoResponse();
        }

        return response;
    }


//    public VideoResponse toVideo(MultipartFile file) {
//        VideoResponse response;
//        try {
//            String fullName = nativeUploadService.upload("/static/video",file);
//            LOGGER.info("success to upload video. ");
//            response = buildSuccessVideoResponse(file,fullName);
//        } catch (IOException e) {
//            LOGGER.error("failure to upload video. e = {}", e);
//            response = buildFailureVideoResponse(file);
//        }
//
//        return response;
//    }



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
}
