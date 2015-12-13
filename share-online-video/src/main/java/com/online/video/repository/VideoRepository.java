package com.online.video.repository;

import com.online.video.entity.VideoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pein on 2015/12/6.
 */
@Repository
@Transactional
public interface VideoRepository extends CrudRepository<VideoEntity,String> {
    public List<VideoEntity> findAll();

    public VideoEntity findById(String id);
}
