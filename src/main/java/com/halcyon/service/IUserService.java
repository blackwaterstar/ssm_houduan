package com.halcyon.service;

import com.halcyon.entity.TUser;
import com.halcyon.entity.dto.ResultDTO;

public interface IUserService {
    ResultDTO<TUser> login(String userId, String userPwd);

    Integer register(TUser user);
}
