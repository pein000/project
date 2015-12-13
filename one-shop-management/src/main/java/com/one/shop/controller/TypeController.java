package com.one.shop.controller;

import com.one.shop.domain.FullGoods;
import com.one.shop.domain.FullRevealed;
import com.one.shop.entity.Goods;
import com.one.shop.entity.HotGoods;
import com.one.shop.entity.NewGoods;
import com.one.shop.entity.RevealedGoods;
import com.one.shop.request.HotGoodsRequest;
import com.one.shop.request.NewGoodsRequest;
import com.one.shop.service.TypeManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pein on 2015/11/3.
 */
@Controller
@RequestMapping(value = "/type")
public class TypeController {

    @Autowired
    private TypeManagerService typeManagerService;

    @RequestMapping(value = "to_hot")
    public ModelAndView toHot(ModelMap modelMap) {

        List<FullGoods> fullGoodsList = typeManagerService.findAllHot();
        List<Goods> goodsList = typeManagerService.findAllNotHotGoods();

        modelMap.put("fullGoodsList", fullGoodsList);
        modelMap.put("goodsList",goodsList);

        return new ModelAndView("/type/hot_edit",modelMap);
    }

    @RequestMapping(value = "update_hot",method = RequestMethod.POST)
    public String updateHot(HotGoodsRequest hotGoodsRequest, ModelMap modelMap) {
        HotGoods[] hotGoodses = hotGoodsRequest.getHotGoodses();
        List<HotGoods> hotGoodsList = new ArrayList<HotGoods>();
        if (hotGoodses != null && hotGoodses.length != 0) {
             hotGoodsList =  Arrays.asList(hotGoodses);
        }
        typeManagerService.updateHotGoodsList(hotGoodsList);

        return "/type/success_update_hot";
    }

    @RequestMapping(value = "to_new")
    public ModelAndView toNew(ModelMap modelMap) {

        List<FullGoods> fullGoodsList = typeManagerService.findAllNew();
        List<Goods> goodsList = typeManagerService.findAllNotNewGoods();

        modelMap.put("fullNewGoodsList", fullGoodsList);
        modelMap.put("goodsList",goodsList);

        return new ModelAndView("/type/new_edit",modelMap);
    }

    @RequestMapping(value = "update_new",method = RequestMethod.POST)
    public String updateNew(NewGoodsRequest newGoodsRequest, ModelMap modelMap) {
        NewGoods[] newGoodses = newGoodsRequest.getNewGoodses();
        List<NewGoods> newGoodsList = new ArrayList<NewGoods>();
        if (newGoodses != null && newGoodses.length != 0) {
            newGoodsList =  Arrays.asList(newGoodses);
        }
        typeManagerService.updateNewGoodsList(newGoodsList);

        return "/type/success_update_new";
    }

    @RequestMapping(value = "to_revealed")
    public ModelAndView toRevealed(ModelMap modelMap){
        List<RevealedGoods> revealedGoodsList = typeManagerService.fundAllRevealedDescTime();
        modelMap.put("revealedGoodsList", revealedGoodsList);

        return new ModelAndView("/type/revealed_profile",modelMap);
    }

    @RequestMapping(value = "to_detail_revealed")
    public ModelAndView toDetailRevealed(int id, ModelMap modelMap) {
        FullRevealed fullRevealed = typeManagerService.findFullRevealedById(id);
        modelMap.put("fullRevealed", fullRevealed);

        return new ModelAndView("/type/revealed_detail",modelMap);
    }
}
