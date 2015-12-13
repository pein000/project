package com.one.video.service;

import com.one.video.entity.VideoEntity;
import com.one.video.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by pein on 2015/12/6.
 */
@Service
public class VideoService {
    @Autowired
    private VideoRepository vedioRepository;

    public void uploadVideo(VideoEntity vedioEntity){
        vedioRepository.save(vedioEntity);
    }

}
