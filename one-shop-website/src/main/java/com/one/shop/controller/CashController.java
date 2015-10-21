package com.one.shop.controller;

import com.one.shop.consts.SystemVariable;
import com.one.shop.domain.CashAccount;
import com.one.shop.domain.CashFlow;
import com.one.shop.domain.User;
import com.one.shop.service.CashAccountService;
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
 * Created by pein on 2015/10/19.
 */
@Controller
@RequestMapping(value = "cash")
public class CashController {

    @Autowired
    private CashAccountService cashAccountService;

    @Value("${page.account.size}")
    private int pageAccountSize;

    @RequestMapping(value = "toCashAccount",method = RequestMethod.GET)
    public ModelAndView toCashAccount(HttpSession session,ModelMap modelMap) {
        User user = (User)session.getAttribute(SystemVariable.SESSION_KEY_USER);
        CashAccount cashAccount = cashAccountService.findCashAccountByUser(user);
        modelMap.put("cashAccount", cashAccount);

        return new ModelAndView("/cash/personal_cash",modelMap);
    }

    @RequestMapping(value = "toCashFlow",method = RequestMethod.GET)
    public ModelAndView toCashFlow(HttpSession session,ModelMap modelMap) {
        User user = (User)session.getAttribute(SystemVariable.SESSION_KEY_USER);
        //分页查询
        int totalSize = cashAccountService.findCashFlowCount(user.getId());
        modelMap.put("totalSize", totalSize);
        if(totalSize > 0) {
            List<CashFlow> cashFlowList = cashAccountService.findCashFlowByPage(0, pageAccountSize, user.getId());
            modelMap.put("cashFlowList", cashFlowList);
        }

        return new ModelAndView("/cash/cash_flow", modelMap);
    }
}
