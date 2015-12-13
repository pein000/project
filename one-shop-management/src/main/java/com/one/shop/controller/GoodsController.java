package com.one.shop.controller;

import com.one.shop.build.DataBuilder;
import com.one.shop.entity.Goods;
import com.one.shop.entity.PictureGoodsUrl;
import com.one.shop.request.GoodsRequest;
import com.one.shop.service.GoodsManagerService;
import com.one.shop.service.PictureUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
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

    @Value("${picture.outline.url}")
    private String pictureOutlineUrl;

    @Value("${picture.detail.url}")
    private String pictureDetailUrl;

    @Autowired
    private GoodsManagerService goodsManagerService;

    @Autowired
    private PictureUploadService pictureUploadService;
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

    @RequestMapping(value = "to_picture_outline")
    public ModelAndView toPictureOutline(int goodsId ,ModelMap modelMap) {
        Goods goods = goodsManagerService.findGoodsById(goodsId);
        modelMap.put("goodsId", goodsId);
        modelMap.put("goodsOutlineUrl", goods.getOutlineUrl());
        return new ModelAndView("/goods/edit_outline",modelMap);
    }

    @RequestMapping(value = "to_upload_outline")
    public ModelAndView toUploadOutline(MultipartFile file, int goodsId ,ModelMap modelMap, HttpServletRequest request) throws IOException {
        String path = request.getContextPath()+"/"+pictureOutlineUrl;
        pictureUploadService.uploadOutlinePicture(path,file,goodsId);
        return new ModelAndView("/goods/to_picture_outline",modelMap);
    }

    @RequestMapping(value = "to_picture_detail",method = RequestMethod.POST)
    public ModelAndView toPictureDetail(int goodsId ,ModelMap modelMap){
        List<PictureGoodsUrl> pictureGoodsUrlList = pictureUploadService.findDetailPicture(goodsId);
        modelMap.put("goodsId", goodsId);
        modelMap.put("pictureGoodsUrlList", pictureGoodsUrlList);
        return new ModelAndView("/goods/edit_detail",modelMap);
    }

    @RequestMapping(value = "to_upload_detail")
    public ModelAndView toUploadDetail(MultipartFile file, int goodsId ,ModelMap modelMap, HttpServletRequest request) throws IOException {
        String path = request.getContextPath()+"/"+pictureDetailUrl;
        pictureUploadService.uploadDetailPicture(path,file,goodsId);
        return new ModelAndView("/goods/to_picture_detail",modelMap);
    }

}
