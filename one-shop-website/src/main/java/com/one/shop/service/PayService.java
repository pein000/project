package com.one.shop.service;

import com.one.shop.check.AmountCheck;
import com.one.shop.domain.*;
import com.one.shop.entity.CashFlowEntity;
import com.one.shop.entity.GoodsFlowEntity;
import com.one.shop.entity.PointFlowEntity;
import com.one.shop.enums.IncomePath;
import com.one.shop.enums.PointType;
import com.one.shop.enums.TradePath;
import com.one.shop.enums.TradeType;
import com.one.shop.repository.CashFlowRepository;
import com.one.shop.repository.GoodsFlowRepository;
import com.one.shop.repository.GoodsRepository;
import com.one.shop.repository.PointFlowRepository;
import com.one.shop.repository.impl.CarRepositoryImpl;
import com.one.shop.repository.impl.CashAccountRepositoryImpl;
import com.one.shop.repository.impl.GoodsRepositoryImpl;
import com.one.shop.repository.impl.PointAccountRepositoryImpl;
import com.one.shop.util.DateUtils;
import com.one.shop.util.ShopUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pein on 2015/10/23.
 */
@Service
public class PayService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PayService.class);

    @Autowired
    private PointAccountRepositoryImpl pointAccountRepository;

    @Autowired
    private PointFlowRepository pointFlowRepository;

    @Autowired
    private CashAccountRepositoryImpl cashAccountRepository;

    @Autowired
    private CashFlowRepository cashFlowRepository;

    @Autowired
    private CarRepositoryImpl carRepository;

    @Autowired
    private GoodsRepositoryImpl goodsRepository;

    @Autowired
    private GoodsFlowRepository goodsFlowRepository;

    /**
     * 支付接口
     * 1 积分、积分流水
     * 2 现金账户、现金账户流水
     * 3 第三方支付、第三方支付流水
     * 4 更新购物车，删除购物车记录
     * 5 添加购物流水
     * 6 更新商品当前数量
     * @param pointAccount
     * @param cashAccount
     * @param payAmount
     */
    @Transactional
    public void toPay(User user, FullCarList fullCarList, PointAccount pointAccount, CashAccount cashAccount, PayAmount payAmount) {
        if(!AmountCheck.enough(payAmount.getAllAmount())){
            return;
        }
        if(AmountCheck.enough(payAmount.getPointAmount().multiply(new BigDecimal(100)),pointAccount.getAmount()) ){
            this.payPointAcccount(pointAccount, payAmount);
            this.insertPointFlow(pointAccount, payAmount);
        }
        if(AmountCheck.enough(payAmount.getCashAmount(),cashAccount.getAmount())){
            this.payCashAcccount(cashAccount, payAmount);
            this.insertCashFlow(cashAccount, payAmount);
        }
        if(AmountCheck.enough(payAmount.getPlatformAmount()) && this.toPlatformPay(payAmount)){
            this.insertPlatformFlow(cashAccount,payAmount);
        }
        this.deleteCar(user);
        this.decreaseGoodsAmount(fullCarList);
        this.insertGoodsFlow(fullCarList);
    }

    private void payPointAcccount(PointAccount pointAccount, PayAmount payAmount) {
        if (pointAccount.getAmount().compareTo(payAmount.getPointAmount()) < 0) {
            LOGGER.info("point amount not enough . pointAmount = {}, payAmount={}", pointAccount.getAmount(), payAmount.getPointAmount());
        }
        BigDecimal amount = payAmount.getPointAmount();
        pointAccountRepository.decreasePoint(pointAccount.getId(), amount);
    }

    private void insertPointFlow(PointAccount pointAccount, PayAmount payAmount) {
        PointFlowEntity pointFlowEntity = new PointFlowEntity();
        pointFlowEntity.setPointId(pointAccount.getId());
        pointFlowEntity.setAmount(payAmount.getPointAmount());
        pointFlowEntity.setIncomePath(IncomePath.SHOPPINGOFFSET);//购物冲抵
        pointFlowEntity.setPointType(PointType.SUB);//扣减积分
        pointFlowEntity.setPointTime(DateUtils.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
        pointFlowRepository.save(pointFlowEntity);
    }

    private void payCashAcccount(CashAccount cashAccount, PayAmount payAmount) {
        if (cashAccount.getAmount().compareTo(payAmount.getCashAmount()) < 0) {
            LOGGER.info("cash amount not enough . cashAmount = {}, payAmount={}", cashAccount.getAmount(), payAmount.getPointAmount());
        }
        BigDecimal amount = payAmount.getCashAmount();
        cashAccountRepository.decreaseCash(cashAccount.getId(), amount);
    }

    private void insertCashFlow(CashAccount cashAccount, PayAmount payAmount) {
        CashFlowEntity cashFlowEntity = new CashFlowEntity();
        cashFlowEntity.setCashId(cashAccount.getId());
        cashFlowEntity.setAmount(payAmount.getCashAmount());
        cashFlowEntity.setTradeType(TradeType.CONSUME);//消费
        cashFlowEntity.setTradePath(TradePath.CASHPAY);//现金账户支付
        cashFlowEntity.setTradeTime(DateUtils.getCurrentDate("yyyy-MM-dd HH:mm:ss"));

        cashFlowRepository.save(cashFlowEntity);
    }

    /**
     * 调用第三方支付
     * 如支付宝、微信支付等
     *
     * @param payAmount
     * @return
     */
    private boolean toPlatformPay(PayAmount payAmount) {
        //todo
        return true;
    }


    private void insertPlatformFlow(CashAccount cashAccount, PayAmount payAmount){
        CashFlowEntity cashFlowEntity = new CashFlowEntity();
        cashFlowEntity.setCashId(cashAccount.getId());
        cashFlowEntity.setAmount(payAmount.getPlatformAmount());
        cashFlowEntity.setTradeType(TradeType.CONSUME);//消费
        cashFlowEntity.setTradePath(TradePath.ALIPAY);//支付宝支付
        cashFlowEntity.setTradeTime(DateUtils.getCurrentDate("yyyy-MM-dd HH:mm:ss"));

        cashFlowRepository.save(cashFlowEntity);
    }

    private void deleteCar(User user) {
        carRepository.deleteCarByUserId(user.getId());
    }

    /**
     * 购物流水
     * 插入购物流水表
     * @param fullCarList
     */
    private void insertGoodsFlow(FullCarList fullCarList) {
        FullCar[] fullCars = fullCarList.getFullCars();
        List<GoodsFlowEntity> goodsFlowEntityList = ShopUtils.convert(Arrays.asList(fullCars),
                                                        GoodsFlowEntity.class,
                                                            "id", "userId", "goodsId", "quantity");
        ShopUtils.setProperties(goodsFlowEntityList,"goodsTime",DateUtils.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
        goodsFlowRepository.save(goodsFlowEntityList);
    }

    private void decreaseGoodsAmount(FullCarList fullCarList) {
        FullCar[] fullCars = fullCarList.getFullCars();
        for (FullCar fullCar : fullCars) {
            int quantity = fullCar.getQuantity();
            int goodsId = fullCar.getGoodsId();
            goodsRepository.addQuantity(goodsId,quantity);
        }
    }


}
