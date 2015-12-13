package com.one.shop.schedule;

import com.one.shop.service.RevealService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by pein on 2015/11/9.
 */
@Component
@EnableScheduling
public class RevealScheduler {

    private Logger LOGGER = LoggerFactory.getLogger(RevealScheduler.class);

    @Autowired
    private RevealService revealService;

    @Scheduled(cron = "0 0/1 * * * *")
    public void execute() {
        LOGGER.info("begin to  reveal goods. ");
        revealService.revealGoods();
        LOGGER.info("success to end reveal goods.");
    }
}
