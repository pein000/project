package com.one.shop.service;

import com.one.shop.entity.PictureGoodsUrl;
import com.one.shop.repository.GoodsQueryDslRepository;
import com.one.shop.repository.URLQueryDslRepository;
import com.one.shop.util.DateUtils;
import com.one.shop.util.JSONUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;
import java.util.List;

/**
 * Created by pein on 2015/11/11.
 */
@Service
public class PictureUploadService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PictureUploadService.class);

    private static final String FILE_SUFFIEX_NAME = ".JPG";

    @Autowired
    private GoodsQueryDslRepository goodsQueryDslRepository;

    @Autowired
    private URLQueryDslRepository urlQueryDslRepository;

    @Transactional
    public void uploadOutlinePicture(String path, MultipartFile file ,int goodsId) throws IOException {
        String name = generateOutlineName(goodsId);
        LOGGER.info("begin to upload outline picture . goodsId = {},name = {}. ",goodsId,name);
        String fileName = upload(path, name, file);
        goodsQueryDslRepository.updateGoodsOutlineUrl(fileName,goodsId);
        LOGGER.info("success to upload outline picture . goodsId = {},fileName = {}",goodsId,fileName);
    }


    @Transactional
    public void uploadDetailPicture(String path, MultipartFile file ,int goodsId) throws IOException {
        String name = generateDetailName(goodsId);
        LOGGER.info("begin to upload detail picture . goodsId = {},name = {}",goodsId,name);
        String fileName = upload(path, name, file);
        urlQueryDslRepository.insertDetailUrl(fileName, goodsId);
        LOGGER.info("success to upload detail picture . goodsId = {},fileName = {}",goodsId,fileName);
    }


    public List<PictureGoodsUrl> findDetailPicture(int goodsId) {
        List<PictureGoodsUrl> pictureGoodsUrlList = urlQueryDslRepository.findPictureByGoodsId(goodsId);
        if (pictureGoodsUrlList == null || pictureGoodsUrlList.isEmpty()) {
            LOGGER.warn("no detail picture found . goodsId = {}", goodsId);
            return null;
        }
        LOGGER.info("detail picture has founded . pictureGoodsUrlList = {}", JSONUtils.toJson(pictureGoodsUrlList));
        return pictureGoodsUrlList;
    }

    private String upload(String path, String name, MultipartFile file) throws IOException {
        File nativePath = new File(path);
        if (!nativePath.exists()) {
            nativePath.mkdirs();
        }

        String fileName = new StringBuilder(path).append("/").append(name).toString();
        File nativeFile = new File(fileName);
        if (!nativeFile.exists()) {
            nativeFile.createNewFile();
        }
        BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(fileName));
        writer.write(file.getBytes());
        writer.close();
        return fileName;
    }

    private String generateOutlineName(int goodsId) {
        return new StringBuilder().append(goodsId).append(FILE_SUFFIEX_NAME).toString();
    }

    private String generateDetailName(int goodsId) {
        return new StringBuilder().append(goodsId).append("_").append(DateUtils.formatDate(new Date(), "yyyyMMddHHmmss")).append(FILE_SUFFIEX_NAME).toString();
    }
}
