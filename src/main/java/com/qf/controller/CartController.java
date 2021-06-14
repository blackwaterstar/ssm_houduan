package com.qf.controller;

import com.qf.entity.vo.CartVO;
import com.qf.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cart")
public class CartController {


    @Autowired
    private ICartService cartService;

    @RequestMapping("cartList")
    public List<CartVO> getCartList(Long userId){
        return null;
    }

    @RequestMapping("addCart")
    public List<CartVO> addCart(Long userId,Long pid,Long pcount){
//       这几获得当前用户的当前购物车信息（所有）
        return cartService.list(userId,pid,pcount);

    }






}
