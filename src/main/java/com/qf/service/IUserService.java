package com.qf.service;

import com.qf.entity.TUser;
import com.qf.entity.dto.ResultDTO;

public interface IUserService {
    ResultDTO<TUser> login(String userTel, String userPwd);
}
