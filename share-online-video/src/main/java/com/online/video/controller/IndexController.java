package com.online.video.controller;

import com.online.video.entity.VideoEntity;
import com.online.video.enums.Classify;
import com.online.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by pein on 2015/12/13.
 */
@Controller
public class IndexController {

    @Autowired
    private VideoService videoService;

    @RequestMapping(value = "/index")
    public ModelAndView toIndex(ModelMap modelMap) {

        List<VideoEntity> videoEntityList = videoService.findVideo();
        modelMap.put("classifyList", Classify.values());
        modelMap.put("videoEntityList", videoEntityList);
        return new ModelAndView("/index/video_index", modelMap);
    }
}
