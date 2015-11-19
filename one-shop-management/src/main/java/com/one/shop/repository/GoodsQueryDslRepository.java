package com.one.shop.repository;

import com.mysema.query.types.Path;
import com.one.shop.entity.Goods;
import com.one.shop.entity.QGoods;
import com.one.shop.repository.basic.QuerydslRepository;
import com.one.shop.request.GoodsRequest;
import com.one.shop.util.RepositoryUtils;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pein on 2015/10/30.
 */
@Repository
public class GoodsQueryDslRepository extends QuerydslRepository<Goods> {

    private static final QGoods qGoods = QGoods.goods;


    /**
     * Creates a new {@link QueryDslRepositorySupport} instance for the given domain type.
     */
    public GoodsQueryDslRepository() {
        super(Goods.class);
    }

    public List<Goods> pageQuery(GoodsRequest goodsRequest, int pageSize) {
        int pageNum = goodsRequest.getPageNum();
        return this.from(qGoods)
                .where(RepositoryUtils.getEqualExpression(goodsRequest.getName(), qGoods.name),
                        RepositoryUtils.getEqualExpression(goodsRequest.getStatus(), qGoods.status),
                        RepositoryUtils.getGreaterExpression(goodsRequest.getBeginTime(), qGoods.createTime),
                        RepositoryUtils.getLessEqualExpression(goodsRequest.getEndTime(), qGoods.createTime))
                .offset(pageSize * (pageNum - 1)).limit(pageSize)
                .list(qGoods);
    }

    public Long countQuery(GoodsRequest goodsRequest) {
        return this.from(qGoods)
                .where(RepositoryUtils.getEqualExpression(goodsRequest.getName(), qGoods.name),
                        RepositoryUtils.getEqualExpression(goodsRequest.getStatus(), qGoods.status),
                        RepositoryUtils.getGreaterExpression(goodsRequest.getBeginTime(), qGoods.createTime),
                        RepositoryUtils.getLessEqualExpression(goodsRequest.getEndTime(), qGoods.createTime))
                .count();
    }

    public Goods findGoodsById(int id) {
        return this.from(qGoods).where(qGoods.id.eq(id)).singleResult(qGoods);
    }

    public List<Goods> findAllOrderByTime() {
        return this.from(qGoods)
                .orderBy(qGoods.createTime.desc())
                .list(qGoods);
    }

    public void updateGoods(Goods goods) {
        this.update(qGoods)
                .set(buildPathList(qGoods), buildValueList(goods))
                .where(qGoods.id.eq(goods.getId()))
                .execute();
    }

    public void updateGoodsOutlineUrl(String outlineUrl,int goodsId) {
        this.update(qGoods)
                .set(qGoods.outlineUrl, outlineUrl)
                .where(qGoods.id.eq(goodsId))
                .execute();
    }

    public void deleteGoods(int id) {
        this.delete(qGoods).where(qGoods.id.eq(id)).execute();
    }



    private List<Path<?>> buildPathList(QGoods qGoods) {
        List<Path<?>> pathList = new ArrayList<Path<?>>();
        pathList.add(qGoods.name);
        pathList.add(qGoods.description);
        pathList.add(qGoods.outlineUrl);
        pathList.add(qGoods.type);
        pathList.add(qGoods.price);
        pathList.add(qGoods.totalAmount);
        pathList.add(qGoods.curAmount);
        pathList.add(qGoods.status);
        pathList.add(qGoods.createTime);

        return pathList;
    }

    private List<Object> buildValueList(Goods goods) {
        List<Object> valueList = new ArrayList<Object>();
        valueList.add(goods.getName());
        valueList.add(goods.getDescription());
        valueList.add(goods.getOutlineUrl());
        valueList.add(goods.getType());
        valueList.add(goods.getPrice());
        valueList.add(goods.getTotalAmount());
        valueList.add(goods.getCurAmount());
        valueList.add(goods.getStatus());
        valueList.add(goods.getCreateTime());
        return valueList;
    }

}
