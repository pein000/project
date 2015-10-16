package com.one.shop.controller;

import com.one.shop.domain.*;
import com.one.shop.service.DetailService;
import com.one.shop.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by pein on 2015/10/13.
 */
@Controller
public class IndexController {


    @Autowired
    private IndexService indexService;

    @Autowired
    private DetailService detailService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView login(ModelMap modelMap) {
        //所有的商品类型记录
        List<Type> typeList = indexService.findAllType();
        //前5条最热商品
        List<Goods> hottestList = indexService.findHottestByPage();
        //前5条最x新商品
        List<Goods> newestList = indexService.findNewestByPage();
        //前5条最新揭晓商品
        List<Goods> revealedList = indexService.findRevealedByPage();

        modelMap.put("typeList", typeList);
        modelMap.put("hottestList", hottestList);
        modelMap.put("newestList", newestList);
        modelMap.put("revealedList", revealedList);

        return new ModelAndView("/index/main", modelMap);
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ModelAndView detail(@RequestParam("goodsId") String goodsId, ModelMap modelMap) {
        //查询商品记录
        Goods goods = detailService.findGoodsById(goodsId);
        //查询商品详情图片
        List<PictureGoodsURL> pictureGoodsURLList = detailService.findPictureGoodsURLByGoodsId(goodsId);

        modelMap.put("goods", goods);
        modelMap.put("pictureGoodsURLList", pictureGoodsURLList);
        return new ModelAndView("/index/detail", modelMap);
    }
}
