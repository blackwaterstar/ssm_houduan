package com.halcyon.service.impl;

import com.halcyon.common.util.ResultUtil;
import com.halcyon.entity.TUser;
import com.halcyon.entity.dto.ResultDTO;
import com.halcyon.mapper.TUserMapper;
import com.halcyon.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {


    @Autowired
    private TUserMapper userMapper;

    @Override
    public ResultDTO<TUser> login(String userId, String userPwd) {

        //因为需要传递两个参数到映射文件，因此把参数存入到MAP中
        Map<String,String> map = new HashMap<String,String>();
        map.put("userId", userId);
        map.put("userPwd",userPwd);

        TUser user = userMapper.selectByTelAndPwd(map);
        //判断user是否为空，来生成结果
        ResultDTO resultDTO = null;
        if(user==null){
//            resultDTO.setResult(false);
//            resultDTO.setMessage("电话号码或密码错误");
//            resultDTO = ResultUtil.failResult("手机号码或密码错误");
            resultDTO = ResultUtil.failResult(user,"账号或密码错误");
        }else{

//            resultDTO.setResult(true);
//            resultDTO.setMessage("登录成功");
            resultDTO = ResultUtil.successResult(user,"登录成功");
        }

        return resultDTO;
    }

    @Override
    public Integer register(TUser user) {
        return userMapper.register(user);
    }
}
