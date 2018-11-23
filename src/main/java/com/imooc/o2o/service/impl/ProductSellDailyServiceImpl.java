package com.imooc.o2o.service.impl;

import com.imooc.o2o.dao.ProductSellDailyDao;
import com.imooc.o2o.service.ProductSellDailyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductSellDailyServiceImpl implements ProductSellDailyService {
    private static final Logger log = LoggerFactory.getLogger(ProductSellDailyServiceImpl.class);

    @Autowired
    private ProductSellDailyDao productSellDailyDao;

    /**
     * 每日定时对所有店铺的商品销量进行统计
     */
    @Override
    public void dailyCalculate() {
         //添加上一天所有销量的产品
         productSellDailyDao.insertProductSellDaily();
         //补充上一天无销量的产品
         log.debug("Quartz 定时跑起来了！！！");
    }
}
