package com.imooc.o2o.dto;

/**
 * 用来接收平台二维码的信息
 * @author xiangze
 *
 */
public class WechatInfo {
    private Long customerId; //二维码携带的店员，顾客id
    private Long productId; //二维码携带的产品id
    private Long userAwardId; //二维码携带的奖品id
    private Long createTime; //二维码携带的创建时间
    private Long shopId;//店铺id

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getUserAwardId() {
        return userAwardId;
    }

    public void setUserAwardId(Long userAwardId) {
        this.userAwardId = userAwardId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

}
