package com.halcyon.service;

import com.halcyon.entity.TCart;
import com.halcyon.entity.vo.CartVO;

import java.util.List;

public interface ICartService {

    List<TCart> getAllCarts(Long userId);




    List<CartVO> list(Long userId, Long pid, Long pcount);
}
