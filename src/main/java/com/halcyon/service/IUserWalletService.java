package com.halcyon.service;

import com.halcyon.entity.TUserWallet;

public interface IUserWalletService {
    TUserWallet getTUserWallet(Long userId);

    void paymoney(Long userId, Long orderId, Long orderPrice);
}

