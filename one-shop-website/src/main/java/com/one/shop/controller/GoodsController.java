package com.one.shop.controller;

import com.one.shop.consts.SystemVariable;
import com.one.shop.domain.GoodsFlow;
import com.one.shop.domain.PointAccount;
import com.one.shop.domain.User;
import com.one.shop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by pein on 2015/10/25.
 */
@Controller
@RequestMapping(value = "goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "toGoodsFlow", method = RequestMethod.GET)
    public ModelAndView toGoodsFlow(HttpSession session, ModelMap modelMap) {
        User user = (User) session.getAttribute(SystemVariable.SESSION_KEY_USER);
        List<GoodsFlow> goodsFlowList = goodsService.findGoodsFlowByUserId(user.getId());

        modelMap.put("goodsFlowList", goodsFlowList);

        return new ModelAndView("/goods/goods_flow", modelMap);
    }
}
