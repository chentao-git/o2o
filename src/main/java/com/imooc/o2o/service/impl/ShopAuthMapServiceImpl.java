package com.imooc.o2o.service.impl;

import com.imooc.o2o.dao.ShopAuthMapDao;
import com.imooc.o2o.dto.ShopAuthMapExecution;
import com.imooc.o2o.entity.ShopAuthMap;
import com.imooc.o2o.enums.ShopAuthMapStateEnum;
import com.imooc.o2o.exceptions.ShopAuthMapOperationException;
import com.imooc.o2o.service.ShopAuthMapService;
import com.imooc.o2o.util.PageCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ShopAuthMapServiceImpl implements ShopAuthMapService {
    @Autowired
    private ShopAuthMapDao shopAuthMapDao;

    /**
     * 分页列出店铺下面的授权信息及总数
     * @param shopId
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public ShopAuthMapExecution listShopAuthMapByShopId(Long shopId, Integer pageIndex, Integer pageSize) {
        if (shopId != null && pageIndex != null && pageSize != null){
            // 页转行
            int beginIndex = PageCalculator.calculateRowIndex(pageIndex, pageSize);
            // 查询返回该店铺的授权信息列表
            List<ShopAuthMap> shopAuthMapList = shopAuthMapDao.queryShopAuthMapListByShopId(shopId, beginIndex,
                    pageSize);
            // 返回总数
            int count = shopAuthMapDao.queryShopAuthCountByShopId(shopId);
            ShopAuthMapExecution se = new ShopAuthMapExecution();
            se.setShopAuthMapList(shopAuthMapList);
            se.setCount(count);
            return se;
        }else {
            return null;
        }
    }

    /**
     * 通过shopAuthId查询员工授权信息
     * @param shopAuthId
     * @return
     */
    @Override
    public ShopAuthMap getShopAuthMapById(Long shopAuthId) {
        return shopAuthMapDao.queryShopAuthMapById(shopAuthId);
    }

    /**
     * 新增店铺与店员的授权关系
     * @param shopAuthMap
     * @return
     * @throws ShopAuthMapOperationException
     */
    @Override
    public ShopAuthMapExecution addShopAuthMap(ShopAuthMap shopAuthMap) throws ShopAuthMapOperationException {
        // 空值判断，主要是对店铺Id和员工Id做校验
        if (shopAuthMap != null && shopAuthMap.getShop() != null && shopAuthMap.getShop().getShopId() != null
                && shopAuthMap.getEmployee() != null && shopAuthMap.getEmployee().getUserId() != null) {
            shopAuthMap.setCreateTime(new Date());
            shopAuthMap.setLastEditTime(new Date());
            shopAuthMap.setEnableStatus(1);
            shopAuthMap.setTitleFlag(0);
            try {
                // 添加授权信息
                int effectedNum = shopAuthMapDao.insertShopAuthMap(shopAuthMap);
                if (effectedNum <= 0) {
                    throw new ShopAuthMapOperationException("添加授权失败");
                }
                return new ShopAuthMapExecution(ShopAuthMapStateEnum.SUCCESS, shopAuthMap);
            } catch (Exception e) {
                throw new ShopAuthMapOperationException("添加授权失败:" + e.toString());
            }
        } else {
            return new ShopAuthMapExecution(ShopAuthMapStateEnum.NULL_SHOPAUTH_INFO);
        }
    }

    /**
     * 更新授权信息
     * @param shopAuthMap
     * @return
     * @throws ShopAuthMapOperationException
     */
    @Override
    public ShopAuthMapExecution modifyShopAuthMap(ShopAuthMap shopAuthMap) throws ShopAuthMapOperationException {
        // 空值判断，主要是对授权Id做校验
        if (shopAuthMap == null || shopAuthMap.getShopAuthId() == null) {
            return new ShopAuthMapExecution(ShopAuthMapStateEnum.NULL_SHOPAUTH_ID);
        } else {
            try {
                shopAuthMap.setLastEditTime(new Date());
                int effectedNum = shopAuthMapDao.updateShopAuthMap(shopAuthMap);
                if (effectedNum <= 0) {
                    return new ShopAuthMapExecution(ShopAuthMapStateEnum.INNER_ERROR);
                } else {// 创建成功
                    return new ShopAuthMapExecution(ShopAuthMapStateEnum.SUCCESS, shopAuthMap);
                }
            } catch (Exception e) {
                throw new ShopAuthMapOperationException("modifyShopAuthMap error: " + e.getMessage());
            }
        }
    }
}
