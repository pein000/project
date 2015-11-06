package com.one.shop.controller;

import com.one.shop.consts.SystemVariable;
import com.one.shop.domain.Car;
import com.one.shop.domain.FullCar;
import com.one.shop.domain.User;
import com.one.shop.service.CarService;
import com.one.shop.util.DomainUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by pein on 2015/10/21.
 */
@Controller
@RequestMapping(value = "car")
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping(value = "toCar", method = RequestMethod.GET)
    public ModelAndView toCar(HttpSession session, ModelMap modelMap) {
        User user = (User) session.getAttribute(SystemVariable.SESSION_KEY_USER);
        //根据用户查询当前用户的购物车
        List<FullCar> fullCarList = carService.findFullCarByUserId(user.getId());

        modelMap.put("fullCarList", fullCarList);
        return new ModelAndView("/car/car_profile", modelMap);
    }

    @RequestMapping(value = "addCar", method = RequestMethod.POST)
    public ModelAndView addCar(int goodsId, int quantity, HttpSession session, ModelMap modelMap) {
        User user = (User) session.getAttribute(SystemVariable.SESSION_KEY_USER);
        Car car = DomainUtils.getActiveCarInstance(goodsId, quantity, user);
        carService.save(car);
        //根据用户查询当前用户的购物车
        List<FullCar> fullCarList = carService.findFullCarByUserId(user.getId());

        modelMap.put("fullCarList", fullCarList);
        return new ModelAndView("/car/car_profile", modelMap);
    }


}
