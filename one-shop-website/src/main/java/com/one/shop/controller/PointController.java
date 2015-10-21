package com.one.shop.controller;

import com.one.shop.consts.SystemVariable;
import com.one.shop.domain.CashFlow;
import com.one.shop.domain.PointAccount;
import com.one.shop.domain.PointFlow;
import com.one.shop.domain.User;
import com.one.shop.service.PointAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
@RequestMapping(value = "point")
public class PointController {

    @Autowired
    private PointAccountService pointAccountService;

    @Value("${page.account.size}")
    private int pageAccountSize;

    @RequestMapping(value = "toPointAccount", method = RequestMethod.GET)
    public ModelAndView toCashAccount(HttpSession session, ModelMap modelMap) {
        User user = (User) session.getAttribute(SystemVariable.SESSION_KEY_USER);
        PointAccount pointAccount = pointAccountService.findPointAccountByUser(user);
        modelMap.put("pointAccount", pointAccount);

        return new ModelAndView("/point/personal_point", modelMap);
    }

    /**
     * 积分明细
     * @param session
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "toPointFlow",method = RequestMethod.GET)
    public ModelAndView toCashFlow(HttpSession session,ModelMap modelMap) {
        User user = (User)session.getAttribute(SystemVariable.SESSION_KEY_USER);
        //分页查询
        int totalSize = pointAccountService.findPointFlowCount(user.getId());
        modelMap.put("totalSize", totalSize);
        if(totalSize > 0) {
            List<PointFlow> pointFlowList = pointAccountService.findPointFlowByPage(0, pageAccountSize, user.getId());
            modelMap.put("pointFlowList", pointFlowList);
        }

        return new ModelAndView("/point/point_flow", modelMap);
    }
}
