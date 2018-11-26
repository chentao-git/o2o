package com.imooc.o2o.service;

import com.imooc.o2o.dto.UserShopMapExecution;
import com.imooc.o2o.entity.UserShopMap;

public interface UserShopMapService {
    public UserShopMapExecution listUserShopMap(UserShopMap userShopMapCondition, int pageIndex, int pageSize);
    public UserShopMap getUserShopMap(long userId, long shopId);

}
