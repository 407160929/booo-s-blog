package com.bo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bo.domain.ResponseResult;
import com.bo.domain.dto.AddUserDto;
import com.bo.domain.dto.PutUserDto;
import com.bo.domain.entity.User;


/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2022-12-23 01:21:32
 */
public interface UserService extends IService<User> {

    ResponseResult userInfo();

    ResponseResult updateUserInfo(User user);

    ResponseResult register(User user);

    ResponseResult getUserList(Integer pageNum, Integer pageSize, String userName, String phonenumber, String status);

    ResponseResult addUser(AddUserDto addUserDto);

    ResponseResult deleteUser(Long id);

    ResponseResult getUser(Long id);

    ResponseResult putUser(PutUserDto putUserDto);
}
