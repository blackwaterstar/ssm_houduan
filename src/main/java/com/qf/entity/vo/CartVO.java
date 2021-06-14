package com.qf.entity.vo;

import java.math.BigDecimal;

public class CartVO {

    /*
     t1.cart_id,t1.user_id,t1.pid,t2.pname,t2.price,t1.pcount
     */

    private Long cartId;
    private Long userId;
    private Long pid;
    private String pname;
    private BigDecimal price;
    private Long pcount;

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getPcount() {
        return pcount;
    }

    public void setPcount(Long pcount) {
        this.pcount = pcount;
    }
}
