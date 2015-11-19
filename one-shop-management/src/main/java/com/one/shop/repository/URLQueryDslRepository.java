package com.one.shop.repository;

import com.one.shop.entity.PictureGoodsUrl;
import com.one.shop.entity.QPictureGoodsUrl;
import com.one.shop.repository.basic.QuerydslRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pein on 2015/11/12.
 */
@Repository
public class URLQueryDslRepository extends QuerydslRepository<PictureGoodsUrl> {

    private QPictureGoodsUrl qPictureGoodsUrl = QPictureGoodsUrl.pictureGoodsUrl;

    public URLQueryDslRepository() {
        super(PictureGoodsUrl.class);
    }

    public List<PictureGoodsUrl> findPictureByGoodsId(int goodsId) {
        return this.from(qPictureGoodsUrl)
                .where(qPictureGoodsUrl.goodsId.eq(goodsId))
                .list(qPictureGoodsUrl);
    }

    public void insertDetailUrl(String fileName,int goodsId) {
        this.save(buildPictureDetailEntity(fileName, goodsId));
    }

    private PictureGoodsUrl buildPictureDetailEntity(String fileName, int goodsId) {
        PictureGoodsUrl pictureGoodsUrl = new PictureGoodsUrl();
        pictureGoodsUrl.setGoodsId(goodsId);
        pictureGoodsUrl.setUrl(fileName);
        return pictureGoodsUrl;
    }

}
