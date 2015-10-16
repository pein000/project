package com.one.shop.service;

import com.one.shop.domain.Goods;
import com.one.shop.domain.PictureGoodsURL;
import com.one.shop.entity.GoodsEntity;
import com.one.shop.entity.PictureGoodsURLEntity;
import com.one.shop.repository.GoodsRepository;
import com.one.shop.repository.PictureGoodsURLRepository;
import com.one.shop.util.ShopUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pein on 2015/10/17.
 */
@Service
public class DetailService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private PictureGoodsURLRepository pictureGoodsURLRepository;

    public Goods findGoodsById(String id) {
        GoodsEntity goodsEntity = goodsRepository.findById(Integer.parseInt(id));
        if (goodsEntity == null) {
            logger.info("find no goods by id. id =" + id);
        }
        Goods goods = ShopUtils.convert(goodsEntity, Goods.class);
        return goods;
    }

    public List<PictureGoodsURL> findPictureGoodsURLByGoodsId(String goodsId) {

        List<PictureGoodsURLEntity> pictureGoodsURLEntityList =
                pictureGoodsURLRepository.findByGoodsId(Integer.parseInt(goodsId));
        if (pictureGoodsURLEntityList == null || pictureGoodsURLEntityList.isEmpty()) {
            logger.info("find no picture goods url by goodsId. goodsId = {}",goodsId);
            return null;
        }
        List<PictureGoodsURL> pictureGoodsURLList = ShopUtils.convert(pictureGoodsURLEntityList, PictureGoodsURL.class);

        return pictureGoodsURLList;

    }
}
