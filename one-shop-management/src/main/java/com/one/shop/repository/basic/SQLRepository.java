package com.one.shop.repository.basic;

import com.one.shop.domain.FullGoods;
import com.one.shop.domain.FullRevealed;
import com.one.shop.entity.Goods;
import com.one.shop.entity.Permission;
import com.one.shop.entity.Role;
import com.one.shop.util.RepositoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

/**
 * Created by pein on 2015/11/5.
 */
@Controller
public class SQLRepository {

    @Autowired
    private EntityManager em;

    public EntityManager getEntityManager() {
        return this.em;
    }

    protected FullGoods buildFullDomain(Object[] source) {
        if (source == null || source.length == 0) {
            return null;
        }
        int id = RepositoryUtils.resolveNullToInteger(source[0]);
        int goodsId = RepositoryUtils.resolveNullToInteger(source[1]);
        String createTime = RepositoryUtils.resolveNullToString(source[2]);
        String name = RepositoryUtils.resolveNullToString(source[3]);
        String description = RepositoryUtils.resolveNullToString(source[4]);
        String outlineUrl = RepositoryUtils.resolveNullToString(source[5]);
        int type = RepositoryUtils.resolveNullToInteger(source[6]);
        BigDecimal price = RepositoryUtils.resolveNullToBigDecimal(source[7]);
        int totalAmount = RepositoryUtils.resolveNullToInteger(source[8]);
        int curAmount = RepositoryUtils.resolveNullToInteger(source[9]);
        String status = RepositoryUtils.resolveNullToString(source[10]);

        FullGoods fullGoods = new FullGoods();
        fullGoods.setId(id);
        fullGoods.setGoodsId(goodsId);
        fullGoods.setCreateTime(createTime);
        fullGoods.setName(name);
        fullGoods.setDescription(description);
        fullGoods.setOutlineUrl(outlineUrl);
        fullGoods.setType(type);
        fullGoods.setPrice(price);
        fullGoods.setTotalAmount(totalAmount);
        fullGoods.setCurAmount(curAmount);
        fullGoods.setStatus(status);

        return fullGoods;
    }

    public Goods buildGoodsDomain(Object[] source) {
        if (source == null || source.length == 0) {
            return null;
        }
        int id = RepositoryUtils.resolveNullToInteger(source[0]);
        String name = RepositoryUtils.resolveNullToString(source[1]);
        String description = RepositoryUtils.resolveNullToString(source[2]);
        String outlineUrl = RepositoryUtils.resolveNullToString(source[3]);
        int type = RepositoryUtils.resolveNullToInteger(source[4]);
        BigDecimal price = RepositoryUtils.resolveNullToBigDecimal(source[5]);
        int totalAmount = RepositoryUtils.resolveNullToInteger(source[6]);
        int curAmount = RepositoryUtils.resolveNullToInteger(source[7]);
        String status = RepositoryUtils.resolveNullToString(source[8]);

        Goods goods = new Goods();
        goods.setId(id);
        goods.setName(name);
        goods.setDescription(description);
        goods.setOutlineUrl(outlineUrl);
        goods.setType(type);
        goods.setPrice(price);
        goods.setTotalAmount(totalAmount);
        goods.setCurAmount(curAmount);
        goods.setStatus(status);

        return goods;
    }

    protected Role buildRoleDomain(Object[] source) {
        if (source == null || source.length == 0) {
            return null;
        }
        int id = RepositoryUtils.resolveNullToInteger(source[0]);
        String  name = RepositoryUtils.resolveNullToString(source[1]);
        String description = RepositoryUtils.resolveNullToString(source[2]);

        Role role = new Role();
        role.setId(id);
        role.setName(name);
        role.setDescription(description);

        return role;
    }

    protected Permission buildPermissionDomain(Object[] source) {
        if (source == null || source.length == 0) {
            return null;
        }
        int id = RepositoryUtils.resolveNullToInteger(source[0]);
        String name = RepositoryUtils.resolveNullToString(source[1]);
        String description = RepositoryUtils.resolveNullToString(source[2]);

        Permission permission = new Permission();
        permission.setId(id);
        permission.setPermission(name);
        permission.setDescription(description);

        return permission;
    }

    protected String buildPermissionValueDomain(Object[] source) {
        if (source == null || source.length == 0) {
            return null;
        }
        String name = RepositoryUtils.resolveNullToString(source[0]);

        return name;
    }

    protected FullRevealed buildFullRevealedDomain(Object[] source){
        if (source == null || source.length == 0) {
            return null;
        }

        String rewardMarker = RepositoryUtils.resolveNullToString(source[0]);
        int userId = RepositoryUtils.resolveNullToInteger(source[1]);
        String userName = RepositoryUtils.resolveNullToString(source[2]);
        String userSign = RepositoryUtils.resolveNullToString(source[3]);
        String userPhone = RepositoryUtils.resolveNullToString(source[4]);
        String userEmail = RepositoryUtils.resolveNullToString(source[5]);
        String userAddress = RepositoryUtils.resolveNullToString(source[6]);
        int goodsId = RepositoryUtils.resolveNullToInteger(source[7]);
        String goodsName = RepositoryUtils.resolveNullToString(source[8]);
        String goodsDescription = RepositoryUtils.resolveNullToString(source[9]);
        int goodsType = RepositoryUtils.resolveNullToInteger(source[10]);
        BigDecimal goodsPrice = RepositoryUtils.resolveNullToBigDecimal(source[11]);
        int goodsTotalAmount = RepositoryUtils.resolveNullToInteger(source[12]);
        int goodsCurAmount = RepositoryUtils.resolveNullToInteger(source[13]);
        String goodsStatus = RepositoryUtils.resolveNullToString(source[14]);

        FullRevealed fullRevealed = new FullRevealed();
        fullRevealed.setRewardMarker(rewardMarker);
        fullRevealed.setUserId(userId);
        fullRevealed.setUserName(userName);
        fullRevealed.setUserSign(userSign);
        fullRevealed.setUserPhone(userPhone);
        fullRevealed.setUserEmail(userEmail);
        fullRevealed.setUserAddress(userAddress);
        fullRevealed.setGoodsId(goodsId);
        fullRevealed.setGoodsName(goodsName);
        fullRevealed.setGoodsDescription(goodsDescription);
        fullRevealed.setGoodsType(goodsType);
        fullRevealed.setGoodsPrice(goodsPrice);
        fullRevealed.setGoodsTotalAmount(goodsTotalAmount);
        fullRevealed.setGoodsCurAmount(goodsCurAmount);
        fullRevealed.setGoodsStatus(goodsStatus);

        return fullRevealed;
    }

}
