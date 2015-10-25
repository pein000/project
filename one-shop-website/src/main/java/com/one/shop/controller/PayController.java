package com.one.shop.controller;

import com.one.shop.consts.SystemVariable;
import com.one.shop.domain.*;
import com.one.shop.enums.Active;
import com.one.shop.service.CashAccountService;
import com.one.shop.service.PayService;
import com.one.shop.service.PointAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Created by pein on 2015/10/23.
 */
@Controller
@RequestMapping(value = "pay")
public class PayController {

    @Autowired
    private CashAccountService cashAccountService;

    @Autowired
    private PointAccountService pointAccountService;

    @Autowired
    private PayService payService;

    @RequestMapping(value = "toPay",method = RequestMethod.POST)
    public ModelAndView toPay(FullCarList fullCarList, int allAmount ,HttpSession session,  ModelMap modelMap) {
        User user = (User)session.getAttribute(SystemVariable.SESSION_KEY_USER);

        CashAccount cashAccount = cashAccountService.findCashAccountByUser(user);
        PointAccount pointAccount = pointAccountService.findPointAccountByUser(user);
        FullCar[] fullCars = fullCarList.getFullCars();
        modelMap.put("user", user);
        modelMap.put("cashAccount", cashAccount);
        modelMap.put("pointAccount", pointAccount);
        modelMap.put("fullCarList", Arrays.asList(fullCars));
        //总人次
        modelMap.put("allAmount", allAmount);
        return new ModelAndView("/pay/pay_desk");
    }

    /**
     * 直接点击购物
     * @param session
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "directPay",method = RequestMethod.POST)
    public ModelAndView directPay(FullCarData fullCarData, HttpSession session,  ModelMap modelMap) {
        User user = (User)session.getAttribute(SystemVariable.SESSION_KEY_USER);

        CashAccount cashAccount = cashAccountService.findCashAccountByUser(user);
        PointAccount pointAccount = pointAccountService.findPointAccountByUser(user);
        FullCar fullCar = fullCarData.getFullCar();
        fullCar.setActive(Active.TRUE.getCode());
        int allAmount = fullCar.getQuantity();
        modelMap.put("user", user);
        modelMap.put("cashAccount", cashAccount);
        modelMap.put("pointAccount", pointAccount);
        modelMap.put("fullCarList", Arrays.asList(fullCar));
        //总人次
        modelMap.put("allAmount", allAmount);
        return new ModelAndView("/pay/pay_desk");
    }

    @RequestMapping(value = "executePay",method = RequestMethod.POST)
    public ModelAndView executePay(FullCarList fullCarList, PayData payData, HttpSession session,  ModelMap modelMap) {
        User user = (User)session.getAttribute(SystemVariable.SESSION_KEY_USER);

        payService.toPay(user, fullCarList, payData.getPointAccount(), payData.getCashAccount(), payData.getPayAmount());

        return new ModelAndView("/pay/success_pay");
    }

}
