package com.one.shop.controller;

import com.one.shop.build.DataBuilder;
import com.one.shop.entity.Goods;
import com.one.shop.request.GoodsRequest;
import com.one.shop.service.GoodsManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by pein on 2015/10/28.
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    private static int PAGE_NUM_NINI = 1;

    @Value("${goods.page.size}")
    private int pageSize;

    @Autowired
    private GoodsManagerService goodsManagerService;

    /**
     * 首次进入查询
     *
     * @param goodsRequest
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "to_goods_index")
    public ModelAndView toGoodsIndex(GoodsRequest goodsRequest, ModelMap modelMap) {
        int totalPage = goodsManagerService.getPageableSize(goodsRequest);
        if (totalPage > 0) {
            List<Goods> goodsList = goodsManagerService.pageableGoods(goodsRequest);
            modelMap.put("goodsList", goodsList);
        }
        modelMap.put("goodsResponse", DataBuilder.buildResponse(PAGE_NUM_NINI, totalPage));

        return new ModelAndView("/goods/goods_index", modelMap);
    }

    /**
     * 查询页面中的查询按钮，以及分页查询
     *
     * @param goodsRequest
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "pageable_goods")
    public ModelAndView pageableGoods(GoodsRequest goodsRequest, ModelMap modelMap) {
        int totalPage = goodsManagerService.getPageableSize(goodsRequest);
        if (totalPage > 0) {
            List<Goods> goodsList = goodsManagerService.pageableGoods(goodsRequest);
            modelMap.put("goodsList", goodsList);
        }
        modelMap.put("goodsResponse", DataBuilder.buildResponse(goodsRequest, totalPage));

        return new ModelAndView("/goods/goods_index", modelMap);
    }


    @RequestMapping(value = "to_edit")
    public ModelAndView toEdit(int id, ModelMap modelMap) {
        Goods goods = goodsManagerService.findGoodsById(id);
        if (goods != null) {
            modelMap.put("goods", goods);
        }
        return new ModelAndView("/goods/goods_edit");
    }

    @RequestMapping(value = "update_goods")
    public ModelAndView updateGoods(Goods goods) {
        goodsManagerService.updateGoods(goods);

        return new ModelAndView("/goods/success_update");
    }

    @RequestMapping(value = "to_shelve")
    public String toShelve() {

        return "/goods/goods_shelve";
    }

    @RequestMapping(value = "to_save_goods")
    public ModelAndView toSaveGoods(Goods goods) {
        goodsManagerService.saveGoods(goods);

        return new ModelAndView("/goods/success_save");
    }

    @RequestMapping(value = "to_delete")
    public String toDelete(int id) {
        goodsManagerService.deleteGoodsById(id);

        return "/goods/success_delete";
    }
}
