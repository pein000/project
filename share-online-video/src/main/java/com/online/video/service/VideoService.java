package com.online.video.service;

import com.online.video.entity.VideoEntity;
import com.online.video.repository.VideoRepository;
import com.online.video.util.VideoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by pein on 2015/12/6.
 */
@Service
public class VideoService {
    @Autowired
    private VideoRepository videoRepository;

    public void uploadVideo(VideoEntity videoEntity){
        videoEntity.setId(VideoUtils.randomUUID());
        videoEntity.setCreateTime(new Date());
        videoRepository.save(videoEntity);
    }

    public List<VideoEntity>  findVideo() {
        List<VideoEntity> videoEntityList =  videoRepository.findAll();
        System.out.print("findall = "+videoEntityList.size());
        return videoEntityList;
    }

    public VideoEntity findVideo(String id) {
        return videoRepository.findById(id);
    }

}
