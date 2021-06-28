package com.halcyon.service.impl;

import com.halcyon.entity.TOrder;
import com.halcyon.entity.TOrderinfo;
import com.halcyon.entity.TUserWallet;
import com.halcyon.entity.TWarehouse;
import com.halcyon.mapper.TOrderMapper;
import com.halcyon.mapper.TOrderinfoMapper;
import com.halcyon.mapper.TUserWalletMapper;
import com.halcyon.mapper.TWarehouseMapper;
import com.halcyon.service.IUserWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserWalletServiceImpl implements IUserWalletService {

    @Autowired
    private TUserWalletMapper dao;
    @Autowired
    private TOrderMapper tOrderMapper;
    @Autowired
    private TOrderinfoMapper tOrderinfoMapper;
    @Autowired
    private TWarehouseMapper tWarehouseMapper;

    @Override
    public TUserWallet getTUserWallet(Long userId) {
        return dao.selectByUserId(userId);
    }

    @Override
    //方法抛出异常，就会回滚，数据库里面的数据也会回滚。
    @Transactional(rollbackFor = Exception.class)
    public void paymoney(Long userId, Long orderId, Long orderPrice) {
        TOrder tOrder = new TOrder();
        tOrder.setOrderId(orderId);
        tOrder.setPaystatue("已付款");
        tOrderMapper.updateByPrimaryKey1(tOrder);
        List<TOrderinfo> tOrderinfos = tOrderinfoMapper.selectByOrderId(orderId);
        TWarehouse tWarehouse = null;
        for(TOrderinfo tOrderinfo:tOrderinfos){
            tWarehouse = new TWarehouse();
            tWarehouse.setPid(tOrderinfo.getProId());
            tWarehouse.setPcount(String.valueOf(tOrderinfo.getPcount()));
            tWarehouseMapper.updateTwById1(tWarehouse);
        }
        TUserWallet tUserWallet = new TUserWallet();
        tUserWallet.setUserId(userId);
        tUserWallet.setUserAmount(orderPrice);
        dao.updateByPrimaryKey1(tUserWallet);
    }

    @Override
    public int topupmoney(TUserWallet record) {
        return dao.updateByPrimaryKey(record);
    }
}
