package com.qf.service;

import com.qf.entity.TCart;
import com.qf.entity.vo.CartVO;

import java.util.List;

public interface ICartService {

    List<TCart> getAllCarts(Long userId);




    List<CartVO> list(Long userId, Long pid, Long pcount);
}
