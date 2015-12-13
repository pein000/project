package com.one.video.controller;

import com.one.video.entity.VideoEntity;
import com.one.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by pein on 2015/12/6.
 */
@Controller
@RequestMapping("video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @RequestMapping(value = "operate_video", method = RequestMethod.POST)
    public void update(VideoEntity videoEntity){
        videoService.uploadVideo(videoEntity);
    }

}
