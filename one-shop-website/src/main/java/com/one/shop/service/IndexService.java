package com.one.shop.service;

import com.one.shop.domain.*;
import com.one.shop.entity.*;
import com.one.shop.repository.*;
import com.one.shop.util.ShopUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pein on 2015/10/13.
 */
@Service
public class IndexService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private TypeRepository typeRepository;

//    @Autowired
//    private HottestRepository hottestRepository;

    @Autowired
    private HottestRepositoryImpl hottestRepositoryImpl;

//    @Autowired
//    private NewestRepository newestRepository;

    @Autowired
    private NewestRepositoryImpl newestRepositoryImpl;

//    @Autowired
//    private RevealedRepository revealedRepository;

    @Autowired
    private RevealedRepositoryImpl revealedRepositoryImpl;

    public List<Type> findAllType() {
        Iterable<TypeEntity> typeEntityIterable = typeRepository.findAll();
        List<Type> typeList = ShopUtils.convert(typeEntityIterable, Type.class);
        if (typeList == null || typeList.isEmpty()) {
            logger.info("no type.");
        }
        return typeList;
    }


    /**
     * 分页查询最热商品
     * @return
     */
    public List<Goods> findHottestByPage() {
        List<GoodsEntity> goodsEntityList =  hottestRepositoryImpl.findHottestByPage(0,5);
        List<Goods> goodsList = ShopUtils.convert(goodsEntityList, Goods.class);

        if (goodsList == null || goodsList.isEmpty()) {
            logger.info("no hottest goods");
        }

        return goodsList;
    }

    /**
     * 分页查询最新商品
     * @return
     */
    public List<Goods> findNewestByPage() {
        List<GoodsEntity> goodsEntityList =  newestRepositoryImpl.findNewestByPage(0, 5);
        List<Goods> newestList = ShopUtils.convert(goodsEntityList, Goods.class);

        if (newestList == null || newestList.isEmpty()) {
            logger.info("no newest goods");
        }

        return newestList;
    }

    /**
     * 分页查询最新揭晓商品
     * @return
     */
    public List<Goods> findRevealedByPage() {
        List<GoodsEntity> goodsEntityList = revealedRepositoryImpl.findRevealedByPage(0, 5);
        List<Goods> revealedList = ShopUtils.convert(goodsEntityList, Goods.class);

        if (revealedList == null || revealedList.isEmpty()) {
            logger.info("no revealed goods");
        }

        return revealedList;
    }

}
