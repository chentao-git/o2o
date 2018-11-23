package com.imooc.o2o.service.impl;

import com.imooc.o2o.dao.UserProductMapDao;
import com.imooc.o2o.dto.UserProductMapExecution;
import com.imooc.o2o.entity.UserProductMap;
import com.imooc.o2o.service.UserProductMapService;
import com.imooc.o2o.util.PageCalculator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserProductMapServiceImpl implements UserProductMapService {
    @Autowired
    private UserProductMapDao userProductMapDao;
    /**
     * 通过传入的查询条件分页列出用户消费信息列表
     * @param userProductCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public UserProductMapExecution listUserProductMap(UserProductMap userProductCondition, Integer pageIndex, Integer pageSize) {
        //判空
        if (userProductCondition != null && pageIndex != null && pageSize != null){
            // 页转行
            int beginIndex = PageCalculator.calculateRowIndex(pageIndex, pageSize);
            //根据条件分页取出列表
            List<UserProductMap> userProductMapList = userProductMapDao.queryUserProductMapList(userProductCondition,beginIndex,pageSize);
            //根据添加查出总数
            int count = userProductMapDao.queryUserProductMapCount(userProductCondition);
            UserProductMapExecution se = new UserProductMapExecution();
            se.setUserProductMapList(userProductMapList);
            se.setCount(count);
            return se;
        }else{
            return null;
        }
    }
}
