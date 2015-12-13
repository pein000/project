package com.online.video.controller;

import com.online.video.entity.VideoEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by pein on 2015/12/6.
 */
@Controller
@RequestMapping("/video")
public class VideoController {

//    @Autowired
//    private VideoService videoService;

    @RequestMapping(value = "operate_video", method = RequestMethod.POST)
    public void update(VideoEntity videoEntity) {
//        videoService.uploadVideo(videoEntity);
    }

    @RequestMapping(value = "video_index", method = RequestMethod.GET)
    public ModelAndView toVideo() {

        return new ModelAndView("/video/to_video");
    }
}
