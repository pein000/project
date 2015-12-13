package com.online.video.controller;

import com.online.video.entity.VideoEntity;
import com.online.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by pein on 2015/12/13.
 */
@Controller
@RequestMapping("play")
public class PlayController {

    @Autowired
    private VideoService videoService;

    @RequestMapping(value = "to_play_video")
    public ModelAndView toPlay(String videoUrl,ModelMap modelMap) {
//        VideoEntity videoEntity = videoService.findVideo(id);
        modelMap.put("videoUrl", videoUrl);
        return new ModelAndView("/play/video_play", modelMap);
    }
}
