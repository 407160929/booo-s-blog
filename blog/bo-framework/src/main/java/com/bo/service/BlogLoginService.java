package com.bo.service;

import com.bo.domain.ResponseResult;
import com.bo.domain.entity.User;

public interface BlogLoginService {

    ResponseResult login(User user);

    ResponseResult logout();
}
