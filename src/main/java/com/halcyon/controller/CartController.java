package com.halcyon.controller;

import com.halcyon.entity.vo.CartVO;
import com.halcyon.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("cart")
public class CartController {


    @Autowired
    private ICartService cartService;

    @ResponseBody
    @RequestMapping("cartList")
    public List<CartVO> getCartList(Long userId){
        return cartService.getCartVOList(userId);
    }

    @ResponseBody
    @RequestMapping("addCart")
    public List<CartVO> addCart(Long userId){
//       这几获得当前用户的当前购物车信息（所有）
        return cartService.list(userId);

    }
    @ResponseBody
    @RequestMapping(value = "/addCart1",method = RequestMethod.POST)
    public void addCart1(Long userId,Long pid,Long pcount){
//       这几获得当前用户的当前购物车信息（所有）
        cartService.list1(userId,pid,pcount);

    }





}
