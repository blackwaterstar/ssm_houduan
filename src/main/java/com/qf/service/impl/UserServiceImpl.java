package com.qf.service.impl;

import com.qf.common.util.ResultUtil;
import com.qf.entity.TUser;
import com.qf.entity.dto.ResultDTO;
import com.qf.mapper.TUserMapper;
import com.qf.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {


    @Autowired
    private TUserMapper userMapper;
    public ResultDTO<TUser> login(String userTel, String userPwd) {

        //因为需要传递两个参数到映射文件，因此把参数存入到MAP中
        Map<String,String> map = new HashMap<String,String>();
        map.put("userTel",userTel);
        map.put("userPwd",userPwd);

        TUser user = userMapper.selectByTelAndPwd(map);
        //判断user是否为空，来生成结果
        ResultDTO resultDTO = null;
        if(user==null){
//            resultDTO.setResult(false);
//            resultDTO.setMessage("电话号码或密码错误");
//            resultDTO = ResultUtil.failResult("手机号码或密码错误");
            resultDTO = ResultUtil.failResult(user,"手机号码或密码错误");
        }else{

//            resultDTO.setResult(true);
//            resultDTO.setMessage("登录成功");
            resultDTO = ResultUtil.successResult(user,"登录成功");
        }

        return resultDTO;
    }
}
