package com.imooc.o2o.service;

import org.springframework.stereotype.Service;

public interface ProductSellDailyService {
    /**
     * 每日定时对所有店铺的商品销量进行统计
     */
    void dailyCalculate();
}
