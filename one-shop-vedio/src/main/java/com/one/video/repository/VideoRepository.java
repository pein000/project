package com.one.video.repository;

import com.one.video.entity.VideoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by pein on 2015/12/6.
 */
@Repository
@Transactional
public interface VideoRepository extends CrudRepository<VideoEntity,String> {

}
