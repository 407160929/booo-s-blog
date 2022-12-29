package com.bo.controller;

import com.bo.domain.ResponseResult;
import com.bo.domain.dto.AddUserDto;
import com.bo.domain.dto.PutUserDto;
import com.bo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/system/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/list")
    public ResponseResult getUserList(Integer pageNum,Integer pageSize,String userName,String phonenumber,String status){
        return userService.getUserList(pageNum,pageSize,userName,phonenumber,status);
    }

    @PostMapping
    public ResponseResult addUser(@RequestBody AddUserDto addUserDto){
        return userService.addUser(addUserDto);
    }

    @DeleteMapping("/{id}")
    public ResponseResult deleteUser(@PathVariable(value = "id") Long id){
        return userService.deleteUser(id);
    }

    @GetMapping("/{id}")
    public ResponseResult getUser(@PathVariable(value = "id") Long id){
        return userService.getUser(id);
    }

    @PutMapping
    public ResponseResult putUser(@RequestBody PutUserDto putUserDto){
        return userService.putUser(putUserDto);
    }
}
