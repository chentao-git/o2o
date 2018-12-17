package com.imooc.o2o.service;

import com.imooc.o2o.dto.UserProductMapExecution;
import com.imooc.o2o.entity.UserProductMap;
import com.imooc.o2o.exceptions.UserProductMapOperationException;

public interface UserProductMapService {
    /**
     * 通过传入的查询条件分页列出用户消费信息列表
     * @param userProductCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    UserProductMapExecution listUserProductMap(UserProductMap userProductCondition, Integer pageIndex,
                                               Integer pageSize);

    /**
     * 添加消费记录
     * @param userProductMap
     * @return
     * @throws UserProductMapOperationException
     */
    public UserProductMapExecution addUserProductMap(UserProductMap userProductMap)
            throws UserProductMapOperationException;
}
