package com.ztwo.fmmall.bean;

import java.math.BigDecimal;

/**
 * @Description 购物车界面显示对象
 * @Author ZTwo
 * @Date 2021/8/9 14:58
 */
public class ShoppingCartVO {
    private Integer cartId;
    private String productId;
    private String skuId;
    private String userId;
    private String cartNum;
    private String cartTime;
    private BigDecimal productPrice;
    private String skuProps;

    //订单商品信息
    private String productName;
    private String url;
    private Double originalPrice;
    private Double sellPrice;
    private String skuName;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCartNum() {
        return cartNum;
    }

    public void setCartNum(String cartNum) {
        this.cartNum = cartNum;
    }

    public String getCartTime() {
        return cartTime;
    }

    public void setCartTime(String cartTime) {
        this.cartTime = cartTime;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public String getSkuProps() {
        return skuProps;
    }

    public void setSkuProps(String skuProps) {
        this.skuProps = skuProps;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    @Override
    public String toString() {
        return "ShoppingCartVO{" +
                "cartId=" + cartId +
                ", productId='" + productId + '\'' +
                ", skuId='" + skuId + '\'' +
                ", userId='" + userId + '\'' +
                ", cartNum='" + cartNum + '\'' +
                ", cartTime='" + cartTime + '\'' +
                ", productPrice=" + productPrice +
                ", skuProps='" + skuProps + '\'' +
                ", productName='" + productName + '\'' +
                ", url='" + url + '\'' +
                ", originalPrice=" + originalPrice +
                ", sellPrice=" + sellPrice +
                ", skuName='" + skuName + '\'' +
                '}';
    }
}
